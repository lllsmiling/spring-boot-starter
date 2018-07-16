package net.ailq.response;
/**
 * Created by lllsmiling on 2017/9/14.
 */
public enum ResEnum {
    success(true,200,"成功"),
    noLogin(false,401,"没有登录"),
    forbidden(false,403,"禁止访问");
    private boolean state;

    private int code;

    private String msg;

    ResEnum(boolean status, Integer code, String msg){
        this.state = status;
        this.msg = msg;
        this.code = code;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }
    public void setCode(Integer code) {
        this.code = code;
    }
    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
