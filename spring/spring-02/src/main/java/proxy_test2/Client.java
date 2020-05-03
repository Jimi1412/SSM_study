package proxy_test2;

//静态代理练习二
public class Client {
    public static void main(String[] args) {
        UserServiceImpl userService=new UserServiceImpl();
        UserServiceProxy proxy=new UserServiceProxy();
        proxy.setUserService(userService);
        proxy.add();
    }

}
