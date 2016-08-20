package com.demo.server;

import com.demo.server.service.impl.HelloServiceImpl;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2016/8/20.
 */
public class StaticConfig {
    private static Map<String,Object> config = new HashMap<String,Object>();

    static {
        config.put("com.demo.server.service.IHelloService",new HelloServiceImpl());
    }

    public static Object getObject(String interfaceName){
        return config.get(interfaceName);
    }
}
