package net.ailq.response;

/**
 * Created by lllsmiling on 2017/9/14.
 */
public class ResData<T> extends ResModel {
    private T data;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public ResData(T t){
        this.data = t;
    }

    ResData(ResEnum resultEnum, T t){
        this.setCode(resultEnum.getCode());
        this.setState(resultEnum.isState());
        this.setMsg(resultEnum.getMsg());
        this.setData(t);
    }
    ResData(ResEnum resultEnum, T t, String msg){
        this.setCode(resultEnum.getCode());
        this.setState(resultEnum.isState());
        this.setMsg(msg);
        this.setData(t);
    }
}
