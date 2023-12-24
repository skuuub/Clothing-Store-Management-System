// imports for important libraries
import java.time.LocalDate;

// Represents a single Jeans. This class use the existing Product class as base
public class ProductJeans extends Product{
    ProductCategory category = ProductCategory.Jeans;
    ProductJeans (double price,String title, LocalDate listingDate) {
        this.price = price;
        this.title = title;
        this.listingDate = listingDate;
    }

    public ProductCategory getCategory() {
        return category;
    }
}