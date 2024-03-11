/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Task01_2;

/**
 *
 * @author ync5389
 */

 public class  ShapeCalculator1 {

    
     public static void main(String[] args) {
         Circle cirObj = new Circle(2.5);
         Rectangle recObj = new Rectangle(12, 16.25);
         Square squObj = new Square(3.3);
         
         cirObj.printInfo();
          recObj.printInfo();
           squObj.printInfo();
         
     }
}