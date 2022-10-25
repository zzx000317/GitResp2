package middle.school.notice.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import middle.school.common.utils.JwtUtil;
import middle.school.common.utils.Response;
import middle.school.notice.entity.Notice;
import middle.school.notice.mapper.NoticeMapper;
import middle.school.notice.service.NoticeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import middle.school.sys.entity.dto.GetListDTO;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author
 * @since 2022-03-06
 */
@Service("noticeService")
public class NoticeServiceImpl extends ServiceImpl<NoticeMapper, Notice> implements NoticeService {
    @Override
    public Response saveNotice(Notice question, HttpServletRequest request) {
        String token = request.getHeader("X-Token");
        HashMap<String, Object> hashMap = JwtUtil.parseToken(token);
        Integer userid = (Integer) hashMap.get("uid");
        question.setTeacherId(userid);
        this.save(question);
        return Response.success();

    }


    @Override
    public IPage<Notice> getNoticePar(GetListDTO getListDTO, HttpServletRequest request) {
        Page<Notice> page = new Page<>(getListDTO.getPage(), getListDTO.getPer_page());
        String token = request.getHeader("X-Token");
        HashMap<String, Object> hashMap = JwtUtil.parseToken(token);
        Object uid = hashMap.get("uid");
        Integer parentId = (Integer) uid;
        IPage<Notice> noticeIPage = this.getBaseMapper().getNoticeListPar(page,parentId);
        return noticeIPage;

    }


    @Override
    public IPage<Notice> getNoticeTea(GetListDTO getListDTO, HttpServletRequest request) {
        Page<Notice> page = new Page<>(getListDTO.getPage(), getListDTO.getPer_page());
        String token = request.getHeader("X-Token");
        HashMap<String, Object> hashMap = JwtUtil.parseToken(token);
        Object uid = hashMap.get("uid");
        QueryWrapper<Notice> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(Notice::getTeacherId, uid);
        return this.getBaseMapper().selectPage(page, queryWrapper);

    }

}
