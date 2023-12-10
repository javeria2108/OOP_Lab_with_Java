import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Person implements Serializable {
    public static List<Person> persons = new ArrayList<Person>();

    @Override
    public String toString() {
        return "Person{" +
                "Name='" + Name + '\'' +
                ", CNIC='" + CNIC + '\'' +
                ", number='" + number + '\'' +
                '}';
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getCNIC() {
        return CNIC;
    }

    public void setCNIC(String CNIC) {
        this.CNIC = CNIC;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }


    public Person(String name, String CNIC, String number) {
        Name = name;
        this.CNIC = CNIC;
        this.number = number;
    }

    public Person() {
    }


    String Name;
    String CNIC;
    String number;
}