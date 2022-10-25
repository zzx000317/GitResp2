package middle.school.question.controller;


import com.alibaba.druid.util.StringUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import middle.school.common.controller.BaseController;
import middle.school.common.utils.R;
import middle.school.common.utils.Response;
import middle.school.common.utils.ResponseCode;
import middle.school.question.entity.Question;
import middle.school.question.service.QuestionService;
import middle.school.sys.entity.dto.GetListDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author
 * @since 2022-03-06
 */
@RestController
@RequestMapping("/question")
@Api(value = "测试接口", tags = "问题反馈相关的接口", description = "问题反馈接口")
public class QuestionController extends BaseController {

    @Autowired
    QuestionService questionService;

    @GetMapping("/info/{id}")
    @ApiOperation(value = "根据id获取信息")
    public R info(@PathVariable("id") Integer id){
        Question question = questionService.getById(id);
        return R.ok().put("data", question);
    }

    @PostMapping(value = "save_ask",consumes = "application/json")
    @ApiOperation(value="保存提问")
    public Response saveAsk(@RequestBody Question question){
        return questionService.saveAsk(question);
    }

    @PostMapping(value = "save_answer",consumes = "application/json")
    @ApiOperation(value="保存回复")
    public Response saveAnswer(@RequestBody Question question){
        return questionService.saveAnswer(question);
    }

    @GetMapping(value = "get_question")
    @ApiOperation(value="查询问题列表")
    public Response getQuestion(GetListDTO getListDTO, HttpServletRequest request){
        return Response.build(ResponseCode.SUCCESS,getDataTable(questionService.getQuestion(getListDTO,request)));
    }

    @GetMapping(value = "getQuestionPar")
    @ApiOperation(value="家长查询问题列表")
    public Response getQuestionPar(GetListDTO getListDTO, HttpServletRequest request){
        return Response.build(ResponseCode.SUCCESS,getDataTable(questionService.getQuestionPar(getListDTO,request)));
    }
    @GetMapping(value = "getQuestionTea")
    @ApiOperation(value="教师查询问题列表")
    public Response getQuestionTea(GetListDTO getListDTO, HttpServletRequest request){
        return Response.build(ResponseCode.SUCCESS,getDataTable(questionService.getQuestionTea(getListDTO,request)));
    }

    @PostMapping(value = "saveQuestion")
    @ApiOperation(value="保存提问")
    public Response saveQuestion(@RequestBody Question question, HttpServletRequest request){
        return questionService.saveQuestion(question,request);
    }

    @PostMapping("/update")
    @ApiOperation(value = "修改信息")
    public R update(@RequestBody Question question){
        if(!StringUtils.isEmpty(question.getQuestionAnswer())){
           question.setStatus(true);
        }
        questionService.updateById(question);
        return R.ok();
    }

    @DeleteMapping("/delete/{id}")
    @ApiOperation(value = "根据id删除",notes = "根据id删除")
    public R delete(@PathVariable("id")Integer id){
        questionService.removeById(id);
        return R.ok();
    }
}

