interface MyInterface {
    void run();
}

abstract class MyAbstract {
    abstract void run();
}
class InterfaceTest implements MyInterface {
    int i = 0;
    public void run() {
       i++;
    }
}
    
class TestAbstract extends MyAbstract {
    int j = 0;
    public void run() {
        j++;
    }
}

public class SpeedTest {
    public static void main(String[] args) {
        MyInterface i = new InterfaceTest();
        MyAbstract a = new TestAbstract();

        long start = System.nanoTime();
        for (int j = 0; j < 1000000; j++) {
            i.run();
        }
        long end = System.nanoTime();
        System.out.println("Interface Time: " + (end - start));

        start = System.nanoTime();
        for (int j = 0; j < 1000000; j++) {
            a.run();
        }
        end = System.nanoTime();
        System.out.println("Abstract Time: " + (end - start));
    }
}

/*
Example OutPut:
Interface Time: 4271966
Abstract Time: 1951091
*/