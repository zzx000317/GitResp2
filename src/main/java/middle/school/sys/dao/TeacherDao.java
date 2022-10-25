package middle.school.sys.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import middle.school.sys.entity.TeacherEntity;
import middle.school.sys.entity.dto.GetListDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author
 * @email none@gmail.com
 * @date 2022-02-26 14:17:19
 */
@Mapper
public interface TeacherDao extends BaseMapper<TeacherEntity> {

    /**
     * 查询教师列表
     *
     * @param getListDTO
     * @return
     */
    IPage<TeacherEntity> getTeacherList(@Param("page") Page page, @Param("queryDto") GetListDTO getListDTO);

    Integer deleteTeaCla(@Param("id") int id);
}
