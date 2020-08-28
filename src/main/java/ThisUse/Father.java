package ThisUse;

public class Father {
    public void service(String meyhod){
        if ("get".equals(meyhod)){
            this.doGet();
        } else if ("post".equals(meyhod)){
            this.doPost();
        }
    }
    public void doGet(){
        System.out.println("Father doGet is run..");
    }
    public void doPost(){
        System.out.println("Father doPost is run ..");
    }
}
