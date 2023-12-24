import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class WelcomePageFrame extends JFrame {
    // java swing elements
    JButton adminLoginButton;
    JButton enterStoreButton;
    JLabel welcomeLabel;
    // class for the welcome page, that allows for the user to manuver the progam
    WelcomePageFrame() {
        getContentPane().setBackground(new Color(252, 65, 86));
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Home Page");

        welcomeLabel = new JLabel("Welcome to Deez Clothing Store");
        welcomeLabel.setForeground(new Color(252, 252, 252));
        welcomeLabel.setFont(new Font("Mv Boli", Font.PLAIN, 30));
        welcomeLabel.setVerticalAlignment(JLabel.TOP);
        welcomeLabel.setHorizontalAlignment(JLabel.CENTER);
        welcomeLabel.setBounds(0,0,getWidth(),100);


        ImageIcon storeIcon = new ImageIcon("icons8-shop-94.png");
        enterStoreButton = new JButton("Enter Store");
        enterStoreButton.setBounds(0, 100, 250, 180);
        enterStoreButton.setFocusable(false);
        enterStoreButton.setIcon(storeIcon);
        enterStoreButton.setHorizontalTextPosition(JButton.CENTER);
        enterStoreButton.setVerticalTextPosition(JButton.BOTTOM);
        enterStoreButton.setFont(new Font("Comic Sans", Font.BOLD, 10));


        enterStoreButton.addActionListener(e -> {
            ItemList sharedItemList = ItemList.getInstance();
            new StorePageFrame(sharedItemList);
            dispose();
        });

        ImageIcon adminIcon = new ImageIcon("icons8-admin-94.png");
        adminLoginButton = new JButton("Admin Log In");
        adminLoginButton.setBounds(350, 100, 250, 180);
        adminLoginButton.setFocusable(false);
        adminLoginButton.setIcon(adminIcon);
        adminLoginButton.setHorizontalTextPosition(JButton.CENTER);
        adminLoginButton.setVerticalTextPosition(JButton.BOTTOM);
        adminLoginButton.setFont(new Font("Comic Sans", Font.BOLD, 10));


        adminLoginButton.addActionListener(e -> {
            AdminLogInFrame a = new AdminLogInFrame();
            a.setVisible(true);
            dispose();
        });


        add(adminLoginButton);
        add(enterStoreButton);
        add(welcomeLabel);
        setLocationRelativeTo(null);
        setLayout(null);
        setVisible(true);
        setResizable(false);
    }
}
