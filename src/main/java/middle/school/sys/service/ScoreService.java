package middle.school.sys.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import middle.school.common.utils.PageUtils;
import middle.school.notice.entity.Notice;
import middle.school.sys.entity.ScoreEntity;
import middle.school.sys.entity.dto.GetListDTO;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * 
 *
 * @author
 * @email none@gmail.com
 * @date 2022-02-26 14:17:19
 */
public interface ScoreService extends IService<ScoreEntity> {

    PageUtils queryPage(Map<String, Object> params);
    IPage<ScoreEntity> getScorePar(GetListDTO getListDTO, HttpServletRequest request);
    IPage<ScoreEntity> getScoreTea(GetListDTO getListDTO, HttpServletRequest request);
}

