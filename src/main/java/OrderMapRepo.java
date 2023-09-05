import java.util.HashMap;
import java.util.Map;

public class OrderMapRepo implements OrderRepo {
    Map<String, Order> allOrders = new HashMap<>();

    @Override
    public void addOrder(Order order) {
        allOrders.put(order.orderId(), order);
    }

    @Override
    public void deleteOrder(String orderId) {
        allOrders.remove(orderId);
    }

    @Override
    public Order findOrder(String orderId) {
        return allOrders.get(orderId);
    }

}
