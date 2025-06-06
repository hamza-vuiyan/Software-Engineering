package Application.Shapes;

class Polygon {
    int size = 10;
    String signature = "Polygon";

    public Polygon(int x) {
        this.size = x;
    }

    protected String colour = "RED";



}


public class Trapezium extends Polygon {
    public Trapezium(int y) { //using the super class constructor to initialize the child class
        super(y);
    }
    public String immediateParent() {
        return super.signature;
    } //calling the parent class signature

    public void getColour() {
        System.out.println("Colour: " + super.colour);
    }
}

