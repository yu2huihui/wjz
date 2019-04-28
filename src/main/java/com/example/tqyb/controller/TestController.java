package com.example.tqyb.controller;

import com.example.tqyb.util.HttpUtil;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RequestMapping("/demo")
@RestController
public class TestController {

    @RequestMapping("/tqyb/{city}")
    @ResponseBody
    public Object tqyb(@PathVariable String city) throws Exception {
        String url ="http://op.juhe.cn/onebox/weather/query";//请求接口地址
        String key = "abf8df53efdc5866d33e409fa242becc";
        Map params = new HashMap();//请求参数
        params.put("cityname", city);//要查询的城市，如：温州、上海、北京
        params.put("key", key);//应用APPKEY(应用详细页查询)
        params.put("dtype","json");//返回数据的格式,xml或json，默认json
        String returnStr = HttpUtil.getStringDataByHttp(url, params, "UTF-8");
        return returnStr;
    }
}
