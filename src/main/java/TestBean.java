import java.util.Date;

public class TestBean {
    public static void main(String[] args) throws Exception{
        String file="spring-config.xml";
        //1.初始spring容器
        ClassPathXmlApplicationContext ctx=
                new ClassPathXmlApplicationContext(file);
        //2.获取bean对象
        Date date=ctx.getBean("date", Date.class);
        System.out.println(date);
        Object obj=ctx.getBean("obj", Object.class);
        System.out.println(obj);
        obj=ctx.getBean("obj", Boolean.class);
        System.out.println(obj);
    }

}
