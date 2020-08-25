package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JDKProxyFactory {
    private UserDaoImpl userDaoImpl;
    public JDKProxyFactory(UserDaoImpl userDaoImpl){
        this.userDaoImpl = userDaoImpl;
    }
    //生成代理对象
    public Object getProxyInstance(){
        return Proxy.newProxyInstance(userDaoImpl.getClass().getClassLoader(),
                userDaoImpl.getClass().getInterfaces(), new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("动态代理1");
                        //执行目标对象方法
                        Object o = method.invoke(userDaoImpl);
                        System.out.println("动态代理2");
                        return o;
                    }
                });
    }
}
