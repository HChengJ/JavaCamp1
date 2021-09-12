package com.hcj.simplerpc.service.impl;

import com.hcj.simplerpc.service.IService;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * @author Administrator
 */
public class ServiceImpl extends UnicastRemoteObject implements IService {

    private static final long serialVersionUID = 682805210518738166L;

    public ServiceImpl() throws RemoteException {
        super();
    }
    @Override
    public String queryName(String no) throws RemoteException {
        // 方法的具体实现
        System.out.println("hello" + no);
        return String.valueOf(System.currentTimeMillis());
    }
}
