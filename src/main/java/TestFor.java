import java.util.ArrayList;
import java.util.List;

public class TestFor {

    public static void main(String[] args) throws Exception{
//        ArrayList list = new ArrayList();
//        list.add("laowang");
//        list.add("xianghu");
//        list.add("laoniu");
//        for (Object lists:list ) {
//            System.out.println(lists);
//        }

        Thread thread3 = new Thread(new RunableImpl("o3"));
        Thread thread1 = new Thread(new RunableImpl("o1"));
        Thread thread2 = new Thread(new RunableImpl("o2"));
        thread1.start();
        thread2.start();
        thread3.start();

    }
}
