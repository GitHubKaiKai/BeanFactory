package proxy;

public class TestProxyThree {
    public static void main(String[] args) {
        UserDaoImpl userDao = new UserDaoImpl();
        CglibProxyFactory proxyFactory = new CglibProxyFactory(userDao);
        UserDao instance = (UserDao) proxyFactory.getProxyInstance();//创建目标方法的子类对象
        instance.save();

    }
}