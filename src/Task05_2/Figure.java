package Task05_2;

class Figure {

    static int n;
    //define two states
    public static final boolean STAR_PRINTED = true;
    public static final boolean SPACE_PRINTED = false;
    //define a flag
    boolean flag = STAR_PRINTED;

    //synchronized: The method (common resource) will block other threads when it is called by a thread
    synchronized void printStar(int n) {
        if (flag != SPACE_PRINTED) {
            try {
                //wait() tells the calling thread to give up the monitor 
                //and go to sleep until some other thread calls notify( )
                wait();
            } catch (InterruptedException e) {
                System.out.println("InterruptedException caught");
            }
        }
        for (int i = 0; i < (2 * n - 1); i++) {
            System.out.print("*");
        }
        flag = STAR_PRINTED;
        this.n = n;
        System.out.println();
        //wakes up the first thread that called wait() on the same object.
        notify();
    }

    synchronized int printSpace() {
        if (flag != STAR_PRINTED) {
            try {
                wait();

            } catch (InterruptedException e) {
                System.out.println("InterruptedException caught");
            }
        }
        for (int i = 0; i < (9 - n); i++) {
            System.out.print(" ");
        }
        flag = SPACE_PRINTED;
        notify();
        return n;
    }

}
