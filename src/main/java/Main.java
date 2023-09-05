import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        // ALL PRODUCTS
        Product p1 = new Product("PR3675", "iPhone 12", new BigDecimal("799.00"), 10);
        Product p2 = new Product("PR5789", "MacBook Air", new BigDecimal("1199.00"), 10);
        Product p3 = new Product("PR2672", "AirPods Pro", new BigDecimal("299.00"), 10);
        Product p4 = new Product("PR5283", "AppleWatch", new BigDecimal("999.00"), 10);
        Product p5 = new Product("PR4678", "AirTag", new BigDecimal("39.00"), 10);

        // SHOP SERVICE
        ProductRepo productRepo = new ProductRepo();
        productRepo.addProduct(p1);
        productRepo.addProduct(p2);
        productRepo.addProduct(p3);
        productRepo.addProduct(p4);
        productRepo.addProduct(p5);
        OrderMapRepo orderRepo = new OrderMapRepo();
        ShopService shopService = new ShopService(productRepo, orderRepo);

        // NEW ORDER
        Product op1 = new Product("PR531812", "Samsung Galaxy S23", new BigDecimal("669.99"), 1);
        Product op2 = new Product("PR3675", "iPhone 12", new BigDecimal("799.00"), 1);
        Product op3 = new Product("PR5789", "MacBook Air", new BigDecimal("1199.00"), 2);
        Product op4 = new Product("PR5283", "AppleWatch", new BigDecimal("999.00"), 11);
        List<Product> orderedProducts = new ArrayList<>();
        orderedProducts.add(op1);
        orderedProducts.add(op2);
        orderedProducts.add(op3);
        orderedProducts.add(op4);
        shopService.createNewOrder(orderedProducts);


    }
}
