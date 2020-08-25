import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class ThreadOne  extends Thread{
    @Override
    public void run(){
        for (int i = 0 ; i<10 ; i++){
            System.out.println(i);
        }
    }

}

class CallAbleImpl implements Callable<String>{
    public String call(){
        for (int i = 0 ; i<10 ; i++){
            System.out.println(i);
        }
        return "4656564";
    }
}