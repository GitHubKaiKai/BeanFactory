package utilcounter;

public class TestCounterFactory {
    public static void main(String[] args){
        CounterFactory oper = new CounterFactory();
        Double result = oper.createCounter(5d,"/",8d);
        System.out.println(result);
    }
}
