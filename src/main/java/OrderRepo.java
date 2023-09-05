public interface OrderRepo {
    void addOrder(Order order);

    void deleteOrder(String orderId);

    Order findOrder(String orderId);
}
