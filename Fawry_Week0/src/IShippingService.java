import java.util.List;

public interface IShippingService {
    String getName(Product product);
    double getWeight(double weight, int quantity);
    void shipProduct(List<CartItem> items);
    double calculateShipping(List<CartItem> items);
}