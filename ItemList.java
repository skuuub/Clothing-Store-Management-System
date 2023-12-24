// imports for important libraries
import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import javax.swing.*;

// the main data structure model for the program
public class ItemList {
    private static ItemList instance;
    private DefaultListModel<Product> itemListModel;
    private ArrayList<Product> dataList;

    private ItemList() {
        itemListModel = new DefaultListModel<>();
        dataList = new ArrayList<>();
        InsertCSVData();
    }

    public static synchronized ItemList getInstance() {
        if (instance == null) {
            instance = new ItemList();
        }
        return instance;
    }

    public DefaultListModel<Product> getItemListModel() {
        return itemListModel;
    }

    public void addItem(Product newItem) {
        itemListModel.addElement(newItem);
    }

    public void deleteItem(int index) {
        itemListModel.remove(index);
    }

    // inserting the items from the CSV file
    public void InsertCSVData() {
        dataList = new ArrayList<Product>();
        File file = new File("Pant_Info_1K.csv");

        try (Scanner fileScanner = new Scanner(file)) {
            ArrayList<String> lines = new ArrayList<>();

            while (fileScanner.hasNextLine()) {
                lines.add(fileScanner.nextLine());
            }

            for(int i = 1; i < lines.size(); i++) {
                String line = lines.get(i);
                String[] data = line.split(",");


                String productTitle = data[1];
                double productPrice = Double.parseDouble(data[2]);
                LocalDate productDate = LocalDate.parse(data[3]);

                switch (productTitle.charAt(0)) {
                    case 'P' -> dataList.add(new ProductPant(productPrice,productTitle,productDate));
                    case 'J' -> dataList.add(new ProductJeans(productPrice,productTitle,productDate));
                    case 'S' -> dataList.add(new ProductShirt(productPrice,productTitle,productDate));
                    case 'V' -> dataList.add(new ProductVest(productPrice,productTitle,productDate));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (Product product : dataList) {
            addItem(product);
        }
    }
    // sort method  by date
    public void sortItemsDate(boolean ascending) {
        long Starttime = System.currentTimeMillis();
        List<Product> productList = Collections.list(itemListModel.elements());
        productList.sort(Comparator.comparing(Product::getListingDate));

        if (!ascending) {
            Collections.reverse(productList);
        }

        itemListModel.clear();
        for (Product product : productList) {
            itemListModel.addElement(product);
        }
        long endTime = System.currentTimeMillis();
        long runTime = endTime - Starttime;
        JOptionPane.showMessageDialog(null,"runtime for Sort by date "+ runTime +"ms" );
    }
    // sort method by price
    public void sortItemsPrice(boolean ascending) {
        long StartTime = System.currentTimeMillis();
        List<Product> productList = Collections.list(itemListModel.elements());
        productList.sort(Comparator.comparing(Product::getPrice));

        if (!ascending) {
            Collections.reverse(productList);
        }

        itemListModel.clear();
        for (Product product : productList) {
            itemListModel.addElement(product);
        }
        long endTime = System.currentTimeMillis();
        long runTime = endTime - StartTime;
        JOptionPane.showMessageDialog(null,"runtime for Sort by price "+ runTime +"ms" );
    }
}
