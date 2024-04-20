package com.pluralsight;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    static Scanner userInput = new Scanner(System.in);

    public static void main(String[] args) {
        Book[] books = {
                new Book(1, "978-0-12-385003-4", "Book Title 1", false, ""),
                new Book(2, "978-0-13-595705-9", "Book Title 2", false, ""),
                new Book(3, "978-0-672-33537-2", "Book Title 3", false, ""),
                new Book(4, "978-0-12-385003-5", "Book Title 4", false, ""),
                new Book(5, "978-0-13-595705-8", "Book Title 5", false, ""),
                new Book(6, "978-0-672-33537-1", "Book Title 6", false, ""),
                new Book(7, "978-0-12-385003-6", "Book Title 7", false, ""),
                new Book(8, "978-0-13-595705-7", "Book Title 8", false, ""),
                new Book(9, "978-0-672-33537-0", "Book Title 9", false, ""),
                new Book(10, "978-0-12-385003-7", "Book Title 10", false, ""),
                new Book(11, "978-0-13-595705-6", "Book Title 11", false, ""),
                new Book(12, "978-0-672-33537-3", "Book Title 12", false, ""),
                new Book(13, "978-0-12-385003-8", "Book Title 13", false, ""),
                new Book(14, "978-0-13-595705-5", "Book Title 14", false, ""),
                new Book(15, "978-0-672-33537-4", "Book Title 15", false, ""),
                new Book(16, "978-0-12-385003-9", "Book Title 16", false, ""),
                new Book(17, "978-0-13-595705-4", "Book Title 17", false, ""),
                new Book(18, "978-0-672-33537-5", "Book Title 18", false, ""),
                new Book(19, "978-0-12-385003-0", "Book Title 19", false, ""),
                new Book(20, "978-0-13-595705-3", "Book Title 20", false, "")
        };

        //calling homescreen and passing books object
        homeScreen(books);
    }

    public static void homeScreen(Book[] books){

        int choice = 0;

            while(choice != 3) {
                // displaying home screen
                System.out.println();
                System.out.println("Home Screen");
                System.out.println("-----------");
                System.out.println("1. Show available Books");
                System.out.println("2. Show checked out books");
                System.out.println("3. Exit ");
                System.out.print("Enter your choice in numbers: ");
                choice = userInput.nextInt();

                switch (choice) {
                    case 1:
                        // shows available books
                        showAvailableBooks(books);
                        break;
                    case 2:
                        //shows checked out books
                        showCheckedOutBooks(books);
                        break;
                    case 3:
                        System.out.println("Good bye :)");
                        break;
                    default:
                        System.out.println("Invalid input");
                        break;
                }
            }
    }

    public static void showAvailableBooks(Book[] books){

        //displaying Available books
        System.out.println();
        System.out.println("Available Books");
        System.out.println("---------------");
        for(int i = 0; i < books.length; i++){
            if(!books[i].isCheckedOut()){
                System.out.printf("Id: %d, Isbn: %s, Title: %s, Checked out: %b%n ", books[i].getId(), books[i].getIsbn(), books[i].getTitle(), books[i].isCheckedOut());
            }
        }

        // prompting the user to check out a book or exit
        System.out.println();
        System.out.println("1. Check out a book");
        System.out.println("2. Exit to go back to home screen");
        System.out.print("Enter your choice in integers: ");
        int choice = userInput.nextInt();
        userInput.nextLine();

        // checking user's choice and getting name
        String name = "";
        switch (choice){
            case 1:
                System.out.println();
                System.out.print("Please enter your name to check out the book: ");
                name = userInput.nextLine();
                checkOutBooks(books, name);
                break;
            case 2:
                homeScreen(books);
            default:
                System.out.println("Invalid Selection");
        }
    }

    public static void checkOutBooks(Book[] books, String name){
        System.out.println();
        System.out.print("Enter the id of the book you would like to check out: ");
        System.out.println();
        int id = userInput.nextInt();
        for(int i = 0; i < books.length; i++){
            if(id == books[i].getId()){
                books[i].checkOut(name);
            }
        }
        homeScreen(books);
    }

    public static void showCheckedOutBooks(Book[] books){
        System.out.println();
        System.out.println("Checked out books");
        System.out.println("-----------------");
        for (int i = 0; i < books.length; i++){
            if(books[i].isCheckedOut()){
                System.out.println();
                System.out.printf("Id: %d, Isbn: %s, Title: %s, Checked out to: %s \n", books[i].getId(), books[i].getIsbn(), books[i].getTitle(), books[i].getCheckedOutTo());
            }
        }
        
        String choice = "";

        while (!choice.equals("x")){
            System.out.println();
            System.out.println("Enter C to check in a book");
            System.out.println("Enter X to go back to the home screen");
            System.out.print("Input: ");
            choice = userInput.nextLine().toLowerCase();
            switch (choice){
                case "c":
                    checkInBook(books);
                    break;
                case "x":
                    homeScreen(books);
                    break;
            }

        }

    }

    public static void checkInBook(Book[] books){
        System.out.println();
        System.out.println("Enter the id of the book you would like to check in: ");
        int id = userInput.nextInt();
        for (int i = 0; i < books.length; i++){
            if(books[i].getId() == id){
                books[i].checkIn();
            }
        }
    }


    public static boolean checkChoice(int choice){
        String numbers = "0123456789";
        String choiceStr = String.valueOf(choice);

        boolean validInput = false;

        if(numbers.contains(choiceStr)){
            validInput = true;
        } else {
            validInput = false;
        }
        return validInput;
    }

    public static void checkInput(){

    }
}