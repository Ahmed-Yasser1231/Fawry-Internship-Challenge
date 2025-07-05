import java.util.List;

public class Customer {
    private String name;
    private double balance;
    private Cart cart;
    private ShippingService shippingService;

    public Customer(String name, double balance) {
        this.name = name;
        this.balance = balance;
        this.cart = new Cart();
        this.shippingService = new ShippingService();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public void checkout() {
        try {
            List<CartItem> items = cart.getItems();
            if (items == null || items.isEmpty()) {
                System.err.println("Cart is empty.");
                return;
            }

            double updatedBalance = CheckoutService.checkout(cart, shippingService, balance);
            if (updatedBalance != balance) {
                balance = updatedBalance;
                System.out.printf("Your remaining balance is: %.2f%n", balance);
                System.out.printf("Thank you for your purchase, %s!%n", name);
            }
        } catch (Exception ex) {
            System.err.println("An error occurred during checkout: " + ex.getMessage());
        }
    }
}