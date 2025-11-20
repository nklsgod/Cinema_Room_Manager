package cinema;

public class Cine {
    int currentIncome;
    int totalIncome;
    int purchasedTickets;
    double purchasedTicketsPercentage;
    int rows;
    int seats;
    char[][] cinemaSeats;
    public Cine(int rows , int seats) {
        this.rows = rows;
        this.seats = seats;
        cinemaSeats = new char[rows][seats];
        for (int i = 0; i < cinemaSeats.length; i++) {
            for (int j = 0; j < cinemaSeats[i].length; j++) {
                cinemaSeats[i][j] = 'S';
            }
        }
        if(rows * seats <60){
            totalIncome = (rows*seats) * 10;
        }
        else{
            totalIncome += ((rows/2) *seats) * 10;
            totalIncome += ((rows/2+1) *seats) * 8;
        }
    }
    public void printCinema(){
        System.out.println("Cinema:");
        System.out.print("  ");
        for (int col = 1; col <= cinemaSeats[0].length; col++) {
            System.out.print(col + " ");
        }
        System.out.println();
        for (int row = 0; row < cinemaSeats.length; row++) {
            System.out.print((row + 1) + " ");
            for (int col = 0; col < cinemaSeats[row].length; col++) {
                System.out.print(cinemaSeats[row][col] + " ");
            }
            System.out.println();
        }
    }
    public int buySeat(int choosenRow,int choosenSeat){
        cinemaSeats[choosenRow-1][choosenSeat-1] = 'B';
        int fixedPrice = 0;
        if(choosenRow > rows/2 && rows * seats >60){
            fixedPrice = 8;
        }
        else{
            fixedPrice = 10;
        }
        currentIncome += fixedPrice;
        purchasedTickets +=1;
        double totalSeats = (double) (seats * rows);
        purchasedTicketsPercentage =purchasedTickets / totalSeats * 100;
        return  fixedPrice;
    }

    public boolean isSeatFree(int choosenRow,int choosenSeat){
        return cinemaSeats[choosenRow - 1][choosenSeat - 1] != 'B';
    }
    }
