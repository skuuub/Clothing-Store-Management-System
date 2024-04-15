# Clothing Store Management System

## Overview

This project is a Clothing Store Management System designed to automate the inventory management of a clothes shop. The system allows the user to manage different types of clothing products, such as T-Shirts, Shirts, Pants, and Jeans, by providing functionalities for insertion, deletion, sorting, and searching of products.

## Project Structure

The project is organized into the following components:

1. **src/ folder**: Contains the source code for the project.
   - `Main.java`: The main driver class for the Clothing Store Management System.
   - `Product.java`: The base class representing a single product with attributes like price, title, and listing date.
   - `ProductCategory.java`: Enum defining different product categories.
   - `ProductTShirt.java` and `ProductJeans.java`: Classes representing specific product types, extending the `Product` class.
   - `ClothingStore.java`: Class implementing the inventory management system with methods for insertion, deletion, sorting, and searching.

2. **lib/ folder**: Contains any external libraries or dependencies (if any).

3. **data/ folder**: Placeholder for any data files or databases used by the system (if applicable).

4. **doc/ folder**: Documentation files related to the project.
   - `Pant_Info_*.csv`: Document for testing the code.

## Getting Started

### Prerequisites

- [Java Development Kit (JDK)](https://www.oracle.com/java/technologies/javase-downloads.html) installed.

### Installation

1. Clone the repository:

   ```bash
   git clone https://github.com/your-username/clothing-store-management.git
   ```

2. Navigate to the project directory:

   ```bash
   cd clothing-store-management
   ```

3. Compile the source code:

   ```bash
   javac src/Main.java
   ```

### Usage

1. Run the compiled program:

   ```bash
   java src/Main
   ```

2. Follow on-screen instructions to interact with the Clothing Store Management System.

## Testing

### Performance Testing

- The system has been tested for performance using various scenarios, including:
  - Creation of thousands of products in each category.
  - Deletion and insertion of products at different positions.
  - Measurement of time for each operation.


## Contributors

- Oluwabukunmi David Jaiyeola
- Oluwatobi Akeju

## License

This project is licensed under the [MIT License](LICENSE).

---


