package middle.school.sys.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import middle.school.common.utils.PageUtils;
import middle.school.common.utils.Response;
import middle.school.sys.entity.ParentEntity;
import middle.school.sys.entity.dto.GetListDTO;
import middle.school.sys.entity.dto.GetScoreDto;
import middle.school.sys.entity.dto.LoginDTO;

import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * @author
 * @email none@gmail.com
 * @date 2022-02-26 14:17:19
 */
public interface ParentService extends IService<ParentEntity> {

    PageUtils queryPage(Map<String, Object> params);

    /**
     * 家长登录
     *
     * @param loginDTO
     * @return
     */
    Response parentLogin(LoginDTO loginDTO);

    /**
     * 保存家长信息
     * @param parent
     * @return
     */
    Response saveParent(ParentEntity parent);

    /**
     * 查询成绩
     * @param getScoreDto
     * @return
     */
    Response getScore(GetScoreDto getScoreDto);

    IPage<ParentEntity> getParentList(GetListDTO getListDTO);

    Integer deleteParStu(int id);
}

