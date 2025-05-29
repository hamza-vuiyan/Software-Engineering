package Application.Shapes;

import Application.InterFaces.Drawable;

public class Square implements Drawable {
    int height, width;

    public Square(int height, int width) {
        this.height = height;
        this.width = width;
    }

    public void draw() {
        System.out.println("Drawing Square...");
    }

    public void info() {
        System.out.println("Square drawn with height = " + this.height + ", width = " + this.width);
    }
}
