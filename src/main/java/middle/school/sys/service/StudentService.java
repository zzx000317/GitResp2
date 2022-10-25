package middle.school.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import middle.school.common.utils.PageUtils;
import middle.school.common.utils.Response;
import middle.school.sys.entity.StudentEntity;
import middle.school.sys.entity.dto.LoginDTO;

import java.util.Map;

/**
 * @author
 * @email none@gmail.com
 * @date 2022-02-26 14:17:19
 */
public interface StudentService extends IService<StudentEntity> {

    PageUtils queryPage(Map<String, Object> params);

    /**
     * 学生登录
     *
     * @param loginDTO
     * @return
     */
    Response studentLogin(LoginDTO loginDTO);

    /**
     * 登录
     *
     * @param loginDTO
     * @return
     */
    Response login(LoginDTO loginDTO);

    Integer deleteStuPar(int id);
}

