import java.util.Scanner;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;


class Order {
    private static int count = 0;
    private final int id;

    public Order() {
        this.id = ++count;
    }

    public int getId() {
        return id;
    }
}

class OrderQueue {
    private final BlockingQueue<Order> queue = new LinkedBlockingQueue<>();

    public void addOrder(Order order) {
        try {
            queue.put(order);
            System.out.println("Order " + order.getId() + " placed.");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public Order takeOrder() {
        try {
            return queue.take(); // waits if queue is empty
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return null;
        }
    }
}

class DeliveryAgent extends Thread {
    private final OrderQueue queue;

    public DeliveryAgent(String name, OrderQueue queue) {
        super(name); // sets thread name like "Agent-1"
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            Order order = queue.takeOrder();
            if (order != null) {
                System.out.println(getName() + " delivering order " + order.getId());
                try {
                    Thread.sleep(2000); // simulate delivery time
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }
}




public class Main {
    public static void main(String[] args) {
        OrderQueue queue = new OrderQueue();

        // Creating 3 delivery agents
        for (int i = 1; i <= 3; i++) {
            new DeliveryAgent("Agent-" + i, queue).start();
        }

        Scanner scanner = new Scanner(System.in);
        int orderCount = 0;

        while (orderCount < 10) {
            System.out.println("Press Enter to place a new order...");
            scanner.nextLine();
            Order order = new Order();
            queue.addOrder(order);
            orderCount++;
        }
        scanner.close();
        return;
    }
}
