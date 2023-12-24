// imports for important libraries
import java.time.LocalDate;

// Represents a single Pant. This class use the existing Product class as base
public class ProductPant extends Product{
    ProductCategory category = ProductCategory.Pant;
    ProductPant (double price,String title, LocalDate listingDate) {
        this.price = price;
        this.title = title;
        this.listingDate = listingDate;
    }
    public ProductCategory getCategory() {
        return category;
    }
}
