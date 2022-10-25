package middle.school.common.utils;


import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

/**
 * @author sunnoc
 * @date 2019-12-31 14:47
 */
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@Data

public class Response<T> {

    private int code;

    private String msg;

    private T data;


    private Response(ResponseCode responseCode) {
        this.code = responseCode.getCode();
        this.msg = responseCode.getMsg();
    }

    private Response(ResponseCode responseCode, T data) {
        this.code = responseCode.getCode();
        this.msg = responseCode.getMsg();
        this.data = data;
    }

    private Response(ResponseCode responseCode, String msg) {
        this.code = responseCode.getCode();
        this.msg = msg;
    }

    private Response(ResponseCode responseCode, String msg, T data) {
        this.code = responseCode.getCode();
        this.msg = msg;
        this.data = data;
    }

    public static Response success() {
        return new Response(ResponseCode.SUCCESS);
    }

    public static Response error() {
        return new Response(ResponseCode.ERROR);
    }

    public static Response build(ResponseCode responseCode) {
        return new Response(responseCode);
    }

    public static <T> Response<T> build(ResponseCode responseCode, T data) {
        return new Response<>(responseCode, data);
    }

    public static Response build(ResponseCode responseCode, String msg) {
        return new Response(responseCode, msg);
    }

    public static <T> Response<T> build(ResponseCode responseCode, String msg, T data) {
        return new Response<>(responseCode, msg, data);
    }


}
