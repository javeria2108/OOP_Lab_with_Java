import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Customer implements Serializable {

    public Customer() {
    }

    public String id;
    public Person personDetails;
    public List<Account> AClist=new ArrayList<>();
    public static int Count=0;
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public Person getPersonDetails() {
        return personDetails;
    }

    public void setPersonDetails(Person personDetails) {
        this.personDetails = personDetails;
    }
    public List<Account> getAClist() {
        return AClist;
    }

    public void setAClist(List<Account> AClist) {
        this.AClist = AClist;
    }

    public static int totalAccountsCounter;
    public int totalAccounts;

    public Customer(Person p) {
        Random r=new Random();
        Count=r.nextInt();
        id = "CS" + Count;

        personDetails = p;

    }

    @Override
    public String toString() {
        String s=   "Customer details:\n" + this.personDetails+"\n" +"Acounts:"+this.AClist;

        return s;
    }
    public float getTotal(){
        float total=0;
        for (Account a:AClist){
            total+=a.amount;
        }
        return total;

    }
    public void withdraw(float amount,String AccNo){
        for (Account a : AClist){
            if (AccNo.equals(a.getNumber())){
                if (amount>a.amount){
                    System.out.println("Warning: You don't have enough balance");
                }
                else {
                    a.amount-=amount;
                    System.out.println("Amount "+ amount+ " successfully withdrawn\n"+
                            "remaining amount: "+ a.amount);
                }}

        }}
    public void deposit(float amount, String AccNo){
        for (Account a : AClist){
            if (AccNo.equals(a.getNumber())){
                a.deposit(amount);
            }
        }
        System.out.println("Amount "+amount+" successfully deposited");

    }
    public void AddAccount(Account a){
        this.AClist.add(a);

    }






}
