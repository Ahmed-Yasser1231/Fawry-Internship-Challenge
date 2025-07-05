import java.util.List;

public class ShippingService implements IShippingService {

    public String getName(Product product) {
        return product.getName();
    }

    public double getWeight(double weight, int quantity) {
        return weight * quantity;
    }

    public void shipProduct(List<CartItem> items) {
        try {
            double totalWeight = 0;
            System.out.println("** Shipment notice **");
            for (CartItem item : items) {
                if (item.getProduct() instanceof Shippable shippable) {
                    int quantity = item.getQuantity();
                    double weight = shippable.getWeight();
                    totalWeight += weight * quantity;
                    System.out.printf("%dX %-12s      %.2fg%n", quantity, getName(item.getProduct()), getWeight(weight * 1000, quantity));
                }
            }

            System.out.printf("Total package weight %.2fkg%n", totalWeight);
            System.out.println();
        } catch (Exception ex) {
            System.out.println("An error occurred while shipping the product: " + ex.getMessage());
        }
    }

    public double calculateShipping(List<CartItem> items) {
        double totalKGs = 0;

        for (CartItem item : items) {
            if (item.getProduct() instanceof Shippable shippable) {
                totalKGs += shippable.getWeight() * item.getQuantity();
            }
        }

        double shippingFeePerKg = 15.0;

        return totalKGs * shippingFeePerKg;
    }
}