package restaurantInterfaces;

import impl.Order;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface IRestaurant {

   // public List<Order> readFile(String filename) throws IOException;
    public List<Order> getWaitingTimeSorted();
    public List<Order> addOrderToList(Order order);
    public List<Order> removeOrderFromList(Order order);
    public Order getLongestWaitingTime();
    public Order getLowestWaitingTime();
    public Map<String,Integer> countDistinctOrders();



}
