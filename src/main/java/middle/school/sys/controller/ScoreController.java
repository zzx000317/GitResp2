package middle.school.sys.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import middle.school.common.controller.BaseController;
import middle.school.common.utils.*;
import middle.school.sys.entity.dto.GetListDTO;
import middle.school.sys.entity.vo.ScoreVo;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import middle.school.sys.entity.ScoreEntity;
import middle.school.sys.service.ScoreService;

import javax.servlet.http.HttpServletRequest;


/**
 * 
 *
 * @author
 * @email none@gmail.com
 * @date 2022-02-26 14:17:19
 */
@RestController
@RequestMapping("sys/score")
@Api(value = "测试接口", tags = "成绩相关的接口", description = "成绩管理接口")
public class ScoreController extends BaseController {
    @Autowired
    private ScoreService scoreService;

    /**
     * 列表
     */
    @GetMapping("/list")
    @ApiOperation(value="查询成绩列表")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = scoreService.queryPage(params);

        return R.ok().put("page", page);
    }

    @GetMapping(value = "getScoreTea")
    @ApiOperation(value="教师查询成绩列表")
    public Response getScoreTea(GetListDTO getListDTO, HttpServletRequest request){
        return Response.build(ResponseCode.SUCCESS,getDataTable(scoreService.getScoreTea(getListDTO,request)));
    }

    @GetMapping(value = "getScorePar")
    @ApiOperation(value="家长查询成绩列表")
    public Response getScorePar(GetListDTO getListDTO, HttpServletRequest request){
        return Response.build(ResponseCode.SUCCESS,getDataTable(scoreService.getScorePar(getListDTO,request)));
    }

    /**
     * 信息
     */
    @GetMapping("/info/{id}")
    @ApiOperation(value = "根据id获取成绩信息", notes = "根据id查询成绩信息")
    public R info(@PathVariable("id") Integer id){
		ScoreEntity score = scoreService.getById(id);

        return R.ok().put("score", score);
    }

    @GetMapping("/tableinfo/{id}")
    @ApiOperation(value = "根据id获取成绩信息", notes = "根据id查询成绩信息")
    public R tableinfo(@PathVariable("id") Integer id){
        ScoreEntity score = scoreService.getById(id);
        ScoreVo s1 = new ScoreVo();
        ScoreVo s2 = new ScoreVo();
        ScoreVo s3 = new ScoreVo();
        ScoreVo s4 = new ScoreVo();
        ScoreVo s5 = new ScoreVo();
        ScoreVo s6 = new ScoreVo();
        ScoreVo s7 = new ScoreVo();
        ScoreVo s8 = new ScoreVo();
        ScoreVo s9 = new ScoreVo();
        ScoreVo s10 = new ScoreVo();
        ScoreVo s11 = new ScoreVo();
        ScoreVo s12 = new ScoreVo();

        ScoreVo[] scoreVos = new ScoreVo[12];
        s1.setCourseName("语文");
        s1.setScore(score.getChineseScore());
        scoreVos[0]=s1;

        s2.setCourseName("数学");
        s2.setScore(score.getMathScore());
        scoreVos[1]=s2;

        s3.setCourseName("英语");
        s3.setScore(score.getEnglishScore());
        scoreVos[2]=s3;

        s4.setCourseName("物理");
        s4.setScore(score.getPhysicsScore());
        scoreVos[3]=s4;
        s5.setCourseName("化学");
        s5.setScore(score.getChemistryScore());
        scoreVos[4]=s5;
        s6.setCourseName("生物");
        s6.setScore(score.getBiologyScore());
        scoreVos[5]=s6;
        s7.setCourseName("政治");
        s7.setScore(score.getPoliticsScore());
        scoreVos[6]=s7;
        s8.setCourseName("历史");
        s8.setScore(score.getHistoryScore());
        scoreVos[7]=s8;
        s9.setCourseName("地理");
        s9.setScore(score.getGeographyScore());
        scoreVos[8]=s9;
        s10.setCourseName("美术");
        s10.setScore(score.getPaintingScore());
        scoreVos[9]=s10;
        s11.setCourseName("体育");
        s11.setScore(score.getSportsScore());
        scoreVos[10]=s11;
        s12.setCourseName("音乐");
        s12.setScore(score.getMusicScore());
        scoreVos[11]=s12;



        return R.ok().put("score", scoreVos);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    @ApiOperation(value = "保存成绩信息", notes = "保存成绩信息")
    public R save(@RequestBody ScoreEntity score, HttpServletRequest request){
        String header = request.getHeader("X-Token");
        HashMap<String, Object> hashMap = JwtUtil.parseToken(header);
        Object uid = hashMap.get("uid");
        Integer teacherId = (Integer) uid;
        score.setTeacherId(teacherId);
		scoreService.save(score);

        return R.ok();
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    @ApiOperation(value = "修改成绩信息",notes = "修改成绩信息")
    public R update(@RequestBody ScoreEntity score){
		scoreService.updateById(score);

        return R.ok();
    }

    /**
     * 删除
     */
    @DeleteMapping("/delete/{id}")
    @ApiOperation(value = "根据id删除成绩",notes = "根据id删除成绩")
    public R delete(@PathVariable("id") Integer id){
		scoreService.removeById(id);

        return R.ok();
    }

}
