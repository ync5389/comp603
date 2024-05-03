package Task05_2;

class Space implements Runnable {

    Figure fig;

    //constructor
    Space(Figure fig) {
        this.fig = fig;
    }

    @Override
    public void run() {
        //9 rows
        for (int i = 1; i <= 9; i++) {
            fig.printSpace();
        }
    }
}
