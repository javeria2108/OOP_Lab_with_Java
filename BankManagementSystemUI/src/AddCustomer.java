import javax.swing.*;
import java.awt.event.*;
import java.io.IOException;

public class AddCustomer extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;

    public AddCustomer() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    onAdd();
                } catch (IOException ex) {
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
    }

    private void onAdd() throws IOException {
        // add your code here

        if (Person.searchPerson(textField2.getText())!=null) {
            Bank.addClient(Person.searchPerson(textField2.getText()));
            ManageCustomer m=new ManageCustomer();
            m.pack();
            m.setVisible(true);
            this.setVisible(false);

        }
        else{
            textField2.setText("person with this CNIC doesn't exist");
        }




        //dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        bankGUI b=new bankGUI();
        b.pack();
        b.setVisible(true);
        this.setVisible(false);

        dispose();
    }

    public static void main(String[] args) {
        AddCustomer dialog = new AddCustomer();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
