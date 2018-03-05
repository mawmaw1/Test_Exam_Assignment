package test;

import impl.Order;
import impl.Restaurant;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.Test;
import restaurantInterfaces.IRestaurant;

import java.util.Arrays;
import java.util.List;

public class RestaurantTest {



    private final IRestaurant restaurant = new Restaurant();
    private List<Order> orders;


    // 1
    @Test
    public void readFile() throws Exception {
        orders = restaurant.readFile("Orders.csv");
        for (Order order : orders) {
            // System.out.println(order);
        }
    }


    @Test
    public void getWaitingTimeSorted() throws Exception {
        orders = restaurant.readFile("Orders.csv");
        restaurant.getWaitingTimeSorted(orders);
        //.. sout
    }

    @Test
    public void addOrderToList() throws Exception {
        int expected = 14;
        orders = restaurant.readFile("Orders.csv");
        restaurant.addOrderToList(orders, new Order("Lasagna",51));
        int actual = orders.size();
        assertEquals(expected, actual);

    }

    @Test
    public void removeOrderFromList() throws Exception {
        int expected = 12;
        orders = restaurant.readFile("Orders.csv");
        Order o = orders.get(1);
        restaurant.removeOrderFromList(orders,o);
        int actual = orders.size();
        assertEquals(expected, actual);

    }

    @Test
    public void getLongestWaitingTime() throws Exception {
        orders = restaurant.readFile("Orders.csv");
        int expected = 99;
        int actual = restaurant.getLongestWaitingTime(orders).getWaitingTimeInMinutes();
        assertEquals(expected, actual);
    }

    @Test
    public void getLowestWaitingTime() throws Exception {
        int expected = 12;
        orders = restaurant.readFile("Orders.csv");
        int actual = restaurant.getLowestWaitingTime(orders).getWaitingTimeInMinutes();
        assertEquals(expected, actual);
    }

    @Test
    public void countDistinctOrders() throws Exception {
        orders = restaurant.readFile("Orders.csv");
        System.out.println(Arrays.asList(restaurant.countDistinctOrders(orders)));
    }

}