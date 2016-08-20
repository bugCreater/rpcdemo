package com.demo.proxy;

import com.demo.server.bean.RPCBean;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.Socket;

/**
 * Created by Administrator on 2016/8/20.
 */
public class RPCProxy implements InvocationHandler{
    private String ip;
    private int port;
    private Class interfaceClass;
    public RPCProxy(String ip, int port, Class interfaceClass) {
        this.ip = ip;
        this.port = port;
        this.interfaceClass = interfaceClass;
    }

    public Object getProxy(){
        return Proxy.newProxyInstance(interfaceClass.getClassLoader(),new Class[]{interfaceClass},this);
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Socket s = new Socket(ip,port);
        RPCBean rpcBean = new RPCBean(interfaceClass,method.getName(),args);
        ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
        oos.writeObject(rpcBean);
        ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
        Object result = ois.readObject();
        return result;
    }
}
