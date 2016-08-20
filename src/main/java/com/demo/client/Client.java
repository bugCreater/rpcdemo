package com.demo.client;

import com.demo.server.service.IHelloService;
import com.demo.proxy.RPCProxy;

/**
 * Created by Administrator on 2016/8/20.
 */
public class Client {
    public static void main(String[] args){
        IHelloService service = (IHelloService) new RPCProxy("localhost",8888,IHelloService.class).getProxy();
        System.out.println(service.sayHi("小明"));
    }
}
