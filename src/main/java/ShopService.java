import java.util.List;
import java.util.Random;

public class ShopService{
    ProductRepo productRepo;
    OrderMapRepo orderMapRepo;
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
            if (productRepo.findProduct(current.productId()) == null) {
                System.out.println("The product " + current.name() + " is not available.");
            }
        }

        // create new Order
        Order newOrder = new Order(newOrderId, orderedProducts);
        orderMapRepo.addOrder(newOrder);
        System.out.println("Your order with the ID " + newOrderId + " has been placed.");
    }

    public ShopService(ProductRepo productRepo, OrderMapRepo oderMapRepo) {
        this.productRepo = productRepo;
        this.orderMapRepo = oderMapRepo;
    }
}
