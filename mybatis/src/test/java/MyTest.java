import com.ye.bean.Student;
import com.ye.bean.Teacher;
import com.ye.bean.User;
import com.ye.dao.StudentMapper;
import com.ye.dao.TeacherMapper;
import com.ye.dao.UserMapper;
import com.ye.utils.MybatisUtils;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyTest {
    SqlSession session = MybatisUtils.getSession();
    //注意导包：org.apache.log4j.Logger
    static Logger logger = Logger.getLogger(MyTest.class);
    @Test
    public void testGetTeacher(){
        SqlSession session = MybatisUtils.getSession();
        TeacherMapper mapper = session.getMapper(TeacherMapper.class);
        Teacher teacher = mapper.getTeacher(1);
        System.out.println(teacher.getName());
        System.out.println(teacher.getStudents());
    }
    @Test
    public void testGetStudents2(){
        SqlSession session = MybatisUtils.getSession();
        StudentMapper mapper = session.getMapper(StudentMapper.class);
        List<Student> students = mapper.getStudents2();

        for (Student student : students){
            System.out.println(
                    "学生名:"+ student.getName()
                            +"\t老师:"+student.getTeacher().getName());
        }
    }
    @Test
    public void testGetStudents(){
        SqlSession session = MybatisUtils.getSession();
        StudentMapper mapper = session.getMapper(StudentMapper.class);
        List<Student> students = mapper.getStudents();
        for (Student student : students){
            System.out.println(
                    "学生名:"+ student.getName()
                            +"\t老师:"+student.getTeacher().getName());
        }
    }

    @Test
    public void testUserByRowBounds() {
        SqlSession session = MybatisUtils.getSession();
        int currentPage = 1;  //第几页
        int pageSize = 1;  //每页显示几个
        RowBounds rowBounds = new RowBounds((currentPage-1)*pageSize,pageSize);
        //通过session.**方法进行传递rowBounds，[此种方式现在已经不推荐使用了]
        List<User> users = session.selectList("com.ye.dao.UserMapper.getUserByRowBounds", null, rowBounds);
        for (User user: users){
            System.out.println(user);
        }
        session.close();
    }
    @Test
    public void testSelectUserLimit() {
        logger.info("info：进入selectUser方法");
        logger.debug("debug：进入selectUser方法");
        logger.error("error: 进入selectUser方法");
        SqlSession session = MybatisUtils.getSession();
        int currentPage = 1;  //第几页
        int pageSize = 2;  //每页显示几个
        Map<String,Integer> map = new HashMap<String,Integer>();
        map.put("startIndex",(currentPage-1)*pageSize);
        map.put("pageSize",pageSize);
        UserMapper mapper = session.getMapper(UserMapper.class);
        List<User> users = mapper.selectUserLimit(map);
        for (User user: users){
            System.out.println(user);
        }
        session.close();
    }
    @Test
    public  void testSelectUser(){
        UserMapper mapper = session.getMapper(UserMapper.class);
        List<User> users = mapper.selectUser();

        for (User user: users){
            System.out.println(user);
        }
        session.close();
    }
    @Test
    public void tsetSelectUserById() {
        SqlSession session = MybatisUtils.getSession();  //获取SqlSession连接
        UserMapper mapper = session.getMapper(UserMapper.class);
        User user = mapper.selectUserById(1);
        System.out.println(user);
        session.close();
    }
    @Test
    public void tsetSelectUserByNP() {
        SqlSession session = MybatisUtils.getSession();  //获取SqlSession连接
        UserMapper mapper = session.getMapper(UserMapper.class);
        User user = mapper.selectUserByNP("狂神","123456");
        System.out.println(user);
        session.close();
    }
    @Test
    public void tsetSelectUserByNP2() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("username", "张三");
        map.put("pwd", "abcdef");
        UserMapper mapper = session.getMapper(UserMapper.class);
        User user = mapper.selectUserByNP2(map);
        System.out.println(user);
        session.close();
    }
    @Test
    public void testAddUser() {
        SqlSession session = MybatisUtils.getSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        User user = new User(5,"王五","zxcvbn");
        int i = mapper.addUser(user);
        System.out.println(i);
        session.commit(); //提交事务,重点!不写的话不会提交到数据库
        session.close();
    }
    @Test
    public void testUpdateUser() {
        SqlSession session = MybatisUtils.getSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        User user = mapper.selectUserById(1);
        user.setPwd("10085");
        int i = mapper.updateUser(user);
        System.out.println(i);
        session.commit(); //提交事务,重点!不写的话不会提交到数据库
        session.close();
    }
    @Test
    public void testDeleteUser() {
        SqlSession session = MybatisUtils.getSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        int i = mapper.deleteUser(5);
        System.out.println(i);
        session.commit(); //提交事务,重点!不写的话不会提交到数据库
        session.close();
    }
    @Test
    public void testSelectLike(){
        SqlSession session = MybatisUtils.getSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        String str="三";
//        String str="三";
        User user=mapper.selectLike(str);
        System.out.println(user);
        session.close();
    }
}
