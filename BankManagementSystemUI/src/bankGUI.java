import javax.swing.*;
import java.awt.event.*;

public class bankGUI extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JButton addCustomerButton;
    private JButton manageCustomerButton;
    private JButton addAccountButton;
    private JButton manageAccountButton;
    private JButton depositAmountButton;
    private JButton createTransactionButton;
    private JButton closeButton;
    private JButton deleteCustomerButton;

    public bankGUI() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

//        buttonOK.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                onOK();
//            }
//        });

        closeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onClose();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onClose();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onClose();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        addCustomerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onAddCustomer();

            }
        });
        manageCustomerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onmanageCustomer();
            }
        });
        addAccountButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onAddAccount();
            }
        });
        manageAccountButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onManageAccount();
            }
        });
        depositAmountButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onDepositAmount();
            }
        });
        createTransactionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onCreateTrans();
            }
        });
        deleteCustomerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onDelCustomer();
            }
        });
    }

    private void onDelCustomer() {
        removeclient r=new removeclient();
        r.pack();
        r.setVisible(true);
        this.setVisible(false);
    }

    private void onCreateTrans() {
        withdraw w=new withdraw();
        w.pack();
        w.setVisible(true);
        this.setVisible(false);
    }

    private void onDepositAmount() {
        DEPOSITCLIENT c=new DEPOSITCLIENT();
        c.pack();
        c.setVisible(true);
        this.setVisible(false);
    }

    private void onManageAccount() {
        ManageAccount m=new ManageAccount();
        m.pack();
        m.setVisible(true);
        this.setVisible(false);
    }

    private void onAddAccount() {
        AddAccount a=new AddAccount();
        a.pack();;
        a.setVisible(true);
        this.setVisible(false);
    }

    private void onmanageCustomer() {
        ManageCustomer m=new ManageCustomer();
        m.pack();
        m.setVisible(true);
        this.setVisible(false);

    }

    private void onAddCustomer() {
        AddCustomer a=new AddCustomer();
        a.pack();
        a.setVisible(true);
        this.setVisible(false);

    }

//    private void onOK() {
//        // add your code here
//        dispose();
//    }

    private void onClose() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        bankGUI dialog = new bankGUI();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
