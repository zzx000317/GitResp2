package middle.school.sys.controller;

import java.util.Arrays;
import java.util.Map;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import middle.school.common.controller.BaseController;
import middle.school.common.utils.Response;
import middle.school.common.utils.ResponseCode;
import middle.school.sys.entity.dto.GetListDTO;
import middle.school.sys.entity.dto.LoginDTO;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import middle.school.sys.entity.TeacherEntity;
import middle.school.sys.service.TeacherService;
import middle.school.common.utils.PageUtils;
import middle.school.common.utils.R;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * 
 *
 * @author
 * @email none@gmail.com
 * @date 2022-02-26 14:17:19
 */
@RestController
@RequestMapping("sys/teacher")
@Api(value = "测试接口", tags = "老师管理相关的接口", description = "老师管理接口")
public class TeacherController extends BaseController {
    @Autowired
    private TeacherService teacherService;

    /**
     * 列表
     */
    @GetMapping("/list")
    @ApiOperation(value="查询老师列表")
    public Response list(GetListDTO getListDTO){
        return Response.build(ResponseCode.SUCCESS,getDataTable(teacherService.getTeacherList(getListDTO)));
    }


    /**
     * 信息
     */
    @GetMapping("/info/{id}")
    @ApiOperation(value = "根据id获取老师信息", notes = "根据id查询老师信息")
    public R info(@PathVariable("id") Integer id){
		TeacherEntity teacher = teacherService.getById(id);
        return R.ok().put("data", teacher);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    @ApiOperation(value = "保存老师信息", notes = "保存老师信息")
    public Response save(@RequestBody TeacherEntity teacher){
        return teacherService.saveTeacher(teacher);
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    @ApiOperation(value = "修改老师信息",notes = "修改老师信息")
    public R update(@RequestBody TeacherEntity teacher){
		teacherService.updateById(teacher);
        return R.ok();
    }

    /**
     * 删除
     */
    @DeleteMapping("/delete/{id}")
    @ApiOperation(value = "根据id删除老师",notes = "根据id删除老师")
    public R delete(@PathVariable("id") Integer id){
		teacherService.removeById(id);
		teacherService.deleteTeaCla(id);
        return R.ok();
    }

    @PostMapping(value = "/teacher_login")
    @ApiOperation(value = "老师登录",notes = "老师登录")
    public Response teacherLogin(@RequestBody LoginDTO loginDTO){
        return teacherService.teacherLogin(loginDTO);
    }

    @GetMapping(value = "/get_user_info")
    @ApiOperation(value = "获取用户信息",notes = "获取用户信息")
    public Response getUserInfo(HttpServletRequest request){
        return teacherService.getUserInfo(request);
    }

}
