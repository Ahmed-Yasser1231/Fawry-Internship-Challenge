import java.util.List;

public class CheckoutService {

    public static double checkout(Cart cart, ShippingService shippingService, double balance) {
        shippingService.shipProduct(cart.getItems());
        System.out.println("** Checkout receipt **");

        for (CartItem item : cart.getItems()) {
            if (item.getQuantity() > item.getProduct().getQuantity()) {
                System.out.println(item.getProduct().getName() + " doesn’t have enough stock.");
                continue;
            }

            if (item.getProduct() instanceof Expirable expirable && expirable.isExpired()) {
                System.err.println(item.getProduct().getName() + " is expired and cannot be purchased.");
                continue;
            }

            System.out.printf("%dX %-12s      %.2f%n", item.getQuantity(), item.getProduct().getName(),
                    item.getProduct().getPrice() * item.getQuantity());
        }

        double subtotal = cart.getItems().stream()
                .mapToDouble(i -> i.getProduct().getPrice() * i.getQuantity())
                .sum();
        double shippingFees = shippingService.calculateShipping(cart.getItems());
        double total = subtotal + shippingFees;

        if (balance < total) {
            System.err.println("You do not have enough balance.");
            return balance;
        }

        for (CartItem item : cart.getItems()) {
            item.getProduct().setQuantity(item.getProduct().getQuantity() - item.getQuantity());
        }

        System.out.println("------------------------------------");
        System.out.printf("Subtotal     %.2f%n", subtotal);
        System.out.printf("Shipping     %.2f%n", shippingFees);
        System.out.printf("Amount       %.2f%n", total);
        System.out.println();

        return balance - total;
    }
}