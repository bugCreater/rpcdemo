package com.demo.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Administrator on 2016/8/20.
 */
public class RpcServer {
    private int port = 8888;

    public void serve() throws IOException {
        ServerSocket ss = new ServerSocket(port);
        System.out.println("----------服务已经启动----------");
        while(true){
            Socket s = ss.accept();
            new RPCThread(s).start();

        }
    }

}
