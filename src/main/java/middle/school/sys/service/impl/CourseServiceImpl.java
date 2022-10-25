package middle.school.sys.service.impl;

import com.alibaba.druid.util.StringUtils;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import middle.school.common.utils.PageUtils;
import middle.school.common.utils.Query;

import middle.school.sys.dao.CourseDao;
import middle.school.sys.entity.CourseEntity;
import middle.school.sys.service.CourseService;


@Service("courseService")
public class CourseServiceImpl extends ServiceImpl<CourseDao, CourseEntity> implements CourseService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        QueryWrapper<CourseEntity> queryWrapper = new QueryWrapper<>();
        String courseName = (String)params.get("courseName");
        if(!StringUtils.isEmpty(courseName)){
            queryWrapper.eq("course_name",courseName);
        }
        IPage<CourseEntity> page = this.page(
                new Query<CourseEntity>().getPage(params),
                new QueryWrapper<CourseEntity>()
        );

        return new PageUtils(page);
    }

}