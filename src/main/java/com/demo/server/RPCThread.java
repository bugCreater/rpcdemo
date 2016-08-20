package com.demo.server;

import com.demo.server.bean.RPCBean;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.Socket;

/**
 * Created by Administrator on 2016/8/20.
 */
public class RPCThread extends Thread{
    private Socket socket;
    public RPCThread(Socket s) {
        this.socket = s;
    }

    @Override
    public void run() {
        try {
            RPCBean rpcBean = (RPCBean) new ObjectInputStream(socket.getInputStream()).readObject();
            Object target = getObject(rpcBean.getClazz());
            Object result = executeMethod(target,rpcBean.getMethodName(),rpcBean.getArgs());
            ObjectOutputStream os = new ObjectOutputStream(socket.getOutputStream());
            os.writeObject(result);
            os.flush();
            os.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    public static Object getObject(Class clazz){
        Object obj = null;
        String interfaceName = clazz.getName();
        obj = StaticConfig.getObject(interfaceName);
        return obj;
    }

    public static Object executeMethod(Object target,String methodName,Object[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Object result = null;
        Class clazz = target.getClass();
        Class[] argsClass = new Class[args.length];
        for(int i=0;i<argsClass.length;i++){
            argsClass[i] = args[i].getClass();
        }
        Method method = clazz.getMethod(methodName,argsClass);
        result = method.invoke(target,args);
        return result;
    }
}
