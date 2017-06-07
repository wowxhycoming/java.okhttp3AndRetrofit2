package me.xhy.java.s2retrofit2.bean;

/**
 * Created by xuhuaiyu on 2017/6/6.
 */
public class MovieError {

    private String msg;
    private String code;
    private String request;

    @Override
    public String toString() {
        return "MovieError{" +
        "msg='" + msg + '\'' +
        ", code='" + code + '\'' +
        ", request='" + request + '\'' +
        '}';
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }
}
