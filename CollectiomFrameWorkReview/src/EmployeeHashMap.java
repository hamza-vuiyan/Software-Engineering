import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class EmployeeHashMap {
    public static void main(String[] args) {
        System.out.println("Enter the number of employees: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        System.out.println("Enter employee ID and Department for " + n + " employees: ");
        HashMap<Integer, String> employeeMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int id = sc.nextInt();
            String department = sc.next();
            employeeMap.put(id, department);
        }

        for(Integer id : employeeMap.keySet()) {
            System.out.println("ID: " + id + "  Dept: " + employeeMap.get(id));
        }

    }
}
