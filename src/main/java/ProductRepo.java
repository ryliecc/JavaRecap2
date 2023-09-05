import java.util.Map;

public class ProductRepo {
    public Map<String, Product> allProducts;

    public void addProduct(Product product){
        allProducts.put(product.productId(), product);
    }
    public void deleteProduct(String productId){
        allProducts.remove(productId);
    }
    public Product findProduct(String productId){
        return allProducts.get(productId);
    }
}
