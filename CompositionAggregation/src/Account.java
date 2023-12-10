import java.io.*;
import java.util.Random;

public class Account implements Serializable{
    public String number;
    public float amount;
    public Customer ACholder;
    public static int count;

    public float getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        Account.count = count;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Customer getACholder() {
        return ACholder;
    }

    public void setACholder(Customer ACholder) {
        this.ACholder = ACholder;
    }

    @Override
    public String toString() {
        String s="Account number:"+number+"\nowner: "+ ACholder.getPersonDetails().Name +": " + ACholder.id+"\namount: "+amount+"\n";
        return s;
    }

    public Account(float amount, Customer c){
        Random r=new Random();
        count= r.nextInt();
                number="AC"+count;
                ACholder=c;
                this.amount=amount;

    }
    public float withdraw(float amount){
        if (amount>this.amount){
            System.out.println("Warning: You don't have enough balance");
        }
        else {
            this.amount-=amount;
           // a.withdraw(amount);
            System.out.println("Amount "+ amount+ " successfully withdrawn\n"+
                    "remaining amount: "+ this.amount);
        }
            return this.amount;

    }
    public float deposit(float a){
        this.amount+=a;
        System.out.println("Amount "+a+" successfully deposited. Total Balance: "+this.amount);
        return this.amount;
    }

}
