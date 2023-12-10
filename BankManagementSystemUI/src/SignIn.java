import javax.swing.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class SignIn extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField textField1;
    private JPasswordField passwordField1;
    private int count;
    ArrayList<String> Username=new ArrayList<String>();
    ArrayList<String> Password=new ArrayList<String>();
    String Phone;
    String CNIC;


    public SignIn() throws FileNotFoundException {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        File file = new File("src/users.txt");
        Scanner sc = new Scanner(file);

// read() method : reading and printing Characters
        // one by one
        while (sc.hasNextLine())
        {
            String l=sc.nextLine();
            String st[]=l.split(" ");
             Username.add(st[0]);
             Password.add(st[1]);
//             Phone=st[2];
//            CNIC=st[3];





            System.out.println(Username+" "+ Password);

        }

    }

    private void onOK() {
        String u=textField1.getText();
        for (String s:Username){
            if (s.equals(u)){
             int index=   Username.indexOf(s);
             for (String p:Password){
                 String pw=Password.get(index);
                 if(!passwordField1.getText().equals(pw)){
                     count++;
                     passwordField1.setText("");
                     if(count==3){
                         buttonOK.setEnabled(false);
                     }
             } else{

                     dispose();}


            }

        }
}
        // add your code here

    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) throws FileNotFoundException {
        SignIn dialog = new SignIn();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
