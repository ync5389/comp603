package Task05_1;

/**
 * Second way to create a Thread - implements Runnable interface
 *
 */
public class CounterRunnable implements Runnable {

    public int num;

    public CounterRunnable(int j) {
        this.num = j;
    }

    public static void main(String[] args) {

        CounterRunnable oddTask = new CounterRunnable(1);
        CounterRunnable evenTask = new CounterRunnable(2);
        Thread oddThread = new Thread(oddTask);
        Thread evenThread = new Thread(evenTask);
        oddThread.start();
        evenThread.start();
    }

    @Override
    public void run() {
        for (int i = this.num; i <= 10; i += 2) {
            System.out.print(i + " ");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.err.println(e);
            }
        }
    }
}
