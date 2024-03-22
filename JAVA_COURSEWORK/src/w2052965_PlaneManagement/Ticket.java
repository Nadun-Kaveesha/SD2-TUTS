package w2052965_PlaneManagement;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Ticket {
    // Attributes
    private char row;
    private int seat;
    private double price;
    private Person person;

    // Constructor
    public Ticket(char row, int seat, double price, Person person) {
        this.row = row;
        this.seat = seat;
        this.price = price;
        this.person = person;
    }

    // Getters and Setters
    public int getRow() {
        return row;
    }

    public void setRow(char row) {
        this.row = row;
    }

    public int getSeat() {
        return seat;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    // Method to print information of a Ticket
    public void printTicketInfo() {
        System.out.println("\n"+"-Ticket Information-");
        System.out.println("Row Letter: " + row);
        System.out.println("Seat Number: " + seat);
        System.out.println("Price: £" + price);
        System.out.println("\n"+"-Person Information-");
        person.printInfo(); // Print person information using the Person object's printInfo() method
    }


    public void saveTicket(String filename) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename + ".txt"))) {
            writer.println("Row: " + (char) (row + 'A'));  
            writer.println("Price: " + price);
            writer.println("Name: " + person.getName());
            writer.println("Surname: " + person.getSurname());
            writer.println("Email: " + person.getEmail());
        } catch (IOException e) {
            System.err.println("Error saving ticket to file: " + e.getMessage());
        }
    }
}
