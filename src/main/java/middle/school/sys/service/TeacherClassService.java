package middle.school.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import middle.school.common.utils.PageUtils;
import middle.school.sys.entity.TeacherClassEntity;

import java.util.Map;

/**
 * 
 *
 * @author
 * @email none@gmail.com
 * @date 2022-02-26 14:17:19
 */
public interface TeacherClassService extends IService<TeacherClassEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

