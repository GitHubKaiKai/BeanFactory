package proxy;


import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibProxyFactory implements MethodInterceptor {
    private UserDaoImpl userDao;
    public CglibProxyFactory (UserDaoImpl userDao){
        this.userDao = userDao;
    }
    //给目标创建代理对象
    public Object getProxyInstance(){
        //工具类
        Enhancer en = new Enhancer();
        //父类
        en.setSuperclass(userDao.getClass());
        //回调函数
        en.setCallback(this);
        return en.create();
    }
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("我是cglib代理1");
        Object obj = method.invoke(userDao);
        System.out.println("我是cglib代理2");
        return obj;
    }
}
