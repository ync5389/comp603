package Task05_1;

public class Counter {

    int num;

    public static void main(String[] args) {
        Counter count = new Counter(1);
        count.printNum();
    }

    public Counter(int i) {
        this.num = i;
    }

    public void printNum() {
        for (int j = this.num; j <= 10; j += 2) {
            System.out.print(j + " ");
        }

    }

}
