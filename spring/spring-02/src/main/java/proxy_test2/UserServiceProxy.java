package proxy_test2;

//代理角色
public class UserServiceProxy implements UserService{
    UserServiceImpl userService;

    public void setUserService(UserServiceImpl userService) {
        this.userService = userService;
    }

    @Override
    public void add() {
        log("add");
        userService.add();
    }

    @Override
    public void delete() {
        log("delete");
        userService.delete();
    }

    @Override
    public void update() {
        log("update");
        userService.update();
    }

    @Override
    public void query() {
        log("query");
        userService.query();
    }
    //添加一个日志方法
    void log(String msg){
        System.out.println("[Debug]使用了"+msg+"方法");
    }
}
