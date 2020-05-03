package proxy_test4;



//动态代理的第二种方法

public class ProxyLog  {
    public void before(){
        System.out.println("---------方法执行前---------");
    }
    public void after(){
        System.out.println("---------方法执行后---------");
    }
}
