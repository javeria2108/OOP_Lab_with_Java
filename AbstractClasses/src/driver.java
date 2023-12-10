public class driver {
    public static void main(String[] args) {
        A a=new A();
        a.method();
        A.B b=a.new B();
        b.method1();
       // A.B c=a.new B();
       // c.method1();
        A d=new A();
      //  A.B e=d.new B();// b.method();
      //  b.x=7;
      //  a.method1();


    }
}
