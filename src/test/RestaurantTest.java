package test;

import impl.Order;
import impl.OrderReader;
import impl.Restaurant;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import restaurantInterfaces.IRestaurant;
import static org.hamcrest.MatcherAssert.assertThat;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RestaurantTest {

    private List<Order> orders;

    @BeforeEach
    void setUp() {
        orders = OrderReader.readFile("Orders.csv");
    }



    // HAMCREST 1
    @Test
    public void readFile() throws Exception {
        System.out.println(orders);
        IRestaurant restaurant = new Restaurant(orders);
        assertThat(orders.size(), is(13));
        //orders = restaurant.readFile("Orders.csv");
//        for (Order order : orders) {
//            // System.out.println(order);
//        }
    }

    // HAMCREST 2
    @Test
    public void getWaitingTimeSorted() throws Exception {
        IRestaurant restaurant = new Restaurant(orders);
        //orders = restaurant.readFile("Orders.csv");
        restaurant.getWaitingTimeSorted();
        assertThat(orders.get(0).getWaitingTimeInMinutes(), is(12));
        //.. sout
    }

    @Test
    public void addOrderToList() throws Exception {
        IRestaurant restaurant = new Restaurant(orders);
        int expected = 14;
        //orders = restaurant.readFile("Orders.csv");
        restaurant.addOrderToList(new Order("Lasagna",51));
        int actual = orders.size();
        assertEquals(expected, actual);

    }

    @Test
    public void removeOrderFromList() throws Exception {
        IRestaurant restaurant = new Restaurant(orders);
        int expected = 12;
       // orders = restaurant.readFile("Orders.csv");
        Order o = orders.get(1);
        restaurant.removeOrderFromList(o);
        int actual = orders.size();
        assertEquals(expected, actual);

    }

    @Test
    public void getLongestWaitingTime() throws Exception {
        IRestaurant restaurant = new Restaurant(orders);
       // orders = restaurant.readFile("Orders.csv");
        int expected = 99;
        int actual = restaurant.getLongestWaitingTime().getWaitingTimeInMinutes();
        assertEquals(expected, actual);
    }

    @Test
    public void getLowestWaitingTime() throws Exception {
        IRestaurant restaurant = new Restaurant(orders);
        int expected = 12;
       // orders = restaurant.readFile("Orders.csv");
        int actual = restaurant.getLowestWaitingTime().getWaitingTimeInMinutes();
        assertEquals(expected, actual);
    }

    @Test
    public void countDistinctOrders() throws Exception {
        IRestaurant restaurant = new Restaurant(orders);
       // orders = restaurant.readFile("Orders.csv");
        System.out.println(Arrays.asList(restaurant.countDistinctOrders()));
    }

}