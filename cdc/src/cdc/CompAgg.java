package cdc;

class Room
{
    public Room()
    {
        System.out.println("Room Created");
    }
    protected void finalize()
    {
        System.out.println("Room being destroyed");

    }
}
class Person
{
    public Person()
    {
        System.out.println("Person Created");
    }
    protected void finalize()
    {
        System.out.println("Person being destroyed");

    }
}
class House {
    private final Room room;

    public House() {
        System.out.println("House created");
        room = new Room();
    }
    protected void finalize()
    {
        System.out.println("House being destroyed");

    }
}
public class CompAgg {
    public static void main(String args[])
    {int i=9;
        Person p=new Person();

        if( i==9)
        {
            House h=new House();

        }
        System.gc();
        System.out.println("Out and about");
    }
}