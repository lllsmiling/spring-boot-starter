package net.ailq.controller;

import com.google.common.collect.Maps;
import net.ailq.response.ResEnum;
import net.ailq.response.ResModel;
import net.ailq.response.ResUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author lllsmiling
 * @create 2018-07-16 11:00
 **/
@RestController
@RequestMapping("test/response")
public class TestController {
    /**
     * common success response
     * @return success json
     */
    @RequestMapping(value = "common", method = RequestMethod.GET)
    public ResModel common() {
        return ResUtils.common(ResEnum.success);
    }

    /**
     * common success and custom msg
     * @return
     */
    @RequestMapping(value = "commonMsg", method = RequestMethod.GET)
    public ResModel commonMsg() {
        return ResUtils.commonMsg(ResEnum.success,"successMsg");
    }


    /**
     * response data
     * @return
     */
    @RequestMapping(value = "data", method = RequestMethod.GET)
    public ResModel data() {
        Map<String,Object> result = Maps.newHashMap();
        result.put("first","Hello World");
        return ResUtils.data(ResEnum.success,result);
    }


    /**
     * response data and custom msg
     * @return
     */
    @RequestMapping(value = "dataMsg", method = RequestMethod.GET)
    public ResModel dataMsg() {
        Map<String,Object> result = Maps.newHashMap();
        result.put("first","Hello World");
        return ResUtils.dataMsg(ResEnum.success,result,"dataMsg");
    }


}
