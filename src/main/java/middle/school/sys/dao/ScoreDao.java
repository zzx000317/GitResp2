package middle.school.sys.dao;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import middle.school.sys.entity.ScoreEntity;
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
public interface ScoreDao extends BaseMapper<ScoreEntity> {

    IPage<ScoreEntity> getScoreListPar(@Param("page") Page page, @Param("parentId") Integer parentId);
	
}
