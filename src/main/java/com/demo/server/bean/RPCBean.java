package com.demo.server.bean;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/8/20.
 */
public class RPCBean implements Serializable{
    private Class clazz;
    private String methodName;
    private Object[] args;

    public RPCBean(Class clazz, String methodName, Object[] args) {
        this.clazz = clazz;
        this.methodName = methodName;
        this.args = args;
    }

    public Class getClazz() {
        return clazz;
    }

    public void setClazz(Class clazz) {
        this.clazz = clazz;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public Object[] getArgs() {
        return args;
    }

    public void setArgs(Object[] args) {
        this.args = args;
    }

}
