package Application;

import Application.Shapes.Circle;
import Application.Shapes.Square;
import Application.Shapes.Trapezium;


public class Main {
    public static void main(String[] args) {
        Circle c1 = new Circle(5);
        c1.draw();
        c1.info();
        System.out.println();

        Square s1 = new Square(10, 20);
        s1.draw();
        s1.info();
        System.out.println();

        Trapezium t1 = new Trapezium(15);
        System.out.println("Trapezium's immediate parent: " + t1.immediateParent());
    }
}
