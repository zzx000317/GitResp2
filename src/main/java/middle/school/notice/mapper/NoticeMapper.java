package middle.school.notice.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import middle.school.notice.entity.Notice;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author
 * @since 2022-03-06
 */
@Mapper
public interface NoticeMapper extends BaseMapper<Notice> {
    IPage<Notice> getNoticeListPar(@Param("page") Page page, @Param("parentId") Integer parentId);
}
