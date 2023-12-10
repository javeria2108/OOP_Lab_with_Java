import javax.swing.*;
import java.awt.event.*;
import java.io.IOException;

public class DEPOSITCLIENT extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField textField1;
    private JTextField textField3;
    private JTextField textField4;

    public DEPOSITCLIENT() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    onOK();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                } catch (ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
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
//        buttonOK.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//
//            }
//        });
    }

    private void onOK() throws IOException, ClassNotFoundException {
        // add your code here
        Filehandling.loadCustomers();
        Filehandling.loadAccounts();
        String cniC=textField3.getText();

       // System.out.println("enter Account number: ");
        String Accno=textField4.getText();
        //if  (Bank.searchCustomerDetail(cniC)!=null) {
            for (Account a : Bank.searchCustomerDetail(cniC).AClist) {
                if (Accno.equals(a.getNumber())) {
                    //System.out.println("enter amount to be deposited: ");
                    float amounT = Float.parseFloat(textField1.getText());

                    a.deposit(amounT);

                }
           // }
        }
        confirmtab c=new confirmtab();
        c.pack();
        c.setVisible(true);
        this.setVisible(false);
        dispose();
    }


    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        DEPOSITCLIENT dialog = new DEPOSITCLIENT();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
