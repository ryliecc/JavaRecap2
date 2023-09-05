import java.math.BigDecimal;
import java.util.ArrayList;
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
        List<Product> finalOrderedProducts = new ArrayList<>();
        BigDecimal finalPrice = new BigDecimal("0");
        for (Product current : orderedProducts) {
            Product foundProduct = productRepo.findProduct(current.productId());
            BigDecimal currentPrice = current.price().multiply(BigDecimal.valueOf(current.amount()));
            if (foundProduct == null) {
                System.out.println("The product " + current.name() + " is not available.");
            }else if((foundProduct != null) && (foundProduct.amount() < current.amount())){
                System.out.println("Sorry, the amount of " + current.name() + " you ordered is not available.");
            } else {
                finalOrderedProducts.add(current);
                finalPrice = finalPrice.add(currentPrice);
            }
        }

        // create new Order
        Order newOrder = new Order(newOrderId, finalOrderedProducts, finalPrice);
        orderMapRepo.addOrder(newOrder);
        System.out.println("Your order with the ID " + newOrderId + " has been placed. The total amount to pay is " + finalPrice + "$.");
    }

    public ShopService(ProductRepo productRepo, OrderMapRepo oderMapRepo) {
        this.productRepo = productRepo;
        this.orderMapRepo = oderMapRepo;
    }
}
