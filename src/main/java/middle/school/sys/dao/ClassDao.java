package middle.school.sys.dao;

import middle.school.sys.entity.ClassEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 
 * 
 * @author
 * @email none@gmail.com
 * @date 2022-02-26 14:17:19
 */
@Mapper
public interface ClassDao extends BaseMapper<ClassEntity> {
    Integer deleteClaTea(@Param("id") int id);
}
