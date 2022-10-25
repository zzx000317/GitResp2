package middle.school.notice.controller;


import com.alibaba.druid.util.StringUtils;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.ApiOperation;
import middle.school.common.controller.BaseController;
import middle.school.common.utils.R;
import middle.school.common.utils.Response;
import middle.school.common.utils.ResponseCode;
import middle.school.notice.entity.Notice;
import middle.school.notice.service.NoticeService;
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
@RequestMapping("/notice")
public class NoticeController extends BaseController {
    @Autowired
    NoticeService noticeService;

    @GetMapping(value = "getNoticePar")
    @ApiOperation(value="家长查询通知列表")
    public Response getNoticePar(GetListDTO getListDTO, HttpServletRequest request){

        return Response.build(ResponseCode.SUCCESS,getDataTable(noticeService.getNoticePar(getListDTO,request)));
    }
    @GetMapping(value = "getNoticeTea")
    @ApiOperation(value="教师查询通知列表")
    public Response getNoticeTea(GetListDTO getListDTO, HttpServletRequest request){
        return Response.build(ResponseCode.SUCCESS,getDataTable(noticeService.getNoticeTea(getListDTO,request)));
    }

    @PostMapping(value = "saveNotice")
    @ApiOperation(value="保存通知")
    public Response saveNotice(@RequestBody Notice notice, HttpServletRequest request){
        return noticeService.saveNotice(notice,request);
    }

    @PostMapping("/update")
    @ApiOperation(value = "修改信息")
    public R update(@RequestBody Notice notice){
        
        noticeService.updateById(notice);
        return R.ok();
    }

    @GetMapping("/info/{id}")
    @ApiOperation(value = "根据id获取通知信息", notes = "根据id查询通知信息")
    public R info(@PathVariable("id") Integer id){
        Notice notice = noticeService.getById(id);
        return R.ok().put("data", notice);
    }

    @DeleteMapping("/delete/{id}")
    @ApiOperation(value = "根据id删除通知",notes = "根据id删除通知")
    public R delete(@PathVariable("id") Integer id){
        noticeService.removeById(id);
        return R.ok();
    }
}

