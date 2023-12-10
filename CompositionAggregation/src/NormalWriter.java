

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class NormalWriter {
    public static void main(String[] args) throws IOException
    {
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
}
