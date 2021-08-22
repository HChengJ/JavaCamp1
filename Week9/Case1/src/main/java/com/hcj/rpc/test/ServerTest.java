package com.hcj.rpc.test;

import com.hcj.rpc.service.RpcServer;

/**
 * @author Administrator
 */
public class ServerTest {
    public static void main(String[] args) throws ClassNotFoundException {
        RpcServer server = new RpcServer();
        server.start(9998, "com.hcj.rpc.test");
    }

}
