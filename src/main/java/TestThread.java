import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class TestThread {
    public static void main(String[] args) throws Exception{
//        ThreadOne threadDemo1 = new ThreadOne();
//        threadDemo1.start();
//        System.out.println(threadDemo1.getName())
//        RunableImpl runable = new RunableImpl();
//        runable.run();
        //利用线程池的方式创建线程
        ExecutorService exec = Executors.newCachedThreadPool();
        Future<String> submit = exec.submit(new CallAbleImpl());
        //获得线程返回值
        String string = submit.get();
        System.out.println(string);
    }
}
