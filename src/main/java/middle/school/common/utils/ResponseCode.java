package middle.school.common.utils;

/**
 * @author sunnoc
 * @date 2019-12-31 14:52
 */
public enum ResponseCode {
    /**
     * 成功
     */
    SUCCESS(200, "成功"),
    /**
     * 失败
     */
    ERROR(201, "失败"),

    /**
     * 桌面端退出登录
     */
    PC_LOGOUT(231, "桌面端退出登录"),

    /**
     * 桌面端关闭回话
     */
    PC_CLOSE_SESSION(232, "桌面端关闭回话"),
    /**
     * 失败
     */
    BOUND(207, "此账号已被绑定"),
    /**
     * 用户名存在
     */
    USER_NAME_EXIST(203, "用户名已存在"),
    /**
     * 用户已被停用
     */
    USER_IS_LOCK(204, "用户已被停用"),
    /**
     * 用户已被停用
     */
    USER_DELETE(205, "用户已被删除"),
    /**
     * 用户名不存在
     */
    USER_NAME_NOT_EXIST(201, "用户名不存在，请注册"),
    /**
     * 验证码不正确
     */
    CODE_NOT_EXIST(201, "验证码不正确"),
    /**
     * 用户未登录
     */
    UN_AUTH(206, "用户未登录"),
    /**
     * 未授权
     */
    UNAUTHORIZED(201, "无权限操作"),
    /**
     * 身份验证异常
     */
    AUTHENTICATION_EXCEPTION(202, "身份验证异常"),
    /**
     * 用户不存在或密码错误
     */
    USER_EXITS_PWD_ERROR(202, "用户不存在或密码错误"),
    /**
     * 授权异常
     */
    AUTHORIZATION_EXCEPTION(201, "授权异常"),
    /**
     * 请求超时
     */
    INS_REQUEST_TIME_OUT(201, "请求超时"),
    /**
     * 系统内部异常，异常信息
     */
    SYSTEM_ERROR(201, "系统内部异常，异常信息");

    private int code;
    private String msg;

    ResponseCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

}
