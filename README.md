# spring-boot-starter
spring-boot-starter mybatits durid+durid monitor

## api response
通用返回

    /**
     * common success response
     * @return success json
     */
    @RequestMapping(value = "common", method = RequestMethod.GET)
    public ResModel common() {
        return ResUtils.common(ResEnum.success);
    }
返回示例

    {
    	"code":200,
    	"msg":"成功",
    	"state":true
    }

自定义消息

    /**
     * common success and custom msg
     * @return
     */
    @RequestMapping(value = "commonMsg", method = RequestMethod.GET)
    public ResModel commonMsg() {
        return ResUtils.commonMsg(ResEnum.success,"successMsg");
    }
返回示例  
      
    {
    	"code":200,
    	"msg":"successMsg",
    	"state":true
    }

返回数据

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

返回示例
    
    {
    	"code":200,
    	"data":{
    		"first":"Hello World"
    	},
    	"msg":"成功",
    	"state":true
    }
        
返回数据，并自定义消息

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
    
返回示例：

    {
    	"code":200,
    	"data":{
    		"first":"Hello World"
    	},
    	"msg":"dataMsg",
    	"state":true
    }

简化复杂的自定义消息，具体定制消息可以在net.ailq.response配置
    
    