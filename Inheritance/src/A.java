public class A {
    public int aa;
    private int ab;
    protected int ac;

    public static void flub(){
        System.out.println("I am A's public");
    }
    //public abstract void  draw();
    private void fpri(){
        System.out.println("I am A's private");
    }
    protected void fpro(){

        System.out.println("I am A's protected");

    }

    public A(int y){
        super();
        System.out.println("A's pram  coat");
    }
    public A(){
        System.out.println("A's default");
    }
    public void fnewA(){
        System.out.println("I am fnewa");

    }
}
class B extends A {
    public int ba;
    private int bb;
    protected int bc;

    public B() {
        System.out.println("I am B's default");
    }

    public static void flub() {

        System.out.println("I am B's public");
       // super.flub();
        //fpro();
    }

    private void fpri() {
        System.out.println("I am B's private");
        System.out.println();
    }

    protected void fpro() {
        System.out.println("I am B's protected");

    }


    public B(int x) {
       // super();

        super(8);
        System.out.println("B's pram  coat");
    }

    public void fnewb() {
        System.out.println("I am fnew b");
    }


    public static void main(String[] args) {
    //   A a = new A(45);
   //     B b = new B(78);

    //   A a1 = new A(10);
     // B b1 = new B(8);
     // A aa = new B();
        //a1.fnewB();
      //  aa.fnewA();
       // aa.fpro();
        //aa.aa = 99;
        // aa.ba //aa.bc //cant be accessed
        //aa.fnewB(); //Child function not working

        // b1=a;
        // B bb=new A();
       // b.flub();
        //a.flub();
        //a.fpro();
        //b.fpro();
        //b.fpri();
        //a.fnewA();
        //b.fnewb();
        //b.fnewA();
        //b.ac = 77;
        //b.flub();
        //u can access parents attribute by objects of child but not vice versa
        //a.ba
        //a.fnewB
//        A[] aaa = new A[5];
//        aaa[0] = new B();
//        aaa[1] = new A();
//        aaa[2]=new C();
//        aaa[3]=new C();
//        aaa[4]=new B();
//        for (int i = 0; i < aaa.length;i++){
//            aaa[i].fpro();//same function call changes it's behaviour: Polymorphism (this is the last concept of OOP)
//        }
        A b=new B();
        b.flub();
    }}

    class C extends A {
        public void fpro() {
            System.out.println("I am C's protected");
        }
        }




