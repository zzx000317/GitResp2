package middle.school.sys.service.impl;

import com.alibaba.druid.util.StringUtils;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import middle.school.common.utils.PageUtils;
import middle.school.common.utils.Query;

import middle.school.sys.dao.ClassDao;
import middle.school.sys.entity.ClassEntity;
import middle.school.sys.service.ClassService;


@Service("classService")
public class ClassServiceImpl extends ServiceImpl<ClassDao, ClassEntity> implements ClassService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        QueryWrapper<ClassEntity> queryWrapper = new QueryWrapper<>();
        String className = (String)params.get("className");
        if(!StringUtils.isEmpty(className)){
            queryWrapper.eq("class_name",className);
        }

        IPage<ClassEntity> page = this.page(
                new Query<ClassEntity>().getPage(params),
                queryWrapper
        );

        return new PageUtils(page);
    }

    @Override
    public Integer deleteClaTea(int id) {
        return this.baseMapper.deleteClaTea(id);
    }

}