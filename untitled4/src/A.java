// design pattern: predetermined solution of a problem
// Singleton design pattern: ensures only 1 object of a class


public class A {
    private static A a;
    private A(){
        System.out.println("hdd");
        String name=new String();
    }
    public static A getInt(){
        if (a==null){
            a=new A();
        }
        return a;
    }

    public static void main(String[] args) {
        //A x;
        //A y;
      //  x=A.getInt();
      //  y=A.getInt();
        A b=new A();
        A c=new A();
    }
}
