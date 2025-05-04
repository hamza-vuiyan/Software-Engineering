package Application.Shapes;

import Application.InterFaces.Drawable;
public class Circle implements Drawable {
    int radius;
    public Circle(int radius) {
        this.radius = radius;
    }
    public void draw(){
        System.out.println("Drawing Circle...");
    }
    public void info(){
        System.out.println("Circle drawn with radius = " + this.radius);
    }
}
