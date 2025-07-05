public class Main {
    public static void main(String[] args) {

        Cart cart = new Cart();
        Product product1 = new Product("Laptop", 1200.00 , 5);
        ShippableProduct product2 = new ShippableProduct("Smartphone", 800.00, 10, 2);
        ExpirableProduct expirableProduct = new ExpirableProduct("Milk", 2.50, 20, "2026-12-31");

        Customer customer1 = new Customer("Ahmed", 15000.00);


        customer1.getCart().addItem(product1, 1);
        customer1.getCart().addItem(product2, 2);
        customer1.getCart().addItem(expirableProduct, 3);

        customer1.checkout();



    }
}