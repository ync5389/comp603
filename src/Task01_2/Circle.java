/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Task01_2;

/**
 *
 * @author ync5389
 */
    public class Circle extends Shape{
      private double radius;
      
       public Circle(double re){
           super("Circle");
           this.radius = re;
           calculateArea();
       }
       
       @Override
       public void calculateArea(){
        this.area = Math.PI * Math.pow(radius, 2);
       }
    }