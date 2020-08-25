package utilcrash;

public class CashRebateImpl implements CashSuper {
    private Double moneyRebate = 0.8d;
    @Override
    public Double acceptCash(Double money) {
        return moneyRebate * money;
    }
}
