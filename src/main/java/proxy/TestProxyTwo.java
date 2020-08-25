package proxy;

public class TestProxyTwo {
    public static void main(String[] args) {
        //JDK动态代理测试
        UserDaoImpl userDaoImpl = new UserDaoImpl();
        JDKProxyFactory proxyFactory = new JDKProxyFactory(userDaoImpl);
        UserDao instance = (UserDao) proxyFactory.getProxyInstance();
        instance.save();
    }
}
