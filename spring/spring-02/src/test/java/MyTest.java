import com.ye.pojo.People;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    @Test
    public void test1(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
        People people =applicationContext.getBean("people",People.class);
        System.out.println(people.toString());
        people.getCat().shout();
        people.getDog().shout();
    }
}
