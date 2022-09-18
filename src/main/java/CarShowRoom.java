import java.util.ArrayList;
import java.util.List;

/**
 * @author Dm.Petrov
 * DATE: 13.09.2022
 */
public class CarShowRoom {
     List<Car>list = new ArrayList<>();
    private int timeToCreateAuto = 3000;
    private int timeToBuy = 2000;
    private int firstCarToSell = 0;
    public  void releaseAuto() {
        try {
            Thread.sleep(timeToCreateAuto);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Toyota release auto");
        list.add(new Car());
        System.out.println(list.size() + " car in storage");
        synchronized (this){
        notify();}
    }

    public synchronized void buyAuto() {
        System.out.println(Thread.currentThread().getName() + " came to the salon");
        while (list.isEmpty()){
            System.out.println( " No cars");
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {
            Thread.sleep(timeToBuy);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        list.remove(firstCarToSell);
        System.out.println(Thread.currentThread().getName() + " buy auto");
    }

}



