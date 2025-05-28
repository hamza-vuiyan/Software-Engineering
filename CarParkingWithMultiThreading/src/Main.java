import java.security.PublicKey;
import java.util.Scanner;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

class Booking{
    private final  int id;
    private static final AtomicInteger count = new AtomicInteger(0);
    public Booking() {
        this.id = count.incrementAndGet();
    }
    public int getId() {
        return id;
    }
}

class CarQueue{
    private final BlockingQueue<Booking> carQueue = new LinkedBlockingQueue<>();

    public void addCars(Booking booking) {
        try{
            carQueue.put(booking);
        }catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public Booking pullCar() {
        try {
            return carQueue.take();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return null;
        }
    }

}

class ParkingGuy extends Thread {
    CarQueue queue;

    public ParkingGuy(String name, CarQueue queue) {
        super(name);
        this.queue = queue;
    }

    @Override
    public void run(){
        while (true){
            Booking book = queue.pullCar();
            if (book != null){
                System.out.println("Parking guy " + getName() + " is parking car with booking ID: " + book.getId());
               try{
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }
}

class Main {
    public static void main(String[] args) {
        CarQueue carQueue = new CarQueue();
        Scanner sc = new Scanner(System.in);

        for (int i = 1; i <= 10; i++) {
            ParkingGuy parkingGuy = new ParkingGuy("ParkingGuy-" + i, carQueue);
            parkingGuy.setDaemon(true);
            parkingGuy.start();
        }

        try{
            while (true){

                System.out.println("Want to add a Car? (y/n)");
                String response = sc.nextLine();

                if (response.equals("y")){
                    Booking booking = new Booking();
                    System.out.println("New car added with booking ID: " + booking.getId());
                    carQueue.addCars(booking);

                    try {
                        Thread.sleep(500); // Simulate time taken to add a car
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }

                } else {
                    System.out.println("Exiting...");
                    break;
                }
            }
        }finally {
            sc.close();
        }

    }
}