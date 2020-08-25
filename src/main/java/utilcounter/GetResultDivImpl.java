package utilcounter;

public class GetResultDivImpl implements GetResult {
    public Double result(Double a,Double b){
        if (b!=0){
            return a/b;
        }

        return null;
    };
}
