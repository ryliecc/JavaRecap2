import java.util.List;
import java.util.Random;

public class ShopService extends ProductRepo{
    public void createNewOrder(List<Product> orderedProducts) {
        // generate random orderId
        StringBuilder orderId = new StringBuilder("OR");
        Random rand = new Random();
        int random = rand.nextInt(999999999);
        orderId.append(random);
        String newOrderId = orderId.toString();

        //check if products are available
        int amountProducts = orderedProducts.size();
        for (Product current : orderedProducts) {
            if (findProduct(current.productId()) == null) {
                System.out.println("The product " + current.name() + " is not available.");
            }
        }

        // create new Order
        Order newOrder = new Order(newOrderId, orderedProducts);
    }
}
