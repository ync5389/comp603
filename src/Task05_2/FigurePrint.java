package Task05_2;

public class FigurePrint {

    public static void main(String args[]) {

        Figure fig = new Figure();
        Space sp = new Space(fig);
        Star st = new Star(fig);
        Thread spaceThread = new Thread(sp, "Space");
        spaceThread.start();

        Thread starThread = new Thread(st, "Star");
        starThread.start();
    }

}
