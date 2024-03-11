/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Task01_2;

/**
 *
 * @author ync5389
 */
  public class Rectangle extends Shape{
        private double length;
        private double width;
        
       public Rectangle(double le, double we) {
           super("Rectangle");

           this.length = le;
           this.width = we;
           calculateArea();
       }
       
       @Override
       public void calculateArea(){
        if(length == width){
            super.setName("Square");
        }
        this.area = length * width;
       }
    }