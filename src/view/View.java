package view;

import java.util.Scanner;

public class View {
    public static int menu() {
        System.out.println("=".repeat(50));
        System.out.println("1. Add new course");
        System.out.println("2. List courses");
        System.out.println("3. Find course by ID");
        System.out.println("4. Find course by title");
        System.out.println("5. Remove course by ID");
        System.out.println("0/99. Exit\n");
        System.out.println("=".repeat(50));
        System.out.print("[+] Insert option: ");
        return new Scanner(System.in).nextInt();
    }
}
