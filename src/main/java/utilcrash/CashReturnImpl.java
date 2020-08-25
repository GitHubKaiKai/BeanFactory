package utilcrash;

public class CashReturnImpl implements CashSuper {
    private Double moneyCondition = 300.0d;
    private Double moneyReturn = 100.0d;
    @Override
    public Double acceptCash(Double money) {
        if (money >= moneyCondition){
            return money - (money/moneyCondition)*moneyReturn;
        }
        System.out.println("单价不符!");
        return null;
    }
}
