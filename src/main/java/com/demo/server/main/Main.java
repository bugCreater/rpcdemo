package com.demo.server.main;

import com.demo.server.RpcServer;

import java.io.IOException;

/**
 * Created by Administrator on 2016/8/20.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        new RpcServer().serve();
    }
}
