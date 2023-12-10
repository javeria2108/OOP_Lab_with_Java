import javax.swing.*;
import java.awt.event.*;

public class CalCulator extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField textField1;
    private JTextField textField2;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JTextField textField3;

    public CalCulator() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);


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
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onAdd();
            }
        });
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onSubtract();
            }
        });
        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               onMultiply();
            }
        });
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onDivide();
            }
        });
    }

    private void onDivide() {
        int a=Integer.parseInt(textField1.getText())/Integer.parseInt(textField2.getText());
        textField3.setText(String.valueOf(a));
    }

    private void onMultiply() {
        int a=Integer.parseInt(textField1.getText())*Integer.parseInt(textField2.getText());
        textField3.setText(String.valueOf(a));

    }

    private void onSubtract() {
        int a=Integer.parseInt(textField1.getText())-Integer.parseInt(textField2.getText());
        textField3.setText(String.valueOf(a));


    }

    private void onAdd() {
        int a=Integer.parseInt(textField1.getText())+Integer.parseInt(textField2.getText());
        textField3.setText(String.valueOf(a));

    }


    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        CalCulator dialog = new CalCulator();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
