package middle.school.sys.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import middle.school.common.utils.PageUtils;
import middle.school.common.utils.Query;

import middle.school.sys.dao.TeacherClassDao;
import middle.school.sys.entity.TeacherClassEntity;
import middle.school.sys.service.TeacherClassService;


@Service("teacherClassService")
public class TeacherClassServiceImpl extends ServiceImpl<TeacherClassDao, TeacherClassEntity> implements TeacherClassService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {

        IPage<TeacherClassEntity> page = this.page(
                new Query<TeacherClassEntity>().getPage(params),
                new QueryWrapper<TeacherClassEntity>()
        );

        return new PageUtils(page);
    }

}