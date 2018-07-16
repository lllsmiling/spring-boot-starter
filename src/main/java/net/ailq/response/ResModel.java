package net.ailq.response;

/**
 * Created by lllsmiling on 2017/9/14.
 */
public class ResModel {
    /**
     * 错误码
     */
    private int code;

    /**
     * 提示信息
     */
    private String msg;

    private boolean state;


    ResModel() {
    }

    ResModel(ResEnum resEnum) {
        this.state = resEnum.isState();
        this.code = resEnum.getCode();
        this.msg = resEnum.getMsg();
    }

    ResModel(ResEnum resultEnum, String msg) {
        this.state = resultEnum.isState();
        this.code = resultEnum.getCode();
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    void setMsg(String msg) {
        this.msg = msg;
    }

    public boolean isState() {
        return state;
    }

    void setState(boolean state) {
        this.state = state;
    }
}
