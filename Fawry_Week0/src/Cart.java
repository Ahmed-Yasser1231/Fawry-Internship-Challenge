import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<CartItem> items;

    public Cart() {
        items = new ArrayList<>();
    }

    public List<CartItem> getItems() {
        return items;
    }

    public boolean addItem(Product product, int quantity) {
        if (product == null || quantity <= 0) {
            System.out.println("Invalid item, cannot add to cart.");
            return false;
        }

        if (quantity > product.getQuantity()) {
            System.out.println("Cannot add " + quantity + " of " + product.getName() + " to the cart, there is only " + product.getQuantity() + " available.");
            return false;
        }

        if (product instanceof Expirable) {
            Expirable expirable = (Expirable) product;
            if (expirable.isExpired()) {
                System.out.println("Cannot add expired product to the cart.");
                return false;
            }
        }

        CartItem existingItem = items.stream()
                .filter(item -> item.getProduct().getName().equals(product.getName()))
                .findFirst()
                .orElse(null);

        if (existingItem != null) {
            existingItem.setQuantity(existingItem.getQuantity() + quantity);
        } else {
            items.add(new CartItem(product, quantity));
        }

        return true;
    }
}