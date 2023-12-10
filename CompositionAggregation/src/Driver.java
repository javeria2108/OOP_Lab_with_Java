import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Driver {
    private static List<Person> persons = new ArrayList<Person>();

    public Driver() throws FileNotFoundException {
    }

    private static Person  searchPerson(String ID)
    {
        for(Person p:persons)
        {
            if(p.getCNIC().compareTo(ID)==0)
                return p;
        }
        return null;
    }

    private static void loadPeople()
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
                System.out.println(l);

            }}
        catch(Exception e)
        {
            e.printStackTrace();
        }

    }


    public static void main(String args[]) throws IOException, ClassNotFoundException {
        Scanner sc=new Scanner(System.in);
        Bank bank=new Bank("MyBank");
       loadBank();
        //the department only exists in the university


        String choice=new String();
        while(choice.compareTo("F")!=0)
        {
            System.out.println("Enter the following \n C - adding clients \n A - adding account");
            System.out.println(" W - withdrawing money \n D - deposit money \n I - client Info \n B- Bank's Info ");
            System.out.println(" X - Account detail \n F - exit");
            choice= sc.next();
            switch(choice)
            {
                case "C":
                {
                    System.out.println("enter CNIC: ");
                    String CNIC=sc.next();
                    if (searchPerson(CNIC)!=null){

                        System.out.println(bank.addClient(searchPerson(CNIC)));;
                    }
                    else{
                        System.out.println("person with this CNIC doesn't exist");
                    }


                    break;
                }
                case "A":
                { System.out.println("enter Customer CNIC: ");
                    String cnic=sc.next();
                    if (bank.searchCustomerDetail(cnic)!=null){
                    System.out.println("enter amount for opening account: ");
                    float am=sc.nextFloat();
                    System.out.println(bank.addAccount(am,bank.searchCustomerDetail(cnic)));
                        }
                    else {
                        System.out.println("Client with this cnic doesn't exist");
                    }
                    break;
                }
                case "W":
                { System.out.println("enter Customer CNIC: ");
                    String cnic2=sc.next();
                    System.out.println("enter amount to be withdrawn: ");
                    float amount=sc.nextFloat();
                    System.out.println("enter Account number: ");
                    String AccNo=sc.next();
                   if (bank.searchCustomerDetail(cnic2)!=null){
                       for (Account a: bank.searchCustomerDetail(cnic2).AClist){
                           if (AccNo.equals(a.getNumber())){
                               a.withdraw(amount);
                           }
                       }
                   }
                    break;}
                case "D":
                { System.out.println("enter Customer CNIC: ");
                    String cniC=sc.next();
                    System.out.println("enter Account number: ");
                    String Accno=sc.next();
                   if  (bank.searchCustomerDetail(cniC)!=null){
                       for (Account a:bank.searchCustomerDetail(cniC).AClist ){
                           if (Accno.equals(a.getNumber())){
                               System.out.println("enter amount to be deposited: ");
                               float amounT=sc.nextFloat();

                               a.deposit(amounT);
                           }
                       }
                   }

                    FileOutputStream f=new FileOutputStream("src/Accounts.txt");
                    ObjectOutputStream o = new ObjectOutputStream(f);
                    o.writeObject(bank.Aclist);
                    o.close();
                    f.close();

                    break;}

                case "B":
                {
                   System.out.println(bank);
                    break;
                }
                case "I":
                {  System.out.println("enter Customer CNIC: ");
                    String cNiC=sc.next();
                    System.out.println(bank.searchCustomerDetail(cNiC));
                    break;}
                case  "X":
                {System.out.println("enter Account ID: ");
                    String AccID= sc.next();
                    System.out.println(bank.searchAccount(AccID));
                    break;}
                default:
                    System.out.println("Enter valid input");

            }
        }


    }

    private static void loadAccounts() throws IOException, ClassNotFoundException {
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
    private static void loadCustomers() throws IOException, ClassNotFoundException {
        System.out.println("loading Customers...");

        FileInputStream fileInputStream = new FileInputStream("src/Customers.txt");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        Bank.Cllist = (ArrayList<Customer>) objectInputStream.readObject();
        System.out.println(Bank.Cllist);
        objectInputStream.close();
        fileInputStream.close();


    }


        }



