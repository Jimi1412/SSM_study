package proxy_test1;

public class Client {
    public static void main(String[] args) {
        Host host=new Host();
        Proxy proxy=new Proxy();
        proxy.setHost(host);
        proxy.rent(); //原本是在host类rent方法上下添加增强，但是为了不改变源代码，而使用代理角色来实现
    }
}
