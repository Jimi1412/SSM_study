package proxy_test1;

//代理角色，中介，代替房东出租房屋
public class Proxy implements Rent{
    Host host;
    public void setHost(Host host) {
        this.host = host;
    }
    @Override
    public void rent() {
        see();  //代理角色在上下做一些增强 AOP 即是如此
        host.rent();
        contract();
        fare();
    }
    public void see(){
        System.out.println("中介带租户看房");
    }
    public void contract(){
        System.out.println("签合同");
    }
    public void fare(){
        System.out.println("中介收小费");
    }
}
