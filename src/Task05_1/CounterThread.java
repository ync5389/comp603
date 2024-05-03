package Task05_1;

/**
 * First way to create a Thread - extends Thread
 *
 */
public class CounterThread extends Thread {

    public int num;

    public static void main(String[] args) {
        Thread oddThread = new CounterThread(1);
        Thread evenThread = new CounterThread(2);
        oddThread.start();
        evenThread.start();
    }

    public CounterThread(int i) {
        this.num = i;
    }

    @Override
    public void run() {
        for (int j = this.num; j <= 10; j += 2) {
            System.out.print(j + " ");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.err.println(e);
            }
        }
    }
}
