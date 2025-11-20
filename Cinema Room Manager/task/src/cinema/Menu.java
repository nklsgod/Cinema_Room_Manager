package cinema;

import java.util.Scanner;

public class Menu {
    Scanner sc = new Scanner(System.in);
    int selectedOption;
    boolean isExit = false;

    public void startMenu(Cine cinema) {
        while (!isExit) {
            System.out.println("1. Show the seats");
            System.out.println("2. Buy a ticket");
            System.out.println("3. Statistics");
            System.out.println("0. Exit");
            selectedOption = sc.nextInt();
            if(selectedOption == 0){
                isExit =true;
            }
            else if(selectedOption == 1){
                cinema.printCinema();
            }
            else if(selectedOption == 2){
                int selectedRow = enterRow(cinema);
                int selectedSeat = enterSeats(cinema);
                boolean isFree = cinema.isSeatFree(selectedRow,selectedSeat);
                while(!isFree){
                    System.out.println("That ticket has already been purchased!");
                    selectedRow = enterRow(cinema);
                    selectedSeat = enterSeats(cinema);
                    isFree = cinema.isSeatFree(selectedRow,selectedSeat);
                }
                    int price = cinema.buySeat(selectedRow,selectedSeat);
                    System.out.println("Ticket price: $" + price);

                }
            else{
                System.out.println("Number of purchased tickets: " + cinema.purchasedTickets);
                System.out.println("Percentage: " + String.format("%.2f", cinema.purchasedTicketsPercentage) + "%");
                System.out.println("Current income: $" + cinema.currentIncome);
                System.out.println("Total income: $" + cinema.totalIncome);
            }
        }
    }
    public int enterRow(Cine cinema){
        System.out.println("Enter a row number:");
        int selectedRow = sc.nextInt();
        while(selectedRow >cinema.rows || selectedRow < 0){
            System.out.println("Wrong input!");
            System.out.println("Enter a row number:");
            selectedRow = sc.nextInt();
        }
        return selectedRow;
    }
    public int enterSeats(Cine cinema){
        System.out.println("Enter a seat number in that row:");
        int selectedSeat = sc.nextInt();
        while(selectedSeat >cinema.seats || selectedSeat < 0){
            System.out.println("Wrong input!");
            System.out.println("Enter a seat number in that row:");
             selectedSeat = sc.nextInt();
        }
        return  selectedSeat;
    }
}
