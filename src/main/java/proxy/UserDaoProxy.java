package proxy;

public class UserDaoProxy implements UserDao{
    private UserDao userDao;
    public UserDaoProxy(UserDao userDao){
        this.userDao = userDao;
    }
    public void save(){
        System.out.println("我是代理类增加的逻辑1");
        userDao.save();
        System.out.println("我是代理类增加的逻辑2");
    }
}
