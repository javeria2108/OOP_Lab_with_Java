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
       Bank bank = loadBank();
        //the department only exists in the university
        loadPeople();
        loadCustomers();
        loadAccounts();
        Scanner input = new Scanner(System.in);
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
                        Customer c=bank.addClient(searchPerson(CNIC));
                        System.out.println(c);
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
                    System.out.println(bank.addAccount(am,bank.searchCustomerDetail(cnic)));}
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
                    bank.searchCustomerDetail(cnic2).withdraw(amount,AccNo);
                    break;}
                case "D":
                { System.out.println("enter Customer CNIC: ");
                    String cniC=sc.next();
                    System.out.println("enter amount to be deposited: ");
                    float amounT=sc.nextFloat();
                    System.out.println("enter Account number: ");
                    String Accno=sc.next();
                    bank.searchCustomerDetail(cniC).deposit(amounT,Accno);
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

    private static void loadAccounts() {
        System.out.println(">>> Loading Accounts");

                try{
                    FileInputStream fi = new FileInputStream("src/Accounts.txt");
                    ObjectInputStream oi = new ObjectInputStream(fi);
                    while (fi.available()!=0){
                    Account a=(Account)oi.readObject();
                    Bank.Aclist.add(a);}
                    oi.close();
                    fi.close();
                }
            // Read objects
         catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Error initializing stream");
        } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
    }

    private static Bank loadBank() throws FileNotFoundException {
        Bank bank=new Bank("MyBank");
        System.out.println(">>>Loading Bank");
        try{
            FileInputStream fi = new FileInputStream("src/Bank.txt");
            ObjectInputStream oi = new ObjectInputStream(fi);
            Bank b=(Bank)oi.readObject();
            System.out.println(b);


            oi.close();
            fi.close();
            return bank;
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Error initializing stream");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }return null;

    }





    private static void loadCustomers() throws IOException, ClassNotFoundException {
        System.out.println(">>>Loading Customers");

        try {
            FileInputStream fi = new FileInputStream("src/Customers.txt");

            ObjectInputStream oi = new ObjectInputStream(fi);
            while (fi.available() != 0) {
                Customer c = (Customer) oi.readObject();
                Bank.Cllist.add(c);
            }

            oi.close();
            fi.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Error initializing stream");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
        }



