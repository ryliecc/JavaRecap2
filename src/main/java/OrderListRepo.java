import java.util.Map;

public class OrderListRepo {
    public Map<String, Order> allOrders;

    public void addOrder(Order order){
        allOrders.put(order.orderId(), order);
    }
    public void deleteOrder(String orderId){
        allOrders.remove(orderId);
    }
    public Order findOrder(String orderId){
        return allOrders.get(orderId);
    }
}
