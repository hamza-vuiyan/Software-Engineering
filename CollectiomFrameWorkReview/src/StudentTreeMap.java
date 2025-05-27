import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeMap;

class Information {
    public int id;
    public String name;
    public int age;
    public String address;

    public Information(int id, String name, int age, String address) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Age: " + age + ", Address: " + address;
    }

}

public class StudentTreeMap {
    public static void main(String[] args) {
        System.out.println("Enter the number of students: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        ArrayList<Information> studentsList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            System.out.println("Enter student ID, Name, Age, and Address: ");
            int id = sc.nextInt();
            String name = sc.next();
            int age = sc.nextInt();
            String address = sc.next();
            studentsList.add(new Information(id, name, age, address));
        }

        TreeMap<Integer, Information> map = new TreeMap<>();
        for (Information info : studentsList) {
            map.put(info.id, info);
        }

        for(int value : map.keySet()) {
            System.out.println(map.get(value));
        }
    }
}
