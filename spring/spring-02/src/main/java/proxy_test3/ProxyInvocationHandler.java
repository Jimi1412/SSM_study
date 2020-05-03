package proxy_test3;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

//动态代理 Proxy 和 InvocationHandler  也是万能的代理模式模板
public class ProxyInvocationHandler implements InvocationHandler {
    private Object target;// 抽象角色--即接口

    public void setTarget(Object target) {
        this.target = target;
    }

    //再写一个动态获取代理类的方法
    public Object getProxy(){
        return Proxy.newProxyInstance(this.getClass().getClassLoader(),
                target.getClass().getInterfaces(),this);
    }
    @Override
    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
        log(method.getName());
        return method.invoke(target, objects);
    }
     //后面写增强的方法，如log
    public void log(String msg){
        System.out.println("使用了"+msg+"方法");
    }
}
