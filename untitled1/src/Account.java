import java.io.IOException;
import java.io.Serializable;
import java.util.Random;

public class Account implements Serializable {
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String id;
    private static String idcounter = "0";
    public String number;
    public float amount;
    public Customer ACholder = new Customer();
    public static int count;
    public Account(float amount, Customer c) throws IOException {
        Random r=new Random();
        count= r.nextInt();
        number="AC"+count;
        ACholder=c;


        this.amount = amount;
        ACholder.setAClist(c.getAClist());
        ACholder.setPersonDetails((c.getPersonDetails()));


    }



    @Override
    public String toString() {
        String s="Account number:"+this.number+"\nowner: "+ this.ACholder.getPersonDetails().Name +": " + this.ACholder.id+"\namount: "+this.amount+"\n";
        return s;}

    public String getNumber() {
        return number;
    }

    public String setNumber(String Number) {
        this.number = Number;
        return number;
    }


    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public Customer getHolder() {
        return ACholder;
    }

    public void setHolder(Customer holder) {
        this.ACholder = holder;
    }

    public float withdraw(float amount){
        this.amount-=amount;
        return this.amount;

    }
    public float deposit(float a){
        this.amount+=a;
        return amount;
    }


}

