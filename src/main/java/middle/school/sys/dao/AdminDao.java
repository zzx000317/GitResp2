package middle.school.sys.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import middle.school.sys.entity.AdminEntity;
import middle.school.sys.entity.ClassEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * 
 * @author
 * @email none@gmail.com
 * @date 2022-02-26 14:17:19
 */
@Mapper
public interface AdminDao extends BaseMapper<AdminEntity> {
	
}
