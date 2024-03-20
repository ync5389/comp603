package Task03_1;




import java.util.Scanner;
import java.util.Random;

public class Program {

    public static void main(String[] args) {
        
        int forth = 0;

        
        while(true){
            Scanner in = new Scanner(System.in);
            double userAnswer;
            Random ran = new Random();
    
            double comAnswer =  0;
            int first =   ran.nextInt(101);
            int second =   ran.nextInt(101);
            int third =   ran.nextInt(4);
            String ope = "_";
            switch (third) {
                case 0:
                    comAnswer = first + second;
                    ope = "+";
                    break;
                case 1:
                    comAnswer = first - second;
                    ope = "-";
                    break;
                case 2:
                    comAnswer = first * second;
                    ope = "*";
                    break;

                case 3:
                    comAnswer = first / second;
                    ope = "/";
                    break;
                default:
                    break;
            } 

            
            try {
                System.out.println(first + ope + second + "=?");
                userAnswer = Double.parseDouble(in.next());

               if(comAnswer == userAnswer){
                    forth += 10;
                    System.out.println("yes, current score:" + forth);
                } else {
                    forth -= 10;
                    System.out.println("no, current score:" + forth);
                }
                System.out.println(first + ope + second + "=" +comAnswer);
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a valid double:");
            }
        }
        
       

    }


}

