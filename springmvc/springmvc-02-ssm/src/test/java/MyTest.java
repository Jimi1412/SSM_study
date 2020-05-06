import com.ye.service.BookService;
import com.ye.service.BookServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    @Test
    public void test1(){
        ApplicationContext applicationContext =new ClassPathXmlApplicationContext("applicationContext.xml");
        BookService bookService=applicationContext.getBean("bookService",BookService.class);
        System.out.println(bookService);
    }
}
