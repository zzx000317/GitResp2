package middle.school.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import middle.school.common.utils.PageUtils;
import middle.school.common.utils.Response;
import middle.school.sys.entity.AdminEntity;
import middle.school.sys.entity.dto.LoginDTO;

import java.util.Map;

/**
 * 
 *
 * @author
 * @email none@gmail.com
 * @date 2022-02-26 14:17:19
 */
public interface AdminService extends IService<AdminEntity> {

    PageUtils queryPage(Map<String, Object> params);

    Response adminLogin(LoginDTO loginDTO);
}

