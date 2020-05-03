import com.ye.pojo.Student;
import com.ye.pojo.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {

    @Test
    public void test1(){
        ApplicationContext applicationContext =new ClassPathXmlApplicationContext("applicationContext.xml");
        Student student=applicationContext.getBean("student",Student.class);
        student.show();
    }

    @Test
    public void test2(){
        ApplicationContext applicationContext =new ClassPathXmlApplicationContext("applicationContext.xml");
        User user=applicationContext.getBean("user",User.class);
        User user2=applicationContext.getBean("user2",User.class);
        System.out.println(user.toString()); System.out.println(user2.toString());
    }
}
