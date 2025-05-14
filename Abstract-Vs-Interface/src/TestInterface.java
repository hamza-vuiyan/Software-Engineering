
interface TeaMaker{
    void bringWater();
    void boilWater();
    void addTeaBag();
    void addSugar();
    void serveTea();
}

class SellsMan implements TeaMaker{

    int sugarAmount;

    public void setSugarAmount(int sugarAmount) {
        this.sugarAmount = sugarAmount;
    }

    public void bringWater() {
        System.out.println("Bringing water...");
    }
    public void boilWater() {
        System.out.println("Boiling water...");
    }
    public void addTeaBag() {
        System.out.println("Adding tea bag...");
    }

    public void addSugar() {
        System.out.println("Added sugar " + this.sugarAmount + " tea spoon");
    }

    public void serveTea() {
        System.out.println("Take your Tea...");
    }
}


public class TestInterface {
    public static void main(String[] args) {
        SellsMan tea = new SellsMan();
        tea.bringWater();
        tea.boilWater();
        tea.addTeaBag();
        tea.setSugarAmount(2);
        tea.addSugar();
        tea.serveTea();
    }
}
