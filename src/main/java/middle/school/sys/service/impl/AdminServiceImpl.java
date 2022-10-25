package middle.school.sys.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import middle.school.common.utils.*;
import middle.school.sys.dao.AdminDao;
import middle.school.sys.entity.AdminEntity;
import middle.school.sys.entity.dto.LoginDTO;
import middle.school.sys.service.AdminService;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service("adminService")
public class AdminServiceImpl extends ServiceImpl<AdminDao, AdminEntity> implements AdminService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<AdminEntity> page = this.page(
                new Query<AdminEntity>().getPage(params),
                new QueryWrapper<AdminEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public Response adminLogin(LoginDTO loginDTO) {
        QueryWrapper<AdminEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(AdminEntity::getUsername, loginDTO.getUsername())
                .eq(AdminEntity::getPassword, loginDTO.getPassword());
        AdminEntity one = this.getOne(queryWrapper);
        if (ObjectUtil.isEmpty(one)) {
            return Response.build(ResponseCode.ERROR, "用户名或密码错误");
        }
        String token = JwtUtil.createToken(one);
        one.setToken(token);
        return Response.build(ResponseCode.SUCCESS, "登录成功", one);
    }
}