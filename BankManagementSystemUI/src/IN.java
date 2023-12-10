import javax.swing.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class IN extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JLabel Username;
    private JTextField textField1;
    private JTextField textField2;
String temp=" ";

    public IN() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    onOK();
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



    private void onOK() throws IOException {
        // add your code here
      // textField2.setText(textField1.getText());
       temp=textField2.getText();
       textField2.setText(textField1.getText());
       textField1.setText(temp);
        File path = new File("src/userinfo.txt");

        //passing file instance in filewriter
        FileWriter wr = new FileWriter(path, true);
        wr.write(textField1.getText());
        wr.write(" ");
        wr.write(textField2.getText());
        wr.write("\n");
        wr.flush();

        //closing the writer
        wr.close();





        // dispose();


    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        IN dialog = new IN();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
