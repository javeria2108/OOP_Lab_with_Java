import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Customer implements Serializable {
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

    public List<Account> getAClist() {
        return AClist;
    }

    public void setAClist(List<Account> AClist) {
        this.AClist = AClist;
    }

    public Person getPersonDetails() {
        return personDetails;
    }

    public void setPersonDetails(Person personDetails) {
        this.personDetails = personDetails;
    }

    public static int getCount() {
        return Count;
    }

    public static void setCount(int count) {
        Customer.Count = count;
    }

    @Override
    public String toString() {
        String s=   "Customer details:\n" + this.personDetails+"\n" ;

        return s;
    }
    public Customer(Person p) throws IOException {
        Random r=new Random();
        Count=r.nextInt();
        id = "CS" + Count;

        personDetails = p;


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
                 a.withdraw(amount);
                     System.out.println("Amount "+ amount+ " successfully withdrawn\n"+
                     "remaining amount: "+ a.amount);
             }}

     }}
//     public void deposit(float amount, Account b){
//         for (Account a : AClist){
//             if (b.getNumber().equals(a.getNumber())){
//                 a.amount+=amount;
//                 a.deposit(amount);
//                 System.out.println("Amount "+amount+" successfully deposited");
//             }
//             else {
//                 System.out.println("Request couldn't proceed");
//             }
//         }


   //  }
    public void AddAccount(Account a){
        AClist.add(a);

    }



}

