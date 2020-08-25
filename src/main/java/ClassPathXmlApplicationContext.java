import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;

public class ClassPathXmlApplicationContext {
    /**通过此map存储配置信息*/
    private Map<String,BeanDefinition> beanMap=new HashMap<String,BeanDefinition>();
    /**通过此map存储bean的实例*/
    private Map<String,Object> instanceMap=new HashMap<String,Object>();
    public ClassPathXmlApplicationContext(String file) throws Exception{
        //1.读取文件(从类路径读取)
        InputStream in=
                ClassLoader.getSystemResourceAsStream(file);
//        System.out.println(in);
        //2.解析流
        loadBeanDefinitions(in);
    }
    /**使用此方法解析流对象:基于标准dom解析进行实现*/
    private void loadBeanDefinitions(InputStream in) throws Exception {
        //1.创建解析器对象
        DocumentBuilder builder=
                DocumentBuilderFactory
                        .newInstance().newDocumentBuilder();
        //2.解析流获取document对象
        Document doc=builder.parse(in);
        //3.处理document
        handleDocument(doc);
    }
    /**处理document对象*/
    private void handleDocument(Document doc) throws Exception{
        //1.获取所有bean元素
        NodeList list=doc.getElementsByTagName("bean");
        //2.遍历所有bean元素
        for(int i=0;i<list.getLength();i++) {
            //2.1获取bean节点
            Node node=list.item(i);//bean
            //2.2解析bean节点
            BeanDefinition bd=parseNode(node);
            //2.3将解析结果存储到beanMap
            beanMap.put(bd.getId(),bd);
            //2.4基于bean的延迟加载属性
            if(!bd.getLazy()) {//实时加载
                Class<?> cls=Class.forName(bd.getPkgClass());
                Object instance=newInstance(cls);
                instanceMap.put(bd.getId(), instance);
            }
        }
    }
    /**基于class构建类的实例*/
    private Object newInstance(Class<?> cls) throws Exception {
        //1.获取类的构造方法对象
        Constructor<?> con=
                cls.getDeclaredConstructor();
        //2.设置构造方法可访问(假如构造方法私有也可以构建对象)
        con.setAccessible(true);
        //3.构建类的实例
        return con.newInstance();
    }
    private BeanDefinition parseNode(Node node) {
        //1.构建BeanDefinition对象
        BeanDefinition bd=new BeanDefinition();
        //2.将node中的属性数据封装到BeanDefinition对象
        NamedNodeMap nodeMap=node.getAttributes();
        //2.1获取id属性的值
        String id=nodeMap.getNamedItem("id").getNodeValue();
        //2.2获取class属性的值
        String pkgClass=nodeMap.getNamedItem("class").getNodeValue();
        //2.3获取lazy属性的值
        String lazy=nodeMap.getNamedItem("lazy").getNodeValue();
        bd.setId(id);
        bd.setPkgClass(pkgClass);
        bd.setLazy(Boolean.valueOf(lazy));
        return bd;
    }
    @SuppressWarnings("unchecked")
    public <T> T getBean(String id,Class<T> cls)throws Exception {
        //1.从bean池(map对象)获取对象
        Object obj=instanceMap.get(id);
        if(obj!=null) {
            if(!obj.getClass().getName().equals(cls.getName()))
                throw new ClassCastException("no such class object");
            return (T)obj;
        }
        //3.池中没有则创建,然后放入池中
        //3.1判定配置池中是否有此key
        if(!beanMap.containsKey(id))return null;
        //3.2配置池中有此key对应的配置信息则获取配置对象
        BeanDefinition bd=beanMap.get(id);
        //3.3判定配置对象中bean类型是否匹配
        if(!bd.getPkgClass().equals(cls.getName()))
            throw new NoClassDefFoundError("no class type bean");
        //3.4创建实例对象并放入实例map中
        obj=newInstance(cls);
        instanceMap.put(id,obj);
        //4.返回bean实例对象
        return (T)obj;
    }
}
