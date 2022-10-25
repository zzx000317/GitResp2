package middle.school.sys.service.impl;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.jwt.JWTUtil;
import com.alibaba.druid.util.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import middle.school.common.utils.*;
import middle.school.sys.entity.ClassEntity;
import middle.school.sys.entity.CourseEntity;
import middle.school.sys.entity.TeacherClassEntity;
import middle.school.sys.entity.dto.GetListDTO;
import middle.school.sys.entity.dto.LoginDTO;
import middle.school.sys.service.ClassService;
import middle.school.sys.service.CourseService;
import middle.school.sys.service.TeacherClassService;
import org.apache.commons.lang.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import middle.school.sys.dao.TeacherDao;
import middle.school.sys.entity.TeacherEntity;
import middle.school.sys.service.TeacherService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Service("teacherService")
public class TeacherServiceImpl extends ServiceImpl<TeacherDao, TeacherEntity> implements TeacherService {

    @Autowired
    ClassService classService;
    @Autowired
    TeacherClassService teacherClassService;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        QueryWrapper<TeacherEntity> queryWrapper = new QueryWrapper<>();
        String username = (String)params.get("userName");
        if(!StringUtils.isEmpty(username)){
            queryWrapper.eq("username",username);
        }
        IPage<TeacherEntity> page = this.page(
                new Query<TeacherEntity>().getPage(params),
                new QueryWrapper<TeacherEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public Response teacherLogin(LoginDTO loginDTO) {
        QueryWrapper<TeacherEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(TeacherEntity::getUsername,loginDTO.getUsername())
                .eq(TeacherEntity::getPassword,loginDTO.getPassword());
        TeacherEntity one = this.getOne(queryWrapper);
        if (ObjectUtil.isEmpty(one)){
            return Response.build(ResponseCode.ERROR,"用户名或密码错误");
        }
        String token = JwtUtil.createToken(one,loginDTO.getRole());
        one.setToken(token);
        return Response.build(ResponseCode.SUCCESS,"登录成功",one);
    }

    @Override
    public Response saveTeacher(TeacherEntity teacher) {
        QueryWrapper<ClassEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(ClassEntity::getId,teacher.getClassId());
        ClassEntity one = classService.getOne(queryWrapper);
        if (ObjectUtil.isEmpty(one)){
            return Response.build(ResponseCode.ERROR,"教室ID不存在");
        }
        this.save(teacher);
        TeacherClassEntity teacherClassEntity = new TeacherClassEntity();
        teacherClassEntity.setTeacherId(teacher.getId());
        teacherClassEntity.setClassId(teacher.getClassId());
        teacherClassService.save(teacherClassEntity);
        return Response.success();
    }

    @Override
    public IPage<TeacherEntity> getTeacherList(GetListDTO getListDTO) {
        Page<TeacherEntity> page = new Page<>(getListDTO.getPage(), getListDTO.getPer_page());
        IPage<TeacherEntity> teacherEntityIPage= this.getBaseMapper().getTeacherList(page,getListDTO);
        return teacherEntityIPage;
    }

    @Override
    public Response getUserInfo(HttpServletRequest request) {
        String header = request.getHeader("X-Token");
        HashMap<String, Object> hashMap = JwtUtil.parseToken(header);
        return Response.build(ResponseCode.SUCCESS,hashMap);
    }

    @Override
    public Integer deleteTeaCla(int id) {
        return this.baseMapper.deleteTeaCla(id);
    }

}