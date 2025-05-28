
package com.hamza;
import hamza.mainModule.CustomException;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String departmentName;
        int age;
        System.out.println("Enter your age:");
        age = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter department name:");
        departmentName = sc.nextLine();

        try {
            if(age >= 18 && departmentName.equals("ict")){
                System.out.println("You are ok to marry.");
            }
            else {
                throw new CustomException("Exception: You are not eligible to marry.");
            }
        }catch (CustomException e) {
            System.out.println(e.getMessage());
        }
    }
}
