// imports for important libraries
import java.time.LocalDate;

// Represents a single Shirt. This class use the existing Product class as base
public class ProductShirt extends Product {
    ProductCategory category = ProductCategory.Shirt;
    ProductShirt (double price,String title, LocalDate listingDate) {
        this.price = price;
        this.title = title;
        this.listingDate = listingDate;
    }
    public ProductCategory getCategory() {
        return category;
    }
}
