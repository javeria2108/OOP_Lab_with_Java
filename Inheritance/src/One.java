public class One {
    public static void Process(){
        System.out.println("One's porcess");
    }
}
class Two extends One{
    public static void Process(){
        System.out.println("two");
        }

    public static void main(String[] args) {
        One one =new Two();
        one.Process();
    }
        }
