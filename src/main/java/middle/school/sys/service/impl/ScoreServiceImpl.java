package middle.school.sys.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import middle.school.common.utils.JwtUtil;
import middle.school.sys.entity.dto.GetListDTO;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import middle.school.common.utils.PageUtils;
import middle.school.common.utils.Query;

import middle.school.sys.dao.ScoreDao;
import middle.school.sys.entity.ScoreEntity;
import middle.school.sys.service.ScoreService;

import javax.servlet.http.HttpServletRequest;


@Service("scoreService")
public class ScoreServiceImpl extends ServiceImpl<ScoreDao, ScoreEntity> implements ScoreService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<ScoreEntity> page = this.page(
                new Query<ScoreEntity>().getPage(params),
                new QueryWrapper<>()
        );

        return new PageUtils(page);
    }

    @Override
    public IPage<ScoreEntity> getScorePar(GetListDTO getListDTO, HttpServletRequest request) {
        Page<ScoreEntity> page = new Page<>(getListDTO.getPage(), getListDTO.getPer_page());
        String token = request.getHeader("X-Token");
        HashMap<String, Object> hashMap = JwtUtil.parseToken(token);
        Object uid = hashMap.get("uid");
        Integer parentId = (Integer) uid;
        IPage<ScoreEntity> scoreEntityIPage = this.getBaseMapper().getScoreListPar(page,parentId);
        return scoreEntityIPage;

    }


    @Override
    public IPage<ScoreEntity> getScoreTea(GetListDTO getListDTO, HttpServletRequest request) {
        Page<ScoreEntity> page = new Page<>(getListDTO.getPage(), getListDTO.getPer_page());
        String token = request.getHeader("X-Token");
        HashMap<String, Object> hashMap = JwtUtil.parseToken(token);
        Object uid = hashMap.get("uid");
        QueryWrapper<ScoreEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(ScoreEntity::getTeacherId, uid);
        return this.getBaseMapper().selectPage(page, queryWrapper);

    }

}