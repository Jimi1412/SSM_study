package proxy_test4;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

//动态代理的第三种方法
@Aspect
public class ProxyLog2 {
    @Before("execution(* proxy_test4.UserServiceImpl.*(..))")
    public void before(){
        System.out.println("---------方法执行前---------");
    }
    @After("execution(* proxy_test4.UserServiceImpl.*(..))")
    public void after(){
        System.out.println("---------方法执行后---------");
    }
    @Around("execution(* proxy_test4.UserServiceImpl.*(..))")
    public void around(ProceedingJoinPoint pj) throws Throwable {
        System.out.println("环绕前");
        System.out.println("签名:"+pj.getSignature());
        //执行目标方法proceed
        Object proceed = pj.proceed();
        System.out.println("环绕后");
        System.out.println(proceed);
    }
}
