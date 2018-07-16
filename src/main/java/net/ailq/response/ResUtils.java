package net.ailq.response;

/**
 * Created by lllsmiling on 2017/9/14.
 */
public class ResUtils {
    /**
     * 根据一个枚举类型返回所需要的定制信息
     *
     * @param common
     * @return
     */
    public static ResModel common(ResEnum common) {
        return new ResModel(common);
    }

    /**
     * 根据一个枚举类型返回所需要的定制信息，并自定义提示信息
     *
     * @param common
     * @param msg
     * @return
     */
    public static ResModel commonMsg(ResEnum common, String msg) {
        return new ResModel(common, msg);
    }

    /**
     * 根据枚举类型返回所需要的定制信息，并返回数据
     *
     * @param common
     * @param ResData
     * @return
     */
    public static ResData data(ResEnum common, Object ResData) {
        return new ResData<>(common, ResData);
    }

    /**
     * 根据枚举类型返回所需要的定制信息，并返回数据,并自定义提示信息
     * @param common
     * @param data
     * @param msg
     * @return
     */
    public static ResData dataMsg(ResEnum common, Object data, String msg) {
        return new ResData<>(common, data, msg);
    }
}
