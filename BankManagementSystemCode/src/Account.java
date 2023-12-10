import java.io.*;

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
        String s="Account number:"+this.number+"\nowner: "+ this.ACholder.id+"\namount: "+this.amount+"\n";
        return s;
    }
    public Account(float amount, Customer c){
                number="AC"+count;
                count++;
                ACholder=c;
                this.amount=amount;
                try {
                    FileOutputStream f=new FileOutputStream(new File("src/Accounts.txt"),true);
                    ObjectOutputStream o = new ObjectOutputStream(f);
                    o.writeObject(this);
                    o.close();
                    f.close();

                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

    }
    public float withdraw(float amount){
this.amount-=amount;
return this.amount;

    }
    public float deposit(float amount){
this.amount+=amount;
        return amount;
    }

}
