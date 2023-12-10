import javax.swing.*;
import java.awt.event.*;
import java.io.IOException;

public class AddAccount extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField textField1;
    private JTextField textField2;
    private JButton addButton;
    private JButton manageAccountButton;

    public AddAccount() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

//        buttonOK.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                try {
//                    onOK();
//                } catch (IOException ex) {
//                    throw new RuntimeException(ex);
//                }
//            }
//        });

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
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    onAdd();
                } catch (IOException | ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        manageAccountButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onManageAcc();
            }
        });
    }

    private void onManageAcc() {
        ManageAccount m=new ManageAccount();
        m.pack();
        m.setVisible(true);
        this.setVisible(false);
    }

    private void onAdd() throws IOException, ClassNotFoundException {
        Filehandling.loadCustomers();
        Bank.addAccount(Float.parseFloat(textField2.getText()), Bank.searchCustomerDetail(textField1.getText()));
        System.out.println("account added");
        System.out.println();
        dispose();

    }

    private void onOK() throws IOException {
        // add your code here


        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        AddAccount dialog = new AddAccount();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
