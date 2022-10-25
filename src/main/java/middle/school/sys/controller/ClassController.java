package middle.school.sys.controller;

import java.util.Arrays;
import java.util.Map;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import middle.school.sys.entity.ClassEntity;
import middle.school.sys.service.ClassService;
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
@RequestMapping("sys/classInfo")
@Api(value = "测试接口", tags = "班级管理相关的接口", description = "班级管理接口")
public class ClassController {
    @Autowired
    private ClassService classService;

    /**
     * 列表
     */
    @GetMapping("/list")
    @ApiOperation(value="查询班级列表")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = classService.queryPage(params);
        return R.ok().put("data", page);
    }


    /**
     * 信息
     */
    @GetMapping("/info/{id}")
    @ApiOperation(value = "根据id获取班级信息", notes = "根据id查询班级信息")
    public R info(@PathVariable("id") Integer id){
		ClassEntity classDto = classService.getById(id);
        return R.ok().put("data", classDto);
    }

    /**
     * 保存
     */
    @PostMapping(value = "/save", consumes = "application/json")
    @ApiOperation(value = "保存班级信息", notes = "保存班级信息")
    public R save(@RequestBody ClassEntity classDto){
		classService.save(classDto);
        return R.ok();
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    @ApiOperation(value = "修改班级信息",notes = "修改班级信息")
    public R update(@RequestBody ClassEntity classDto){
		classService.updateById(classDto);
        return R.ok();
    }

    /**
     * 删除
     */
    @DeleteMapping("/delete/{id}")
    @ApiOperation(value = "根据id删除班级",notes = "根据id删除班级")
    public R delete(@PathVariable("id")Integer id){
		classService.removeById(id);
classService.deleteClaTea(id);
        return R.ok();
    }

}
