import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.io.File;
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

    public List<Account> getAclist() {
        return Aclist;
    }

    public void setAclist(List<Account> aclist) {
        Aclist = (ArrayList<Account>) aclist;
    }

    public List<Customer> getCllist() {
        return Cllist;
    }

    public void setCllist(List<Customer> cllist) {
        Cllist = (ArrayList<Customer>) cllist;
    }
    public Bank(String name) throws FileNotFoundException {
        this.name=name;
        try {
            FileOutputStream f = new FileOutputStream(new File("src/Bank.txt"),true);
            ObjectOutputStream o = new ObjectOutputStream(f);
            o.writeObject(this);

            o.close();
            f.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    public Customer addClient(Person p){
        Customer d=new Customer(p);
        Cllist.add(d);
        System.out.println("New Customer added:"+d.id);
        return d;
    }

    @Override
    public String toString() {
        String s="Bank name: "+ name+"\n"
                +"Current customers:\n";
                for (Customer c: Cllist) {
                    s += c.personDetails.Name + "\n";
                }
               s+="Accounts: \n";
                for (Account a:Aclist){
                    s+=a.number+"\n";
                }
                s+= "total amount in bank: "+totalAmount();

        return s;
    }
    Account addAccount( float amount, Customer c){
        Account a=new Account(amount,c);
        Aclist.add(a);
        c.AddAccount(a);
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
    Customer searchCustomerDetail(String CNIC){
        for (Customer c:Cllist){
            if (CNIC.equals(c.getPersonDetails().CNIC)){
                return c;
            }
        }
        return null;
    }
}
