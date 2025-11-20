package cinema;

import java.util.Scanner;

public class Cinema {

    public static void main(String[] args) {
        Menu menu = new Menu();
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of rows:");
        int rows = sc.nextInt();

        System.out.println("Enter the number of seats in each row:");
        int seats = sc.nextInt();
        Cine cinema = new Cine(rows,seats);
        menu.startMenu(cinema);
    }
}