package middle.school.sys.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import middle.school.common.utils.*;
import middle.school.sys.entity.ScoreEntity;
import middle.school.sys.entity.StudentEntity;
import middle.school.sys.entity.StudentParentEntity;
import middle.school.sys.entity.dto.GetListDTO;
import middle.school.sys.entity.dto.GetScoreDto;
import middle.school.sys.entity.dto.LoginDTO;
import middle.school.sys.entity.vo.StudentScoreVo;
import middle.school.sys.service.StudentParentService;
import middle.school.sys.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import middle.school.sys.dao.ParentDao;
import middle.school.sys.entity.ParentEntity;
import middle.school.sys.service.ParentService;

import javax.servlet.http.HttpServletResponse;


@Service("parentService")
public class ParentServiceImpl extends ServiceImpl<ParentDao, ParentEntity> implements ParentService {

    @Autowired
    StudentService studentService;
    @Autowired
    StudentParentService studentParentService;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<ParentEntity> page = this.page(
                new Query<ParentEntity>().getPage(params),
                new QueryWrapper<ParentEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public Response parentLogin(LoginDTO loginDTO) {
        QueryWrapper<ParentEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(ParentEntity::getUsername,loginDTO.getUsername())
                .eq(ParentEntity::getPassword,loginDTO.getPassword());
        ParentEntity one = this.getOne(queryWrapper);
        if (ObjectUtil.isEmpty(one)){
            return Response.build(ResponseCode.ERROR,"用户名或密码错误");
        }
        String token = JwtUtil.createToken(one);
        one.setToken(token);
        return Response.build(ResponseCode.SUCCESS,"登录成功",one);
    }

    @Override
    public Response saveParent(ParentEntity parent) {
        QueryWrapper<StudentEntity> queryWrapper  = new QueryWrapper<>();
        queryWrapper.lambda().eq(StudentEntity::getId,parent.getStudentId());
        StudentEntity one = studentService.getOne(queryWrapper);
        if (ObjectUtil.isEmpty(one)){
            return Response.build(ResponseCode.ERROR,"学生学号不存在");
        }
        this.save(parent);
        StudentParentEntity studentParentEntity = new StudentParentEntity();
        studentParentEntity.setParentId(parent.getId());
        studentParentEntity.setStudentId(parent.getStudentId());
        studentParentService.save(studentParentEntity);
        return Response.success();
    }
    @Override
    public IPage<ParentEntity> getParentList(GetListDTO getListDTO) {
        Page<ParentEntity> page = new Page<>(getListDTO.getPage(), getListDTO.getPer_page());
        IPage<ParentEntity> parentEntityIPage= this.getBaseMapper().getParentList(page,getListDTO);
        return parentEntityIPage;
    }

    @Override
    public Integer deleteParStu(int id) {
        return this.baseMapper.deleteParStu(id);
    }

    @Override
    public Response getScore(GetScoreDto getScoreDto) {
        QueryWrapper<StudentParentEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(StudentParentEntity::getParentId,getScoreDto.getParent_id());
        List<StudentParentEntity> studentParentEntities = studentParentService.getBaseMapper().selectList(queryWrapper);
        List<Integer> collect = studentParentEntities.stream().map(StudentParentEntity::getStudentId).collect(Collectors.toList());
        List<StudentScoreVo> list = this.getBaseMapper().selectList(collect);
        return Response.build(ResponseCode.SUCCESS,list);
    }

}