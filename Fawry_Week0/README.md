# E-Commerce Shopping Cart System

A Java-based e-commerce shopping cart system that demonstrates object-oriented programming principles including inheritance, interfaces, and polymorphism.

## Project Structure

The project consists of the following main components:

### Core Classes

- **`Product`** - Base product class with name, price, and quantity
- **`ShippableProduct`** - Products that can be shipped (extends Product, implements Shippable)
- **`ExpirableProduct`** - Products with expiry dates (extends Product, implements Expirable)
- **`ExpirableShippableProduct`** - Products that are both shippable and expirable

### Interfaces

- **`Shippable`** - Interface for products that can be shipped
- **`Expirable`** - Interface for products with expiry dates
- **`IShippingService`** - Interface for shipping services

### Cart Management

- **`Cart`** - Shopping cart that holds cart items
- **`CartItem`** - Individual items in the cart with quantity

### Services

- **`Customer`** - Customer with balance and cart management
- **`ShippingService`** - Handles shipping calculations and notifications
- **`CheckoutService`** - Processes checkout operations

## Features

### Product Management

- Support for regular products, shippable products, and expirable products
- Inventory tracking with stock validation
- Expiry date checking to prevent sale of expired products

### Shopping Cart

- Add items to cart with quantity validation
- Automatic consolidation of duplicate items
- Stock availability checking
- Expired product filtering

### Checkout Process

- Balance validation before purchase
- Shipping cost calculation based on weight
- Detailed receipt generation
- Inventory updates after successful purchase

### Shipping

- Weight-based shipping calculations (15.0 per kg)
- Shipping notices with product details
- Support for mixed cart items (shippable and non-shippable)

## How to Run

1. Compile the Java files:

```bash
javac src/*.java
```

2. Run the main class:

```bash
java -cp src Main
```

## Example Usage

The `Main` class demonstrates the system with:

- Creating different types of products (Laptop, Smartphone, Milk)
- Adding items to a customer's cart
- Processing checkout with balance validation and shipping

```java
// Create products
Product product1 = new Product("Laptop", 1200.00, 5);
ShippableProduct product2 = new ShippableProduct("Smartphone", 800.00, 10, 2);
ExpirableProduct expirableProduct = new ExpirableProduct("Milk", 2.50, 20, "2026-12-31");

// Create customer
Customer customer1 = new Customer("Ahmed", 15000.00);

// Add items to cart
customer1.getCart().addItem(product1, 1);
customer1.getCart().addItem(product2, 2);
customer1.getCart().addItem(expirableProduct, 3);

// Process checkout
customer1.checkout();
```

## Sample Output

The system generates:

- **Shipment notice** - Details of items being shipped with weights
- **Checkout receipt** - Itemized list with subtotal, shipping, and total
- **Balance updates** - Remaining customer balance after purchase

## Key Design Patterns

- **Inheritance** - Product hierarchy with specialized product types
- **Interface Implementation** - Shippable and Expirable behaviors
- **Polymorphism** - Different product types handled uniformly
- **Service Layer** - Separation of concerns with dedicated services

This project demonstrates fundamental OOP concepts and provides a foundation for a more complex e-commerce system.
