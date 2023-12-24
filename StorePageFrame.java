// imports for important libraries
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class StorePageFrame extends JFrame {
    private JList<Product> itemList;
    private JTextField searchField;
    private ItemList sharedItemList;
    public ArrayList<Product> cartList;
    // creating java swing elements
    JScrollPane scrollPane;
    JButton searchButton, buyButton, sortByDateButton_New_to_Old, sortByDateButton_Old_to_New,
            sortByPriceButton_Expensive_to_Cheapest, sortByPriceButton_Cheapest_to_Expensive,backToWelcomePageButton, carButton;
    JPanel searchPanel, sortPanel;
    // class that creates the store
    public StorePageFrame(ItemList sharedItemList) {
        setTitle("Store App");
        setSize(1500, 800);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        this.sharedItemList = ItemList.getInstance();

        itemList = new JList<>(sharedItemList.getItemListModel());
        cartList = new ArrayList<>();

        scrollPane = new JScrollPane(itemList);

        searchField = new JTextField();
        searchButton = new JButton("Search");
        searchButton.addActionListener(e -> searchItem());

        sortByDateButton_New_to_Old = new JButton("Sort: Old to New");
        sortByDateButton_Old_to_New = new JButton("Sort: New to Old");

        sortByPriceButton_Expensive_to_Cheapest = new JButton("Sort: Expensive to Cheapest");
        sortByPriceButton_Cheapest_to_Expensive = new JButton("Sort: Cheapest to Expensive");

        sortByDateButton_New_to_Old.addActionListener(e -> sharedItemList.sortItemsDate(true));
        sortByDateButton_Old_to_New.addActionListener(e -> sharedItemList.sortItemsDate(false));

        sortByPriceButton_Expensive_to_Cheapest.addActionListener(e -> sharedItemList.sortItemsPrice(false));
        sortByPriceButton_Cheapest_to_Expensive.addActionListener(e -> sharedItemList.sortItemsPrice(true));

        buyButton = new JButton("Buy");
        buyButton.addActionListener(e -> buy(itemList.getSelectedIndex()));

        carButton = new JButton("Cart");
        carButton.addActionListener(e -> showCartContents());



        backToWelcomePageButton = new JButton("Back to Welcome Page");
        backToWelcomePageButton.addActionListener(e -> {
            new WelcomePageFrame();
            dispose();
        });

        setLayout(new BorderLayout());

        searchPanel = new JPanel();
        searchPanel.setLayout(new BorderLayout());
        searchPanel.add(searchField, BorderLayout.CENTER);
        searchPanel.add(searchButton, BorderLayout.WEST);

        sortPanel = new JPanel();
        sortPanel.setLayout(new FlowLayout());
        sortPanel.add(sortByDateButton_New_to_Old);
        sortPanel.add(sortByDateButton_Old_to_New);
        sortPanel.add(sortByPriceButton_Cheapest_to_Expensive);
        sortPanel.add(sortByPriceButton_Expensive_to_Cheapest);
        sortPanel.add(carButton);
        sortPanel.add(buyButton);
        sortPanel.add(backToWelcomePageButton);  // Add backButton to sortPanel

        getContentPane().setBackground(new Color(3, 190, 252));

        add(searchPanel, BorderLayout.NORTH);
        add(sortPanel, BorderLayout.SOUTH);  // Adjusted the placement
        add(scrollPane, BorderLayout.CENTER);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    // method for buying
    private void buy(int selectedIndex) {
        if (selectedIndex != -1) {
            Product selectedProduct = sharedItemList.getItemListModel().getElementAt(selectedIndex);
            String title = selectedProduct.getTitle();
            JOptionPane.showMessageDialog(this, "Item: " + title + " has been successfully bought","Purchase Confirmation",JOptionPane.INFORMATION_MESSAGE);

            cartList.add(selectedProduct);
            sharedItemList.deleteItem(selectedIndex);
        } else {
            JOptionPane.showMessageDialog(this, "Please select an item to buy.");
        }
    }
    // method for showing the cart
    private void showCartContents() {
        if (!cartList.isEmpty()) {
            StringBuilder cartMessage = new StringBuilder("Shopping Cart Contents:\n");
            for (Product product : cartList) {
                cartMessage.append(product.getTitle()).append("\n");
            }
            JOptionPane.showMessageDialog(null, cartMessage.toString(),"Shopping Cart",JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "The shopping cart is empty.", "Shopping Cart", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    // method for searching
    private void searchItem() {
        long Starttime = System.currentTimeMillis();
        String searchTerm = searchField.getText().trim();
        DefaultListModel<Product> model = sharedItemList.getItemListModel();

        for (int i = 0; i < model.size(); i++) {
            Product product = model.getElementAt(i);

            // Compare the title of the product (case-insensitive)
            if (product.getTitle().equalsIgnoreCase(searchTerm)) {
                itemList.setSelectedIndex(i);
                itemList.ensureIndexIsVisible(i);
                return;  // Exit the method if the item is found
            }
        }
        // If the loop completes without finding the item
        JOptionPane.showMessageDialog(this, "Item not found in Inventory.");

        long endTime = System.currentTimeMillis();
        long runTime = endTime - Starttime;
        JOptionPane.showMessageDialog(null,"runtime for search by date "+ runTime +"ms" );
    }
}
