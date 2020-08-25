package utilcounter;

public class CounterFactory {
    public static Double createCounter(Double numberA, String operate, Double numberB){
        GetResult getResult = null;
        switch (operate){
            case "+":
                getResult = new GetResultAddImpl();
                break;
            case "-":
                getResult = new GetResultSubImpl();
                break;
            case "*":
                getResult = new GetResultMulImpl();
                break;
            case "/":
                getResult = new GetResultDivImpl();
                break;
        }
        return getResult.result(numberA, numberB);
    }
}
