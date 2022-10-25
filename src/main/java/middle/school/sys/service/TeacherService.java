package middle.school.sys.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import middle.school.common.utils.PageUtils;
import middle.school.common.utils.Response;
import middle.school.sys.entity.TeacherEntity;
import middle.school.sys.entity.dto.GetListDTO;
import middle.school.sys.entity.dto.LoginDTO;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author
 * @email none@gmail.com
 * @date 2022-02-26 14:17:19
 */
public interface TeacherService extends IService<TeacherEntity> {

    /**
     * 查询列表
     *
     * @param params
     * @return
     */
    PageUtils queryPage(Map<String, Object> params);

    /**
     * 老师登录
     *
     * @param loginDTO
     * @return
     */
    Response teacherLogin(LoginDTO loginDTO);

    /**
     * 保存老师
     *
     * @param teacher
     * @return
     */
    Response saveTeacher(TeacherEntity teacher);

    /**
     * 查询老师列表
     *
     * @param params
     * @return
     */
    IPage<TeacherEntity> getTeacherList(GetListDTO getListDTO);

    /**
     * 获取用户信息
     * @param token
     * @return
     */
    Response getUserInfo(HttpServletRequest request);


    Integer deleteTeaCla(int id);
}

