package middle.school.notice.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import middle.school.common.utils.Response;
import middle.school.notice.entity.Notice;
import com.baomidou.mybatisplus.extension.service.IService;
import middle.school.sys.entity.dto.GetListDTO;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author
 * @since 2022-03-06
 */
public interface NoticeService extends IService<Notice> {
    IPage<Notice> getNoticePar(GetListDTO getListDTO, HttpServletRequest request);
    IPage<Notice> getNoticeTea(GetListDTO getListDTO, HttpServletRequest request);
    Response saveNotice(Notice question, HttpServletRequest request);
}
