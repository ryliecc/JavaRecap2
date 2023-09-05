import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        // ALL PRODUCTS
        Product p1 = new Product("PR3675", "iPhone 12");
        Product p2 = new Product("PR5789", "MacBook Air");
        Product p3 = new Product("PR2672", "AirPods Pro");
        Product p4 = new Product("PR5283", "AppleWatch");
        Product p5 = new Product("PR4678", "AirTag");

        Map<String, Product> allProducts = new HashMap<>();
        allProducts.put(p1.productId(), p1);
        allProducts.put(p2.productId(), p2);
        allProducts.put(p3.productId(), p3);
        allProducts.put(p4.productId(), p4);
        allProducts.put(p5.productId(), p5);

        // SHOP SERVICE
        ProductRepo productRepo = new ProductRepo(allProducts);
        OrderMapRepo orderMapRepo = new OrderMapRepo();
        ShopService shopService = new ShopService(productRepo, orderMapRepo);

        // NEW ORDER
        Product p6 = new Product("PR531812", "Samsung Galaxy S8");
        List<Product> orderedProducts = new ArrayList<>();
        orderedProducts.add(p1);
        orderedProducts.add(p6);
        shopService.createNewOrder(orderedProducts);


    }
}
