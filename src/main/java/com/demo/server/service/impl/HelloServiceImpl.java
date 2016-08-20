package com.demo.server.service.impl;

import com.demo.server.service.IHelloService;

/**
 * Created by Administrator on 2016/8/20.
 */
public class HelloServiceImpl implements IHelloService{
    public String sayHi(String name) {
        return "Hi " + name;
    }
}
