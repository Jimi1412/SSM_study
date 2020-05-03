package proxy_test4;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {
    public static void main(String[] args) {
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
        //注意动态代理代理的是接口
        UserService userService =applicationContext.getBean("userService2",UserService.class);
        userService.add();
    }
}
