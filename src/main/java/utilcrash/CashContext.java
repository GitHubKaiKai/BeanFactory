package utilcrash;

public class CashContext {
    private CashSuper cs;
    public CashContext(String  type){
        switch (type){
            case "正常收费":
                cs = new CashNormalImpl();
                break;
            case "满减":
                cs = new CashReturnImpl();
                break;
            case "打折":
                cs = new CashRebateImpl();
                break;
        }
    }
    public Double getResult(Double money){
        return cs.acceptCash(money);
    }
}
