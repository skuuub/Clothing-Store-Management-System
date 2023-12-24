// imports for important libraries
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.Border;

//A class that enable the Admin to log into the Admin page
public class AdminLogInFrame extends JFrame {

    // Creating Java swing components
    JTextField AdminUsernameField,AdminPasswordField;
    JButton submitButton;
    JLabel AdminUserNameLabel, AdminPasswordLabel;

    // default construction
    AdminLogInFrame () {
        // setting and formatting java swing elements.
        setTitle("Admin Log In page");
        setLayout(null);
        getContentPane().setBackground(new Color(3, 190, 252));
        setResizable(false);

        Border border = BorderFactory.createLineBorder(new Color(252, 252, 252), 1);
        AdminUserNameLabel = new JLabel("Username:");
        AdminUserNameLabel.setForeground(new Color(252, 252, 252));
        AdminUserNameLabel.setBounds(10, 20, 150, 30);

        AdminPasswordLabel = new JLabel("Password:");
        AdminPasswordLabel.setForeground(new Color(252, 252, 252));
        AdminPasswordLabel.setBounds(10, 20, 150, 30);


        AdminPasswordLabel.setBounds(10,60,100,30);
        AdminUserNameLabel.setBounds(10,20,100,30);


        AdminUsernameField = new JTextField(60);
        AdminUsernameField.setForeground(new Color(3, 190, 252));
        AdminUsernameField.setBackground(new Color(13, 2, 8));
        AdminUsernameField.setCaretColor(new Color(3, 190, 252));
        AdminUsernameField.setBorder(border);

        AdminPasswordField = new JPasswordField(60);
        AdminPasswordField.setForeground(new Color(3, 190, 252));
        AdminPasswordField.setBackground(new Color(13, 2, 8));
        AdminPasswordField.setCaretColor(new Color(3, 190, 252));
        AdminPasswordField.setBorder(border);

        submitButton = new JButton("Submit");
        AdminUsernameField.setBounds(150,20,80,30);
        AdminPasswordField.setBounds(150,60,80,30);
        submitButton.setBounds(150,150,80,30);

        // adding functionality to summit button
        submitButton.addActionListener(ae -> {
            if (AdminPasswordField.getText().equals("Admin") && AdminUsernameField.getText().equals("Admin")) {
                ItemList sharedItemList = ItemList.getInstance();
                new AdminPageFrame(sharedItemList);
                dispose();
            }
            else {
                JOptionPane.showMessageDialog(null,"Wrong password or user name",
                        "Incorrect Credentials", JOptionPane.ERROR_MESSAGE);
            }
        });

        add(AdminUserNameLabel);
        add(AdminPasswordLabel);
        add(AdminUsernameField);
        add(AdminPasswordField);
        add(submitButton);
        setSize(400,250);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
