import javax.swing.*;
import java.awt.event.*;
import java.io.IOException;

public class ManageAccount extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JButton depositMoneyButton;
    private JButton withdrawMoneyButton;

    public ManageAccount() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

//        buttonOK.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                onOK();
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
        depositMoneyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    onDeposit();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                } catch (ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        withdrawMoneyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onWithdraw();
            }
        });
    }

    private void onWithdraw() {
        withdraw w=new withdraw();
        w.pack();
        w.setVisible(true);
        this.setVisible(false);
    }

    private void onDeposit() throws IOException, ClassNotFoundException {

        DEPOSITCLIENT d=new DEPOSITCLIENT();
        d.pack();
        d.setVisible(true);
        this.setVisible(false);
    }

    private void onOK() {
        // add your code here
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        bankGUI b=new bankGUI();
        b.pack();
        b.setVisible(true);
        this.setVisible(false);
        dispose();
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
Filehandling.loadCustomers();
Filehandling.loadAccounts();

        System.out.println(Bank.Aclist);
        System.out.println(Bank.Cllist);

        ManageAccount dialog = new ManageAccount();
        dialog.pack();
        dialog.setVisible(true);

        System.exit(0);

    }
}
