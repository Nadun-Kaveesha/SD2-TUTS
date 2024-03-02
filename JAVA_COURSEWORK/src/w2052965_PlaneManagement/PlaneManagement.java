package w2052965_PlaneManagement;
import java.util.*;
/*import w2052965_PlaneManagement.Person;
import w2052965_PlaneManagement.Ticket;*/

public class PlaneManagement {


    public static void main(String[] args)  {
        Scanner scanner = new Scanner(System.in);

        //Greeting Line
        System.out.println("\n"+" ".repeat(10)+"WELCOME TO THE PLANE MANAGEMENT APPLICATION");

        //Adding a delay
        try {
            Thread.sleep(1000); 
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        int[][] seats = seatArray();


        
        while (true) {
            //Displaying the Menu options
            displayMenuOptions();

            //Prompting for for an option to choose
            System.out.print("\n"+"Please Select an Option :");
            char opt=scanner.next().charAt(0);


            switch (opt) {
                case '1':
                System.out.println("\n");
                buy_seat(seats);//running the buy seat method
                exitApplicationPrompt(scanner);
                    break;
                
                case '2':
                System.out.println("\n");
                cancel_seat(seats);//running the buy seat method
                exitApplicationPrompt(scanner);
                    break;

                case '4':
                System.out.println("\n");
                show_seating_plan(seats);//running the buy seat method
                exitApplicationPrompt(scanner);
                    break;


                case '3':
                System.out.println("\n");
                int[] index = find_first_available(seats);

                if (index != null) {
                    char rowChar = (char) ('A' + index[0]);
                    System.out.println("First available seat found at :"  + rowChar +  (index[1] + 1) );
                } else {
                    System.out.println("No available seat found in the plane.");
                }
                exitApplicationPrompt(scanner);
                    break;

                default:
                    break; 
            } 
        }       
    }


    public static void displayMenuOptions() {
        System.out.println("\n" + "\n" + " ".repeat(10) + "*".repeat(43));
        System.out.println(" ".repeat(21) + "**  Menu Options  **");
        System.out.println(" ".repeat(10) + "*".repeat(43));

        System.out.println("\n" + " ".repeat(13) + "1) Buy a Seat");
        System.out.println("\n" + " ".repeat(13) + "2) Cancel a Seat");
        System.out.println("\n" + " ".repeat(13) + "3) Find First Available Seat");
        System.out.println("\n" + " ".repeat(13) + "4) Show Seating Plan");
        System.out.println("\n" + " ".repeat(13) + "5) Print Tickets Information and Total Sales");
        System.out.println("\n" + " ".repeat(13) + "6) Search Ticket");
        System.out.println("\n" + " ".repeat(13) + "0) Quit");
        System.out.println("\n" + " ".repeat(10) + "*".repeat(43));
    }
        
    

    public static void exitApplicationPrompt(Scanner scanner) {
        System.out.print("\nDo you want to exit from the application (y/n) :");
        String choice = scanner.next();
        if (choice.equalsIgnoreCase("n")) {
            System.out.println("Please wait!");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else if (choice.equalsIgnoreCase("y")) {
            System.out.println("Thank You For Using This Service !");
            System.exit(0);
        }
    }
        
        
    public static int[][] seatArray(){
        //Defining the seat array
        int[][] seats = new int[][]{
            new int[14], // Row A: 14 columns
            new int[12], // Row B: 12 columns
            new int[12], // Row C: 12 columns
            new int[14]  // Row D: 14 columns
        };
        return  seats;
    }
    

    public static void  buy_seat(int[][] seats){
        Scanner scanner = new Scanner(System.in);
        // Displaying the seat arrangement for the user
        show_seating_plan(seats);

        //collecting the personal Information
        System.out.print("\nPlease Your Name for the Registration : ");
        String userName=scanner.next();
        System.out.print("Please Your Surname for the Registration : ");
        String userSurName=scanner.next();
        System.out.print("Please Your Email for the Registration : ");
        String userEmail=scanner.next();

        // Prompting the desired row letters and seat numbers to buy
        int rowIndex=0;
        int seatNumber=0;
        while (true) {
            System.out.print("\nPlease Enter the Desired Row Letter You want to Buy : ");
            char userInput = scanner.next().toUpperCase().charAt(0); 
            if (userInput == 'A' || userInput == 'B' || userInput == 'C' || userInput == 'D'){
                rowIndex = userInput - 'A';
                    break;
            }else{
                System.out.println("Enter a valid input! (A-D)");
                continue;
            }
        }
        while (true) {
            System.out.print("Please Enter the Desired Seat Number You want to Buy : ");
            seatNumber = scanner.nextInt();
            if (1<=seatNumber && 14>=seatNumber
            ) {
                break;
            }else{
                System.out.println("Enter a corresponding seat number (A,D)=14 seats / (B,C)=12 seats\n");
            }  
        }

        //Calculating the price
        int price;
        if (seatNumber<=5) {
            price=200;
        }else if (seatNumber<=9){
            price=150;
        }else{
            price=180;
        }
            
        
        // Check if the seat selection is valid
        if (seats[rowIndex][seatNumber - 1] == 1) {
            System.out.println("-Please Wait While Reserving Your Seat-");
            try {
                Thread.sleep(2000); 
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("\nError: The seat is already booked !");
        } else {
            System.out.println("-Please Wait While Reserving Your Seat-");
            try {
                Thread.sleep(2000); 
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // Booking the seat
            seats[rowIndex][seatNumber - 1] = 1; 
            System.out.println("\nSeat booked successfully !");
            //Printing the Ticket Information
            Person person = new Person(userName,userSurName,userEmail);
            char rowLetter = (char) ('A' + rowIndex);
            Ticket ticket = new Ticket(rowLetter, seatNumber, price, person);
            ticket.printTicketInfo();
        }
    }


    public static void cancel_seat(int[][] seats) {
        Scanner scanner = new Scanner(System.in);
        
        // Prompting the desired row letters and seat numbers to buy
        int rowIndex=0;
        int seatNumber=0;
        while (true) {
            System.out.print("\nPlease Enter the Row Letter You want to Cancel : ");
            char userInput = scanner.next().toUpperCase().charAt(0); 
            if (userInput == 'A' || userInput == 'B' || userInput == 'C' || userInput == 'D'){
                rowIndex = userInput - 'A';
                    break;
            }else{
                System.out.println("Enter a valid input! (A-D)");
                continue;
            }
        }
        while (true) {
            System.out.print("Please Enter the Seat Number You want to cancel : ");
            seatNumber = scanner.nextInt();
            if (1<=seatNumber && 14>=seatNumber) {
                break;
            }else{
                System.out.println("Enter a corresponding seat number (A,D)=14 seats / (B,C)=12 seats\n");
            }  
        }
            
        
        // Check if the seat selection is valid
        if (seats[rowIndex][seatNumber - 1] == 0) {
            System.out.println("Error: This seat is not booked.");
        } else {
            // Mark the seat as booked
            seats[rowIndex][seatNumber - 1] = 0; // Book the seat
            System.out.println("Seat cancelled successfully.");
        }
    }


    public static void show_seating_plan (int[][] seats){
        // Displaying the seat arrangement for the user
        System.out.println(" ".repeat(3) + "This is the Seating Layout:\n");
        for (int row = 0; row < seats.length; row++) {
            char rowName = (char) ('A' + row); // Convert row index to row name
            System.out.print(rowName + ": ");
            for (int col = 0; col < seats[row].length; col++) {
                if (seats[row][col] == 1) {
                    System.out.print("X "); // Display 'X' if seat is booked
                }if (seats[row][col] == 0) {
                    System.out.print("O ");
                } 
            }
            System.out.println(); // Move to the next line for the next row
        }
    }


    public static int[] find_first_available (int[][] seats){
        //searching through the entire array
        for(int i = 0; i< seats.length; i++){
            for(int j = 0; j<seats[i].length; j++){
                if(seats[i][j] == 0){
                    //the first available 0
                    return new int[]{i,j};
                }
            }
        }
        return null;
    }

}