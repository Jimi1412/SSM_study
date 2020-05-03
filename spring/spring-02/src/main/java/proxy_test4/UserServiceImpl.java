package proxy_test4;

//真实角色，被代理对象
public class UserServiceImpl implements UserService {
    @Override
    public void add() {
        System.out.println("添加一个用户");
    }

    @Override
    public void delete() {
        System.out.println("删除一个用户");
    }

    @Override
    public void update() {
        System.out.println("更新一个用户");
    }

    @Override
    public void query() {
        System.out.println("查询一个用户");
    }
}
