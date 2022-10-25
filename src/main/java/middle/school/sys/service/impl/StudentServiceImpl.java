package middle.school.sys.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.alibaba.druid.util.StringUtils;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import middle.school.common.utils.*;
import middle.school.sys.dao.StudentDao;
import middle.school.sys.entity.StudentEntity;
import middle.school.sys.entity.dto.LoginDTO;
import middle.school.sys.service.AdminService;
import middle.school.sys.service.ParentService;
import middle.school.sys.service.StudentService;
import middle.school.sys.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.util.Map;


@Service("studentService")
public class StudentServiceImpl extends ServiceImpl<StudentDao, StudentEntity> implements StudentService {

    @Autowired
    TeacherService teacherService;
    @Autowired
    ParentService parentService;
    @Autowired
    AdminService adminService;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        QueryWrapper<StudentEntity> queryWrapper = new QueryWrapper<>();
        String studentName = (String)params.get("studentName");
        if(!StringUtils.isEmpty(studentName)){
            queryWrapper.eq("username",studentName);
        }

        Object classId =  params.get("classId");
        if(classId!=null){
            queryWrapper.eq("class_id",classId);
        }
        IPage<StudentEntity> page = this.page(
                new Query<StudentEntity>().getPage(params),
                queryWrapper
        );

        return new PageUtils(page);
    }

    @Override
    public Response studentLogin(LoginDTO loginDTO) {
        QueryWrapper<StudentEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(StudentEntity::getUsername, loginDTO.getUsername())
                .eq(StudentEntity::getPassword, loginDTO.getPassword());
        StudentEntity one = this.getOne(queryWrapper);
        if (ObjectUtil.isEmpty(one)) {
            return Response.build(ResponseCode.ERROR, "用户名或密码错误");
        }
        String token = JwtUtil.createToken(one);
        one.setToken(token);
        return Response.build(ResponseCode.SUCCESS, "登录成功", one);
    }

    @Override
    public Response login(LoginDTO loginDTO) {
        if (loginDTO.getRole().equals("admin")){
            return adminService.adminLogin(loginDTO);
        }else if (loginDTO.getRole().equals("teacher")){
            return teacherService.teacherLogin(loginDTO);
        }else if (loginDTO.getRole().equals("parent")){
            return parentService.parentLogin(loginDTO);
        }
        return Response.build(ResponseCode.ERROR,"请输入选择正确的身份");
    }

    @Override
    public Integer deleteStuPar(int id) {
      int b = this.baseMapper.deleteStuPar(id);
        return b;
    }

}