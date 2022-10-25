package middle.school.sys.controller;

import java.util.Arrays;
import java.util.Map;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import middle.school.sys.entity.CourseEntity;
import middle.school.sys.service.CourseService;
import middle.school.common.utils.PageUtils;
import middle.school.common.utils.R;



/**
 * 
 *
 * @author
 * @email none@gmail.com
 * @date 2022-02-26 14:17:19
 */
@RestController
@RequestMapping("sys/course")
@Api(value = "测试接口", tags = "课程管理相关的接口", description = "课程管理接口")
public class CourseController {
    @Autowired
    private CourseService courseService;

    /**
     * 列表
     */
    @GetMapping("/list")
    @ApiOperation(value = "查看课程列表",notes = "查看课程列表")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = courseService.queryPage(params);

        return R.ok().put("data", page);
    }


    /**
     * 信息
     */
    @GetMapping("/info/{id}")
    @ApiOperation(value = "根据id获取课程信息", notes = "根据id获取课程信息")
    public R info(@PathVariable("id") Integer id){
		CourseEntity course = courseService.getById(id);

        return R.ok().put("data", course);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    @ApiOperation(value = "保存课程信息", notes = "保存课程信息")
    public R save(@RequestBody CourseEntity course){
		courseService.save(course);

        return R.ok();
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    @ApiOperation(value = "修改课程信息",notes = "修改课程信息")
    public R update(@RequestBody CourseEntity course){
		courseService.updateById(course);

        return R.ok();
    }

    /**
     * 删除
     */
    @DeleteMapping("/delete")
    @ApiOperation(value = "根据id删除课程",notes = "根据id删除课程")
    public R delete(@RequestBody Integer[] ids){
		courseService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
