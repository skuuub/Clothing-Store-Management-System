// Represent a single product. This is the base class for all the product types
import java.time.LocalDate;
public class Product {
    public double price; // price of the product
    public String title; // title of the product
    public java.time.LocalDate listingDate; // when the product first brought to the inventory

    public double getPrice() {return price;}
    public String getTitle() {return title;}
    public LocalDate getListingDate() {return listingDate;}

    @Override
    public String toString() {
        return "Product Title = " + title + "       | Product Price = " + price + "         | Product Listing date = " + listingDate;
    }

}