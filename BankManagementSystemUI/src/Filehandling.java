import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Filehandling {
    static List<Person> persons = new ArrayList<>();
    static void loadPeople()
    {
        try {
            File file = new File("src/Persons.txt");
            Scanner sc = new Scanner(file);

// read() method : reading and printing Characters
            // one by one
            while (sc.hasNextLine())
            {
                String l=sc.nextLine();
                String st[]=l.split(" ");
                Person p=new Person(st[0],st[1],st[2]);
                persons.add(p);
                //System.out.println(persons);
               // System.out.println(l);

            }}
        catch(Exception e)
        {
            e.printStackTrace();
        }

    }
     static void loadAccounts() throws IOException, ClassNotFoundException {
        System.out.println("loading Accounts.....");
        FileInputStream fileInputStream = new FileInputStream("src/Accounts.txt");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        Bank.Aclist = (ArrayList<Account>) objectInputStream.readObject();
        System.out.println(Bank.Aclist);
        objectInputStream.close();
        fileInputStream.close();
    }

    private static void loadBank() throws IOException, ClassNotFoundException {
        System.out.println(">>>Loading Bank");

        loadPeople();
        loadCustomers();
        loadAccounts();




    }
     static void loadCustomers() throws IOException, ClassNotFoundException {
        System.out.println("loading Customers...");

        FileInputStream fileInputStream = new FileInputStream("src/Customers.txt");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        Bank.Cllist = (ArrayList<Customer>) objectInputStream.readObject();
        System.out.println(Bank.Cllist);
        objectInputStream.close();
        fileInputStream.close();


    }
    public static void  addPerson(){
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println("Enter the name ");

            Person p = new Person("","","");
            p.setName(sc.next());
            System.out.println("Enter the CNIC ");
            p.setCNIC(sc.next());
            System.out.println("Enter the Phone #");
            p.setNumber(sc.next());
            //creating the instance of file
            File path = new File("src/Persons.txt");

            //passing file instance in filewriter
            FileWriter wr = new FileWriter(path, true);

            //calling writer.write() method with the string
            //r.write("Geeks for Geeks \nWelcome to computer science portal \nHello Geek!!");
            wr.write(p.getName());
            wr.write(" ");
            wr.write(p.getCNIC());
            wr.write(" ");
            wr.write(p.getNumber());
            wr.write("\n");
            //flushing the writer
            wr.flush();

            //closing the writer
            wr.close();
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
       // loadPeople();
       //System.out.println(persons);

        addPerson();
    }


}
