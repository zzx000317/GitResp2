package middle.school.sys.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import middle.school.common.utils.PageUtils;
import middle.school.common.utils.Query;

import middle.school.sys.dao.StudentParentDao;
import middle.school.sys.entity.StudentParentEntity;
import middle.school.sys.service.StudentParentService;


@Service("studentParentService")
public class StudentParentServiceImpl extends ServiceImpl<StudentParentDao, StudentParentEntity> implements StudentParentService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<StudentParentEntity> page = this.page(
                new Query<StudentParentEntity>().getPage(params),
                new QueryWrapper<StudentParentEntity>()
        );

        return new PageUtils(page);
    }

}