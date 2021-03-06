package io.kimmking.rpcfx.proxy;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.ParserConfig;
import io.kimmking.rpcfx.api.RpcfxRequest;
import io.kimmking.rpcfx.api.RpcfxResponse;
import io.kimmking.rpcfx.exception.CustomException;
import io.kimmking.rpcfx.netty.client.RpcNettyClientSync;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.net.URISyntaxException;

/**
 * @author Administrator
 */
@Slf4j
public class RpcInvocationHandler implements InvocationHandler {

    private final Class<?> serviceClass;
    private final String url;

    <T> RpcInvocationHandler(Class<T> serviceClass, String url) {
        this.serviceClass = serviceClass;
        this.url = url;
        ParserConfig.getGlobalInstance().setAutoTypeSupport(true);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return process(serviceClass, method, args, url);
    }

    private Object process(Class<?> service, Method method, Object[] params, String url) {
        log.info("Client proxy instance method invoke");

        // 自定义了Rpc请求的结构 RpcRequest,放入接口名称、方法名、参数
        log.info("Build Rpc request");
        RpcfxRequest rpcRequest = new RpcfxRequest();
        rpcRequest.setServiceClass(service.getName());
        rpcRequest.setMethod(method.getName());
        rpcRequest.setParams(params);

        // 客户端使用的 netty，发送请求到服务端，拿到结果（自定义结构：rpcfxResponse)
        log.info("Client send request to Server");
        RpcfxResponse rpcResponse;
        try {
            rpcResponse = RpcNettyClientSync.getInstance().getResponse(rpcRequest, url);
        } catch (CustomException | InterruptedException | URISyntaxException e) {
            e.printStackTrace();
            return null;
        }

        log.info("Client receive response Object");
        assert rpcResponse != null;
        if (!rpcResponse.isStatus()) {
            log.info("Client receive exception");
            rpcResponse.getException().printStackTrace();
            return null;
        }

        // 序列化成对象返回
        log.info("Response:: " + rpcResponse.getResult());
        return JSON.parse(rpcResponse.getResult().toString());
    }
}
