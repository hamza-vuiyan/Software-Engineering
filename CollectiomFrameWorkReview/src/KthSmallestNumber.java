import java.util.ArrayList;
import java.util.Scanner;

import static java.util.Collections.sort;

public class KthSmallestNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of the array: ");
        int n = sc.nextInt();
        ArrayList<Integer> list = new ArrayList<>();
        System.out.println("Enter the elements: ");

        for (int i = 0; i < n; i++) {list.add(sc.nextInt());}
        sort(list);

        System.out.println("Enter the value of k:");
        int k = sc.nextInt();
        if(k < 1 || k > n) {
            System.out.println("input is out of range!");
            return;
        }
        System.out.println("Smallest number at position k: " + list.get(k - 1));
    }
}
