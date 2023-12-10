interface Shape // interface defined
{
    final static float pi = 3.14F;
    static float q = 1.33F; // q=4/3
    int area=0; // must intialised the attribute
    // by default they are final even if you dont declare
    float compute (float x, float y, float z);
    // function in interface with default defination using special keyword
     default void draw()
    {
        System.out.println("default draw");
    }
}
class Cuboid implements Shape, Comparable // interface implemented
{

    public void draw() {
        Shape.super.draw();
    }

    public float compute (float x, float y, float z)
    {
        return (x*y*z);
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
class Sphere implements Shape
{
    public float compute (float x, float y, float z)
    {
        return (q*pi*x*x*x);
    }

    @Override
    public void draw() {
       Shape.super.draw();
        //System.out.println("drawing sphere");
    }
}
/*class Pyramid implements Shape{
    // has to implement all the functions in interface otherwise the class will become astract class
}*/
public class InterfaceEx
{
    public static void main (String args[])
    {
        Cuboid c = new Cuboid();
        Sphere s = new Sphere();
        Shape v;
        // can create only reference of interface but no object
        // unlike base class which can have its own objects
        //v=new Shape() ;
        //v.area=0;
        v = c; // v refers to cuboid object c
        System.out.println("Area of Cuboid = " + v.compute(11,9,8));

        v = s; // v refers to sphere object s
        System.out.println("Area of Sphere = " + v.compute(10,0,0));
        v.draw();
        //v.area=0;
        Shape q=new Shape() {
            @Override
            public float compute(float x, float y, float z) {
                return 0;
            }
        };
        q.compute(3,2,2);
        q.draw();
    }
}
