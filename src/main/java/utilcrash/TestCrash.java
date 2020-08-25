package utilcrash;

public class TestCrash {
    public static void main(String[] args){
        CashContext cc = new CashContext("满减");
        System.out.println(cc.getResult(8d));
    }

}
