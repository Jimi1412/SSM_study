package proxy_test3;

import java.lang.reflect.Proxy;

public class Client {
    public static void main(String[] args) {
        Host host=new Host();//真实角色
        ProxyInvocationHandler pih=new ProxyInvocationHandler();//处理类
        pih.setTarget(host); //设置代理角色代理的方法
        Rent proxy=(Rent) pih.getProxy(); //获取代理角色
        proxy.rent(); //执行方法
    }

}
