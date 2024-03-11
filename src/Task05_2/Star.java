package Task05_2;

public class Star {

    public static void main(String[] args) {
        int max = 9;
        Star aStar = new Star();
        System.out.println("Figure:");
        aStar.printStar(max);

    }

    private void printStar(int rowNumber) {

        for (int i = 1; i <= rowNumber; i++) {

            //Print spaces
            for (int j = 0; j < (9 - i); j++) {
                System.out.print(" ");
            }

            //Print stars
            for (int j = 0; j < (2 * i - 1); j++) {
                System.out.print("*");
            }
            System.out.println();
        }

    }

}
