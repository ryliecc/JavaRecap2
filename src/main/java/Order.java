import java.util.List;

public record Order(String orderId, List<Product> orderedProducts) {
}
