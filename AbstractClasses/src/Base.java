// Abstract class
abstract class Base {

    // Constructor of class 1
    Base()
    {
        // Print statement
        System.out.println("Base Constructor Called");
    }

    // Abstract method
    public abstract void fun();
    // public abstract void extrafun(){

     //} //abstract method cant have body and non-abstract class cant ave abstract func
     ///non-abstract method. abstract class can have no abstract function
    private void nofun()
    {
        System.out.println("no abstract of astract class");
    }
    // final method cant be overriden
    final void lastfun()
    {
        System.out.println("Base lastfun() called");
    }
    public static void staticfun()
    {
        // Print statement
        System.out.println("independent Fun");
    }
}

// class extending from abstract class
class Derived extends Base {

    // Constructor of class2
    Derived()
    {   super.staticfun();
        System.out.println("Derived Constructor Called");
    }
    void nofun()
    {
        System.out.println("no abstract of astract class");
    }
// modifiers should be same in overriding
    // Method of class2
    // void fun() // error cz the access specifier is changing from pulic to non-specified ie stronger to weaker
    public void fun(){
        System.out.println("Derived fun() called");
       // super.nofun();
        super.lastfun();
        super.staticfun();

    }
//    final void lastfun()
//    {
//        System.out.println("Base lastfun() called");
//    }
}

/*class ExtraDrive extends Base
{
    int y=0;
    public void liveLetLive()
    {

    }
}*/ // have to declare the class abbstract if not implementing abstract function of its parent class

// Main class
class AbstractEx {

    // Main driver method
    public static void main(String args[])
    {
        //reference of abstract class
        Base b;
        b=new Base() {
            @Override
            public void fun() {
                System.out.println("yayyyyy");
            }
        }; //semi colon because it is a same statement
       b.staticfun();
        b.fun();



        //anonymous class, does not have any name
        //trying to create object of abs class - not allowed
        // b=new Base();
        // Creating object of class 2
        Derived d = new Derived();
        Base d2=new Derived();
        d2.fun();
        d.fun();
       // b=d;//base class reference,child object




    }
}


