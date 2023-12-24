// imports for important libraries
import java.time.LocalDate;

// Represents a single Vest. This class use the existing Product class as base
public class ProductVest extends Product {
    ProductCategory category = ProductCategory.Vest;

    ProductVest (double price,String title, LocalDate listingDate) {
        this.price = price;
        this.title = title;
        this.listingDate = listingDate;
    }

    public ProductCategory getCategory() {
        return category;
    }
}
