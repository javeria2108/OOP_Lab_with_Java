public class Person {
    protected String name;
    protected String address;
    public Person(){
        name="Sherlock Holmes";
        address="221B Baker's Street";
    }
    public Person (String n,String a){
        name=n;
        address=a;
    }

    @Override
    public String toString() {
        return "Name: " + name + "\n" +"Address: "+ address;
    }
}
