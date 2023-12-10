public class A {
    public static int x=10;
    public void method(){
        System.out.println("haha");

    }
   class B{
       private int x=0;

       public void method1(){
          //  method();
            System.out.println(x+" "+this.x+A.this.x);
                   }
    }
}
