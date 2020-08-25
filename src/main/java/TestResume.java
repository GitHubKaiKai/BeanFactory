public class TestResume {
    public static void main (String[] args){
        Resume a = new Resume("大鸟");
        Resume c = a;
        Resume b = a;
        Resume d = new Resume("大鸟");
        System.out.println(a.getName());
        System.out.println(c.getName());
        System.out.println(b.getName());

    }
}
