package Task05_2;

class Star implements Runnable {

    Figure fig;

    //constructor
    Star(Figure figure) {
        this.fig = figure;

    }

    //override
    @Override
    public void run() {
        for (int i = 1; i <= 9; i++) {
            //9 rows
            fig.printStar(i);
        }
    }
}
