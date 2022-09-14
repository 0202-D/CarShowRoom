
/**
 * @author Dm.Petrov
 * DATE: 13.09.2022
 */
public class CarShowRoom {

    private int carCounter = 0;
    private int timeToCreateAuto = 3000;

    public synchronized void releaseAuto() {
        try {
            Thread.sleep(timeToCreateAuto);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Toyota release auto");
        carCounter++;
        System.out.println(carCounter + " car in storage");
        notify();
    }

    public synchronized void buyAuto() {
        if (carCounter < 1) {
            System.out.println(Thread.currentThread().getName() + " came to the salon - no cars");
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        carCounter--;
        System.out.println(Thread.currentThread().getName() + " buy auto");
    }

}



