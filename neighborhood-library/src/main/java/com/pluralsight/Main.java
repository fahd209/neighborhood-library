package com.pluralsight;

import java.util.Scanner;

public class Main {
    static Scanner userInput = new Scanner(System.in);

    public static void main(String[] args) {
        Book[] books = {
                new Book(1, "978-0-12-385003-4", "The Great Gatsby by F. Scott Fitzgerald", false, ""),
                new Book(2, "978-0-13-595705-9", "To Kill a Mockingbird by Harper Lee", false, ""),
                new Book(3, "978-0-672-33537-2", "1984 by George Orwell", false, ""),
                new Book(4, "978-0-12-385003-5", "Pride and Prejudice by Jane Austen", false, ""),
                new Book(5, "978-0-13-595705-8", "The Catcher in the Rye by J.D. Salinger", false, ""),
                new Book(6, "978-0-672-33537-1", "Harry Potter and the Sorcerer's Stone by J.K. Rowling", false, ""),
                new Book(7, "978-0-12-385003-6", "The Lord of the Rings by J.R.R. Tolkien", false, ""),
                new Book(8, "978-0-13-595705-7", "Animal Farm by George Orwell", false, ""),
                new Book(9, "978-0-672-33537-0", "The Hobbit by J.R.R. Tolkien", false, ""),
                new Book(10, "978-0-12-385003-7", "The Chronicles of Narnia by C.S. Lewis", false, ""),
                new Book(11, "978-0-13-595705-6", "The Hunger Games by Suzanne Collins", false, ""),
                new Book(12, "978-0-672-33537-3", "Catch-22 by Joseph Heller", false, ""),
                new Book(13, "978-0-12-385003-8", "Brave New World by Aldous Huxley", false, ""),
                new Book(14, "978-0-13-595705-5", "The Da Vinci Code by Dan Brown", false, ""),
                new Book(15, "978-0-672-33537-4", "The Alchemist by Paulo Coelho", false, ""),
                new Book(16, "978-0-12-385003-9", "Lord of the Flies by William Golding", false, ""),
                new Book(17, "978-0-13-595705-4", "Moby-Dick by Herman Melville", false, ""),
                new Book(18, "978-0-672-33537-5", "A Tale of Two Cities by Charles Dickens", false, ""),
                new Book(19, "978-0-12-385003-0", "The Grapes of Wrath by John Steinbeck", false, ""),
                new Book(20, "978-0-13-595705-3", "Frankenstein by Mary Shelley", false, ""),
        };

        //calling home screen and passing books object
        homeScreen(books);
    }

    public static void homeScreen(Book[] books){

        String input = "";
        int choice = 0;
            // while choice is not 3 it will not exit the applicaton
            while(choice != 3) {
                // displaying home screen
                System.out.println();
                System.out.println("Home Screen");
                System.out.println("-----------");
                System.out.println("1. Show available Books");
                System.out.println("2. Show checked out books");
                System.out.println("3. Exit ");
                System.out.print("Enter your choice in numbers: ");
                input = userInput.nextLine(); //<== getting input as string then passing it in the check choice method

                choice = checkChoice(input); //<== passing input to the checkChoice method to check if it's a valid input

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
                        // Exits the program
                        System.out.println("Good bye :)");
                        break;
                    default:
                        if (choice > 3){
                            System.out.println("Invalid input");
                        }
                }
            }
    }

    public static void showAvailableBooks(Book[] books){

        //displaying Available books
        boolean foundAvailableBooks = false;
        System.out.println();
        System.out.println("Available Books");
        System.out.println("---------------");

        // looping through the books object and if the books are not checked out then displaying the books that are available
        for(int i = 0; i < books.length; i++){
            if(!books[i].isCheckedOut()){
                System.out.printf("Id: %d, Isbn: %s, Title: %s \n", books[i].getId(), books[i].getIsbn(), books[i].getTitle());
                foundAvailableBooks = true;
            }
        }

        // checking if there was any available books found if not then print "There is no available books"
        if(!foundAvailableBooks){
            System.out.println("There is no available books");
        }

        // prompting the user to check out a book or exit
        System.out.println();
        System.out.println("1. Check out a book");
        System.out.println("2. Exit to go back to home screen");
        System.out.print("Enter your choice in integers: ");
        String input = userInput.nextLine();
        int choice = checkChoice(input);

        // checking user's choice and getting the name
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
                if(choice > 2){
                    System.out.println();
                    System.out.println("Invalid selection");
                }
        }
    }

    // checking out a book with person name and book id
    public static void checkOutBooks(Book[] books, String name){
        System.out.println();
        System.out.print("Enter the id of the book you would like to check out: ");
        System.out.println();
        int id = userInput.nextInt();
        userInput.nextLine();

        // looping through the books object and checking if the id entered is equal to the books id then checking it out with user's name
        for(int i = 0; i < books.length; i++){
            if(id == books[i].getId()){
                books[i].checkOut(name);
            }
        }
        homeScreen(books);
    }

    //showing all the checked out books and who are they checked out to
    public static void showCheckedOutBooks(Book[] books){

        boolean foundCheckedOutBooks = false;
        System.out.println();
        System.out.println("Checked out books");
        System.out.println("-----------------");

        // looping and checking if the books are checked out, if they are then display them
        for (int i = 0; i < books.length; i++){
            if(books[i].isCheckedOut()){
                System.out.println();
                System.out.printf("Id: %d, Isbn: %s, Title: %s, Checked out to: %s \n", books[i].getId(), books[i].getIsbn(), books[i].getTitle(), books[i].getCheckedOutTo());
                foundCheckedOutBooks = true;
            }
        }

        // checking if there is any checked out books found if not then it will print "There is no checked out books"
        if(!foundCheckedOutBooks){
            System.out.println("There is no checked out books");
        }
        
        String choice = "";

        while (!choice.equals("x")){

            //getting user input to check in a book or go back to home screen
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
                default:
                    System.out.println("Invalid input");
                    break;
            }
        }
    }

    public static void checkInBook(Book[] books){

        System.out.println();
        System.out.println("Enter the id of the book you would like to check in: ");
        int id = userInput.nextInt();
        userInput.nextLine();

        for (int i = 0; i < books.length; i++){
            if(books[i].getId() == id){
                books[i].checkIn();
            }
        }
    }

    // checking input
    public static int checkChoice(String input){

        //1. first getting the input as a string
        String numbers = "0123456789";
        int choice = 0;

        //2. checking if string numbers contains the input
        if(numbers.contains(input)){
            // if it does then convert input to an int and store it into choice
            choice = Integer.parseInt(input);
        } else {
            // if it doesn't then print "Invalid input please enter a number"
            System.out.println();
            System.out.println("Invalid input please enter a number");
        }

        //3. returning choice
        return choice;
    }
}