package middle.school.common.utils;

import cn.hutool.jwt.JWT;
import cn.hutool.jwt.JWTUtil;
import middle.school.sys.entity.AdminEntity;
import middle.school.sys.entity.ParentEntity;
import middle.school.sys.entity.StudentEntity;
import middle.school.sys.entity.TeacherEntity;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yjj
 * @date 2021/10/26 16:44
 */
public class JwtUtil {
    private static final String SECRET = "boxdog";

    /**
     * 创建token
     *
     * @param user 用户对象
     * @return token字符串
     */
    public static String createToken(TeacherEntity user, String role) {
        Map<String, Object> map = new HashMap<>();
        map.put("uid", user.getId());
        map.put("role", role);
        map.put("username", user.getUsername());
        map.put("expire_time", System.currentTimeMillis() + 1000 * 60 * 60 * 24 * 15);
        return JWTUtil.createToken(map, SECRET.getBytes());
    }

    public static String createToken(StudentEntity user) {
        Map<String, Object> map = new HashMap<>();
        map.put("uid", user.getId());
        map.put("role", "student");
        map.put("expire_time", System.currentTimeMillis() + 1000 * 60 * 60 * 24 * 15);
        return JWTUtil.createToken(map, SECRET.getBytes());
    }

    public static String createToken(ParentEntity user) {
        Map<String, Object> map = new HashMap<>();
        map.put("uid", user.getId());
        map.put("role", "parent");
        map.put("username", user.getUsername());
        map.put("expire_time", System.currentTimeMillis() + 1000 * 60 * 60 * 24 * 15);
        return JWTUtil.createToken(map, SECRET.getBytes());
    }

    public static String createToken(AdminEntity user) {
        Map<String, Object> map = new HashMap<>();
        map.put("uid", user.getId());
        map.put("role", "admin");
        map.put("username", user.getUsername());
        map.put("expire_time", System.currentTimeMillis() + 1000 * 60 * 60 * 24 * 15);
        return JWTUtil.createToken(map, SECRET.getBytes());
    }

    /**
     * 解析token
     *
     * @param token token值
     * @return 用户id
     */
    /*public static Integer parseToken(String token) {
        JWT jwt = JWTUtil.parseToken(token);
        // jwt.getHeader(JWTHeader.TYPE);
        return (Integer) jwt.getPayload("uid");
    }*/
    public static HashMap<String, Object> parseToken(String token) {
        JWT jwt = JWTUtil.parseToken(token);
        Object uid = jwt.getPayload("uid");
        Object role = jwt.getPayload("role");
        Object username = jwt.getPayload("username");
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("uid", uid);
        hashMap.put("role", role);
        hashMap.put("username", username);
        return hashMap;
    }

    /**
     * 验证token
     *
     * @param token token值
     * @return 验证结果
     */
    public static boolean verifyToken(String token) {
        return JWTUtil.verify(token, SECRET.getBytes());
    }
}
