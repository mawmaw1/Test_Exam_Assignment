package impl;

import restaurantInterfaces.IRestaurant;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Restaurant implements IRestaurant {
    @Override
    public List<Order> readFile(String filename) throws IOException {
        List<Order> orders = new ArrayList<Order>(); {
        };
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while((line = reader.readLine()) != null ){
                String[] row = line.split(",");
                Order order = new Order(row[0],Integer.parseInt(row[1]));
                orders.add(order);
            }
        }
        return orders;
    }

    @Override
    public List<Order> getWaitingTimeSorted(List<Order> orders)  {
        Collections.sort(orders, Comparator.comparingInt(Order ::getWaitingTimeInMinutes));
        return orders;
    }

    @Override
    public List<Order> addOrderToList(List<Order> orders, Order order) {
        orders.add(order);
        return orders;
    }

    @Override
    public List<Order> removeOrderFromList(List<Order> orders, Order order) {
        orders.remove(order);
        return orders;
    }

    @Override
    public Order getLongestWaitingTime(List<Order> orders) {
        Collections.sort(orders, Comparator.comparingInt(Order ::getWaitingTimeInMinutes));
        return orders.get(orders.size()-1);

    }

    @Override
    public Order getLowestWaitingTime(List<Order> orders) {
        Collections.sort(orders, Comparator.comparingInt(Order ::getWaitingTimeInMinutes));
        return orders.get(0);
    }

    @Override
    public Map<String,Integer> countDistinctOrders(List<Order> orders) {
        Map<String, Integer> dishCount = new HashMap<String, Integer>();
        for(Order o: orders){
            Integer i = dishCount.get(o.getOrder());
            if(i == null){
                i = 0;
            }
            dishCount.put(o.getOrder(), i+1);
        }
        return dishCount;
    }




}
