package restaurantInterfaces;

import impl.Order;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface IRestaurant {

    public List<Order> readFile(String filename) throws IOException;
    public List<Order> getWaitingTimeSorted(List<Order> orders);
    public List<Order> addOrderToList(List<Order> orders, Order order);
    public List<Order> removeOrderFromList(List<Order> orders, Order order);
    public Order getLongestWaitingTime(List<Order> orders);
    public Order getLowestWaitingTime(List<Order> orders);
    public Map<String,Integer> countDistinctOrders(List<Order> orders);



}
