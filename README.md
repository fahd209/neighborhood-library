# neighborhood-library
## Over view of the project
I am making a project for my neighbor hood library and the library should allow the customer to check out a book and also check in. The checked out book will keep track of the person's name. When ever the person checks in the book he will not be tracked in the system anymore. 

I created a book class to allow me to make an array of objects from books
![classes](images/Classes.png)

## Screens
### Home screen 
The home screen is going to prompt the user to show available books, Show checked out books, and Exit if the user clicks exit it will stop the program. if a user enters 1 it will take them to the Show available books screen. If a user enter's 2 it will display the checked out screen.


![HomeScreen](images/homeScreen.png)

Code for Home Screen
```java
public static void homeScreen(Book[] books){

        int choice = 0;

            // displaying home screen
            System.out.println();
            System.out.println("Home Screen");
            System.out.println("-----------");
            System.out.println("1. Show available Books");
            System.out.println("2. Show checked out books");
            System.out.println("3. Exit ");
            System.out.println("Enter your choice in numbers: ");
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
```
### Availablty screen

In the availablty screen it will display all the available books and the user will be prompt to check out a book if they enter 1 or exit back to the home screen if they click 2.

![AvailaltyScreen](images/availbltyScreen.png)

