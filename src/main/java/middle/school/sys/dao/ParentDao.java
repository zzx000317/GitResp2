package middle.school.sys.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import middle.school.sys.entity.ParentEntity;
import middle.school.sys.entity.StudentParentEntity;
import middle.school.sys.entity.dto.GetListDTO;
import middle.school.sys.entity.vo.StudentScoreVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author
 * @email none@gmail.com
 * @date 2022-02-26 14:17:19
 */
@Mapper
public interface ParentDao extends BaseMapper<ParentEntity> {

    /**
     * 查询成绩
     *
     * @param collect
     * @return
     */
    List<StudentScoreVo> selectList(List<Integer> collect);

    IPage<ParentEntity> getParentList(@Param("page") Page page, @Param("queryDto") GetListDTO getListDTO);

    Integer deleteParStu(@Param("id") int id);
}
