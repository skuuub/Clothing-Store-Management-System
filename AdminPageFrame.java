// imports for important libraries
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

// class enables admin to access and modify product list
public class AdminPageFrame extends JFrame {
    private JTextField newItemField;
    private ItemList sharedItemList;

    // creates java swing components
    JList<Product> itemList;
    JScrollPane scrollPane;
    JButton addButton, deleteButton,backToMainButton;
    JPanel inputPanel, listPanel;

    // default constructor
    public AdminPageFrame(ItemList sharedItemList) {

        this.sharedItemList = ItemList.getInstance();
// setting java swing components
        setTitle("Admin Page");
        setSize(800, 700);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        itemList = new JList<>(sharedItemList.getItemListModel());
        scrollPane = new JScrollPane(itemList);

        newItemField = new JTextField();
        newItemField.setPreferredSize(new Dimension(150, 30));
        newItemField.setToolTipText("example: \"P123,123,2021-12-2\" \"Product type, price, date(YY-MM-DD)\"");

        // adding functionality for buttons
        addButton = new JButton("Add Item");
        addButton.addActionListener(e -> addItem());

        deleteButton = new JButton("Delete Selected Item");
        deleteButton.addActionListener(e -> deleteItem(itemList.getSelectedIndex()));

        backToMainButton = new JButton("Back to Main page");
        backToMainButton.addActionListener(e -> {
            new WelcomePageFrame();
            dispose();
        });

        setLayout(new BorderLayout());

        inputPanel = new JPanel();
        inputPanel.add(newItemField);
        inputPanel.add(addButton);

        listPanel = new JPanel(new BorderLayout());
        listPanel.add(backToMainButton, BorderLayout.NORTH);
        listPanel.add(scrollPane, BorderLayout.CENTER);
        listPanel.add(deleteButton, BorderLayout.SOUTH);

        add(inputPanel, BorderLayout.NORTH);
        add(listPanel, BorderLayout.CENTER);
        setVisible(true);
    }
// method that enables admin to add products to item list
    private void addItem() {
        long Starttime = System.currentTimeMillis();
        String newItem = newItemField.getText().trim();
        String pattern = "^[PJVS]\\d+,[^,]+,\\d{4}-\\d{2}-\\d{2}$";

        Pattern regex = Pattern.compile(pattern);
        Matcher matcher = regex.matcher(newItem);

        if (matcher.matches()) {
            String[] newProduct = newItem.split(",");
            String productTitle = newProduct[0];
            double productPrice = Double.parseDouble(newProduct[1]);
            LocalDate productDate = LocalDate.parse(newProduct[2]);

            switch (newProduct[0].charAt(0)) {
                case 'P' -> sharedItemList.addItem(new ProductPant(productPrice,productTitle,productDate));
                case 'J' -> sharedItemList.addItem(new ProductJeans(productPrice,productTitle,productDate));
                case 'S' -> sharedItemList.addItem(new ProductShirt(productPrice,productTitle,productDate));
                case 'V' -> sharedItemList.addItem(new ProductVest(productPrice,productTitle,productDate));
            }
            newItemField.setText("");
            System.out.println(newProduct);
        } else {
            JOptionPane.showMessageDialog(this, "Please enter a valid item. in this format \"Product type, price, date(YY-MM-DD)\"");
            newItemField.setText("");
        }
        long endTime = System.currentTimeMillis();
        long runTime = endTime - Starttime;
        JOptionPane.showMessageDialog(this,"runtime for Insert "+ runTime +"ms" );

    }
// method that enables admin to delete products from item list
    private void deleteItem(int selectedIndex) {
        long Starttime = System.currentTimeMillis();
        if (selectedIndex != -1) {
            Product selectedProduct = sharedItemList.getItemListModel().getElementAt(selectedIndex);
            String title = selectedProduct.getTitle();
            sharedItemList.deleteItem(selectedIndex);
            JOptionPane.showMessageDialog(this,"Item: " + title,"Item Deleted",JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Please select an item to delete.");
        }
        long endTime = System.currentTimeMillis();
        long runTime = endTime - Starttime;
        JOptionPane.showMessageDialog(this,"runtime for Delete "+ runTime +"ms" );
    }

}
