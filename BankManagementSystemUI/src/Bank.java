import java.io.*;
import java.util.ArrayList;

import java.io.FileInputStream;
import java.io.InputStream;
public class Bank implements Serializable {
    public String name;
    public static ArrayList<Customer> Cllist=new ArrayList<>() ;
    public static ArrayList<Account> Aclist=new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Bank(String name) throws FileNotFoundException {
        this.name=name;

    }
    public static Customer addClient(Person p) throws IOException {
        Customer d=new Customer(p);
        Cllist.add(d);
        System.out.println("New Customer added:"+d.id);

        FileOutputStream f=new FileOutputStream("src/Customers.txt");
        ObjectOutputStream o = new ObjectOutputStream(f);
        o.writeObject(Cllist);
        o.close();
        f.close();



        return d;
    }

    @Override
    public String toString() {
        String s="Bank name: { "+ name+"} \n Current Customers:{ " +Cllist+" } \n Accounts: {" + Aclist +" }";

        return s;
    }
    static Account addAccount(float amount, Customer c) throws IOException {
        Account a=new Account(amount,c);
        Aclist.add(a);
        c.AddAccount(a);

        FileOutputStream f=new FileOutputStream("src/Accounts.txt");
        ObjectOutputStream o = new ObjectOutputStream(f);
        o.writeObject(Aclist);
        o.close();
        f.close();


        return a;
    }
    Account searchAccount(String id){
        for (Account a:Aclist){
            if (id.equals(a.getNumber())){
                return a;
            }
        }
        return null;

    }

    Boolean removeClient (String id){

        for (Customer c:Cllist){
            if (id.equals(c.getId())){
                for (Account a:c.AClist){
                    Aclist.remove(a);
                }
                c.AClist=null;
                Cllist.remove(c);
                break;

            }}


        return true;
    }
    float totalAmount(){
        float sum=0;
        for (Customer c:Cllist){
            for (Account a:c.AClist){
                sum+=a.amount;
            }
        }
        return sum;
    }
    static Customer searchCustomerDetail(String CNIC){
        for (Customer c:Cllist){
            if (CNIC.equals(c.getPersonDetails().CNIC)){
                return c;
            }
        }
        return null;
    }
}
