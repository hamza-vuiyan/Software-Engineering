abstract class Colours {

    int red, green, blue;
    abstract void makeYourOwnColour(int red, int green, int blue);

    void red() {
        System.out.println("Red painted...");
    }
    void blue() {
        System.out.println("Blue painted...");
    }
}

class Painter extends Colours {
    void makeYourOwnColour(int red, int green, int blue) {
        this.red = red;
        this.green = green;
        this.blue = blue;
        System.out.println("New colour painted with red: " + red + ", green: " + green + ", blue: " + blue);
    }

}


public class TestAbstraction {
    public static void main(String[] args) {
        Painter p = new Painter();
        p.red();
        p.blue();
        p.makeYourOwnColour(100, 150, 200);

    }
}
