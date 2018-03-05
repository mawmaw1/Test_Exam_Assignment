package impl;

import restaurantInterfaces.IOrder;

import java.util.ArrayList;

public class Order implements IOrder {
    private String order;
    private int waitingTimeInMinutes;

    public Order(String order, int waitingTimeInMinutes) {
        this.order = order;
        this.waitingTimeInMinutes = waitingTimeInMinutes;
    }

    @Override
    public String getOrder() {
        return order;
    }

    @Override
    public int getWaitingTimeInMinutes() {
        return waitingTimeInMinutes;
    }
}
