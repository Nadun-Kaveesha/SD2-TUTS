package w2052965_PlaneManagement;
import java.util.*;

/*import w2052965_PlaneManagement.Person;
import w2052965_PlaneManagement.Ticket;*/

public class PlaneManagement {
    private static Ticket[] ticketArray = new Ticket[52];
    private static int ticketArrayIndex = 0;


    public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    // initializing arrays in the main method
    int[][] seats = seatArray();

    // Greeting Line
    System.out.println("\n" + " ".repeat(10) + "WELCOME TO THE PLANE MANAGEMENT APPLICATION");

    // Adding a delay
    try {
        Thread.sleep(1000);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }

    // the main program
    while (true) {
        // Displaying the Menu options
        displayMenuOptions();

        // Prompting for an option to choose
        int opt;
        while (true) {
            System.out.print("\nPlease Select an Option:");
            if (scanner.hasNextInt()) {
                opt = scanner.nextInt();
                if (opt >= 1 && opt <= 6) {
                    // Running the switching options
                    switch (opt) {
                        case 1:
                            System.out.println("\n");
                            buy_seat(seats); // running the buy seat method
                            exitApplicationPrompt(scanner);
                            break;

                        case 2:
                            System.out.println("\n");
                            cancel_seat(seats, ticketArray, ticketArrayIndex); // running the cancel seat method
                            exitApplicationPrompt(scanner);
                            break;

                        case 3:
                            System.out.println("\n");
                            int[] index = find_first_available(seats);// running the seat finder method

                            if (index != null) {
                                char rowChar = (char) ('A' + index[0]);
                                System.out.println("First available seat found at :" + rowChar + (index[1] + 1));
                            } else {
                                System.out.println("No available seat found in the plane.");
                            }
                            exitApplicationPrompt(scanner);
                            break;

                        case 4:
                            System.out.println("\n");
                            show_seating_plan(seats); // running the show seating plan method
                            exitApplicationPrompt(scanner);
                            break;

                        case 5:
                            System.out.println("\n");
                            print_tickets_info();// running the ticket printing method
                            exitApplicationPrompt(scanner);
                            break;

                        case 6:
                            System.out.println("\n");
                            search_ticket(seats);// running the search ticket method
                            exitApplicationPrompt(scanner);
                            break;

                        default:
                            System.out.println("Invalid option. Please select a valid option from the menu.");
                            break;
                    }
                    break; // Exit the while loop if a valid option is selected
                } else {
                    System.out.println("Enter a Valid Selection From the Menu (1-6)!");
                }
            } else {
                String input = scanner.next();
                System.out.println("Invalid input. Please enter a number.");
            }
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

        String userName = null;
        String userSurName = null;

        //collecting the personal Information(Name)      
        System.out.println(" ".repeat(5)+"** Please Provide Information for Booking Purposes **\n");
        while (userName == null) {
            System.out.print("Please Enter Your Name for the Registration: ");
            String name = scanner.next();
            if (name.matches("^[a-zA-Z]+$")) {
                userName = name;
            } else {
                System.out.println("Error: Name must only contain letters.\n");
            }
        }
        
        //collecting the personal Information(Surname)
        while (userSurName == null) {
            System.out.print("Please Enter Your Surname for the Registration: ");
            String surname = scanner.next();
            if (surname.matches("^[a-zA-Z]+$")) {
                userSurName = surname;
            } else {
                System.out.println("Error: Surname must only contain letters.\n");
            }
        }

        //collecting the personal Information(email)
        System.out.print("Please Your Email for the Registration   : ");
        String userEmail=scanner.next();
        System.out.println("Thank you for the information!\n");

        // Displaying the seat arrangement for the user
        show_seating_plan(seats);

        int rowIndex=0;
        int seatNumber=0;

        // Prompting the desired row letters and handle errors
        while (true) {
            try{
                System.out.print("\nPlease Enter the Desired Row Letter You want to Buy : ");
                String userInput = scanner.next().toUpperCase(); 

                if (userInput.equals("A") || userInput.equals("B") || userInput.equals("C") || userInput.equals("D")){
                    rowIndex = userInput.charAt(0) - 'A';
                    break;
                }else{
                    System.out.println("Enter a valid input! (A-D)\n");
                }
            }catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid letter (A-D).\n");
                scanner.next(); 
            }
        }

        // Prompting the desired seat number and handle errors
        while (true) {
            try {
                System.out.print("Please Enter the Desired Seat Number You want to Buy : ");
                seatNumber = scanner.nextInt();
                if (seats[rowIndex].length >= seatNumber && seatNumber >= 1) {
                    break;
                } else {
                    System.out.println("Enter a corresponding seat number (A,D)=14 seats / (B,C)=12 seats\n");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.\n");
                scanner.next();
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

            }//generating an error if seat is already occupied
            System.out.println("\nError: The seat is already booked !");
        } else {
            System.out.println("-Please Wait While Reserving Your Seat-");
            try {
                Thread.sleep(2000); 
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // Booking the seat if seat is valid
            seats[rowIndex][seatNumber - 1] = 1; 
            System.out.println("\nSeat booked successfully !");
            
            
            //Generating the Ticket Information
            Person person = new Person(userName,userSurName,userEmail);
            char rowLetter = (char) ('A' + rowIndex);
            Ticket ticket = new Ticket(rowLetter, seatNumber, price, person);

            //appending  the ticket information to the ticket array
            ticketArray[ticketArrayIndex++] = ticket;
            //Printing the ticket information
            ticket.printTicketInfo();

            // Generate the filename for the ticket
            String filename = "" + (char) ('A' + rowIndex) + seatNumber;

            // Save the ticket information to a file
            ticket.saveTicket(filename);
            
        }
    }


    public static void cancel_seat(int[][] seats, Ticket[] ticketArray, int ticketArrayIndex) {
        Scanner scanner = new Scanner(System.in);
        
        
        int rowIndex=0;
        int seatNumber=0;

        // Prompting the desired row letters and seat numbers to cancel
        while (true) {
            try{
                System.out.print("Please Enter the  Row Letter You want to Cancel : ");
                String userInput = scanner.next().toUpperCase(); 

                if (userInput.equals("A") || userInput.equals("B") || userInput.equals("C") || userInput.equals("D")){
                    rowIndex = userInput.charAt(0) - 'A';
                    break;
                }else{
                    System.out.println("Enter a valid input! (A-D)\n");
                }
            }catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid letter (A-D).\n");
                scanner.next(); 
            }
        }

        // Prompting the desired seat number and handle errors
        while (true) {
            try {
                System.out.print("Please Enter the Seat Number You want to Cancel : ");
                seatNumber = scanner.nextInt();
                if (seats[rowIndex].length >= seatNumber && seatNumber >= 1) {
                    break;
                } else {
                    System.out.println("Enter a corresponding seat number (A,D)=14 seats / (B,C)=12 seats\n");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.\n");
                scanner.next(); 
            }
        }
            
        
        // Check if the seat selection is valid
        if (seats[rowIndex][seatNumber - 1] == 0) {
            System.out.println("Error: This seat is not booked.");
        } else {

            // Mark the seat as cancelled
            seats[rowIndex][seatNumber - 1] = 0; // cancel the seat
            System.out.println("Seat cancelled successfully !!");

            //Removing the seat details form the ticket array
            for (int i = 0; i < ticketArrayIndex; i++) {
                if (ticketArray[i].getRow() == rowIndex + 'A' && ticketArray[i].getSeat() == seatNumber) {
					for (int j = i; j < ticketArray.length-1 ; j++) {
						ticketArray[j] = ticketArray[j + 1];
					}
					ticketArrayIndex--;
					break;
				}
            }
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


    public static void print_tickets_info() {
        System.out.println("Printing Tickets Information:");

        // Initialize total sales variable
        int totalSales = 0;

        // Iterate over the ticketArray and print ticket information
        for (int i = 0; i < ticketArrayIndex+2; i++) {
            if (ticketArray[i] != null) {
                Ticket ticket = ticketArray[i];
                System.out.println("Ticket " + (i + 1) + ": Row :" +  ((char)ticket.getRow()) +
                        " , Seat No. : " + ticket.getSeat() +
                        " , Price £ :" + ticket.getPrice() +
                        " , Passenger :" + ticket.getPerson().getName() +
                        " " + ticket.getPerson().getSurname() +
                        " , Email :" + ticket.getPerson().getEmail()+
                        "\n");

                // Add ticket price to total sales
                totalSales += ticket.getPrice();
            }
        }

        // Print total sales
        System.out.println("Total Sales: £" + totalSales);
    }


    public static void search_ticket(int[][] seats) {
    Scanner scanner = new Scanner(System.in);
    
    // Prompting the desired row letters and seat numbers to search
    int rowIndex = 0;
    int seatNumber = 0;
    while (true) {
        System.out.print("\nPlease Enter the Row Letter You want to Search : ");
        char userInput = scanner.next().toUpperCase().charAt(0); 
        if (userInput >= 'A' && userInput <= 'D') {
            rowIndex = userInput - 'A';
            break;
        } else {
            System.out.println("Enter a valid input! (A-D)");
            continue;
        }
    }
    while (true) {
        System.out.print("Please Enter the Seat Number You want to search : ");
        seatNumber = scanner.nextInt();
        if (seatNumber >= 1 && seatNumber <= 14) {
            break;
        } else {
            System.out.println("Enter a corresponding seat number (A,D)=14 seats / (B,C)=12 seats\n");
        }
    }

    // Check if the seat is booked
    boolean isSeatBooked = seats[rowIndex][seatNumber - 1] == 1;
    if (isSeatBooked) {
        // Find the ticket with the given row and seat
        Ticket foundTicket = null;
        for (Ticket ticket : ticketArray) {
            if (ticket != null && ticket.getRow() == rowIndex + 'A' && ticket.getSeat() == seatNumber) {
                foundTicket = ticket;
                break;
            }
        }

        // Print ticket information
        if (foundTicket != null) {
            System.out.println("\nTicket Information:");
            System.out.println("Row :" + ((char) foundTicket.getRow()));
            System.out.println("Seat No. : " + foundTicket.getSeat());
            System.out.println("Price £ :" + foundTicket.getPrice());
            System.out.println("Passenger :" + foundTicket.getPerson().getName() + " " + foundTicket.getPerson().getSurname());
            System.out.println("Email :" + foundTicket.getPerson().getEmail());
        }
    } else {
        System.out.println("This seat is available.");
    }
}

} 