package middle.school.sys.controller;

import java.util.Arrays;
import java.util.Map;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import middle.school.common.controller.BaseController;
import middle.school.common.utils.Response;
import middle.school.common.utils.ResponseCode;
import middle.school.sys.entity.dto.GetListDTO;
import middle.school.sys.entity.dto.GetScoreDto;
import middle.school.sys.entity.dto.LoginDTO;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import middle.school.sys.entity.ParentEntity;
import middle.school.sys.service.ParentService;
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
@RequestMapping("sys/parent")
@Api(value = "测试接口", tags = "家长管理相关的接口", description = "家长管理接口")
public class ParentController extends BaseController {
    @Autowired
    private ParentService parentService;

    /**
     * 列表
     */
    @GetMapping("/list")
    @ApiOperation(value="查询家长列表")
    public Response list( GetListDTO getListDTO){
        return Response.build(ResponseCode.SUCCESS,getDataTable(parentService.getParentList(getListDTO)));
    }


    /**
     * 信息
     */
    @GetMapping("/info/{id}")
    @ApiOperation(value = "根据id获取家长信息", notes = "根据id查询家长信息")
    public R info(@PathVariable("id") Integer id){
		ParentEntity parent = parentService.getById(id);

        return R.ok().put("data", parent);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    @ApiOperation(value = "保存家长信息", notes = "保存家长信息")
    public Response save(@RequestBody ParentEntity parent){
        return parentService.saveParent(parent);
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    @ApiOperation(value = "修改家长信息",notes = "修改家长信息")
    public R update(@RequestBody ParentEntity parent){

		parentService.updateById(parent);

        return R.ok();
    }

    /**
     * 删除
     */
    @DeleteMapping("/delete/{id}")
    @ApiOperation(value = "根据id删除家长",notes = "根据id删除家长")
    public R delete(@PathVariable("id") Integer id){
		parentService.removeById(id);
parentService.deleteParStu(id);
        return R.ok();
    }

    @PostMapping(value = "/parent_login")
    @ApiOperation(value = "家长登录",notes = "家长登录")
    public Response parentLogin(@RequestBody LoginDTO loginDTO){
        return parentService.parentLogin(loginDTO);
    }

    @GetMapping(value = "/get_score")
    @ApiOperation(value = "查询成绩",notes = "查询成绩")
    public Response getScore(GetScoreDto getScoreDto){
        return parentService.getScore(getScoreDto);
    }

}
