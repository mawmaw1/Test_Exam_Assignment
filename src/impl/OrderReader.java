package impl;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class OrderReader {

    public static List<Order> readFile(String filename) {
        List<Order> orders = new ArrayList<Order>(); {
        };
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while((line = reader.readLine()) != null ){
                String[] row = line.split(",");
                Order order = new Order(row[0],Integer.parseInt(row[1]));
                orders.add(order);
            }
        } catch (IOException e){
            System.out.println(e.toString());
        }

        return orders;
    }


}
