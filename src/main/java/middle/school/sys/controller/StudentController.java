package middle.school.sys.controller;

import java.util.Arrays;
import java.util.Map;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import middle.school.common.utils.Response;
import middle.school.sys.entity.dto.LoginDTO;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import middle.school.sys.entity.StudentEntity;
import middle.school.sys.service.StudentService;
import middle.school.common.utils.PageUtils;
import middle.school.common.utils.R;

import javax.servlet.http.HttpServletResponse;


/**
 * 
 *
 * @author
 * @email none@gmail.com
 * @date 2022-02-26 14:17:19
 */
@RestController
@RequestMapping("sys/student")
@Api(value = "测试接口", tags = "学生管理相关的接口", description = "学生管理接口")
public class StudentController {
    @Autowired
    private StudentService studentService;

    /**
     * 列表
     */
    @GetMapping("/list")
    @ApiOperation(value="查询学生列表")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = studentService.queryPage(params);

        return R.ok().put("data", page);
    }


    /**
     * 信息
     */
    @GetMapping("/info/{id}")
    @ApiOperation(value = "根据id获取学生信息", notes = "根据id查询学生信息")
    public R info(@PathVariable("id") Integer id){
		StudentEntity student = studentService.getById(id);

        return R.ok().put("data", student);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    @ApiOperation(value = "保存学生信息", notes = "保存学生信息")
    public R save(@RequestBody StudentEntity student){
		studentService.save(student);

        return R.ok();
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    @ApiOperation(value = "修改学生信息",notes = "修改学生信息")
    public R update(@RequestBody StudentEntity student){
		studentService.updateById(student);

        return R.ok();
    }

    /**
     * 删除
     */
    @DeleteMapping("/delete/{id}")
    @ApiOperation(value = "根据id删除学生",notes = "根据id删除学生")
    public R delete(@PathVariable("id") Integer id){

		studentService.removeById(id);
studentService.deleteStuPar(id);
        return R.ok();
    }

    @PostMapping(value = "/student_login")
    @ApiOperation(value = "学生登录",notes = "学生登录")
    public Response studentLogin(@RequestBody LoginDTO loginDTO){
        return studentService.studentLogin(loginDTO);
    }

    @PostMapping(value = "/login",consumes = "application/json")
    @ApiOperation(value = "登录",notes = "登录")
    public Response login(@RequestBody LoginDTO loginDTO){
        return studentService.login(loginDTO);
    }

}
