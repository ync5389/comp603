/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Task01_2;
import java.util.Scanner;
/**
 *
 * @author ync5389
 */
public class ShapeCalculator2 {
 
   
       
       
    public static void main(String[] args) {
        
         Scanner input = new Scanner(System.in);



         while (true) {
            System.out.println("\n\nPlease select:\n(1)Rectangle\n(2)Circle\n(3)Square");
            if (input.hasNextInt()) {
                int test = input.nextInt();
           
         
            switch (test) {
            case 1:

                double xxx = input.nextDouble();
                double yyy = input.nextDouble();
                Rectangle out = new Rectangle(xxx, yyy);
                out.printInfo();
                break;
            case 2:
                double c = input.nextDouble();
                Circle cout = new Circle(c);
                cout.printInfo();
                break;
            case 3:
                double s = input.nextDouble();
                Square sout = new Square(s);
                sout.printInfo();
                break;
                
            }

        } else {
            System.out.println("Invalid input!");
            break;
        }
    }
            
            input.close();
    }
}
