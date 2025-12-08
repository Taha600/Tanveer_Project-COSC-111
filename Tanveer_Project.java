/* This is a program which allows users to keep track of their items
 that they own which will be stored in an inventory.
  The purpose of this program is to allow the user to
   add, remove, view, and search for some specific item

   By Syed Taha Tanveer
   @Fall 2025 - 11/30/25
   Professor Katie Tracy
 */


import java.util.Scanner;

public class Tanveer_Project {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean ActiveProgram = true;

                

        while (ActiveProgram) {
            //We will display the UI to the user so they know what different options they have
            System.out.println();

            System.out.println("Inventory Menu:");

            System.out.println("1. Add new item");

            System.out.println("2. Display all items");

            System.out.println("3. Exit");

            System.out.print("Enter your choice: ");
            int choice = input.nextInt();
            // We go to a new line because of some code issue as if the user picks option 1
            //Then due to some buffering they are unable to enter an item name and the program
            //Directly asks them for a category
            input.nextLine();

            switch (choice) {
                case 1:
                    // This case will add a new item to the system

                    System.out.print("Enter item name: ");
                    String name = input.nextLine();

                    System.out.print("Enter category: ");
                    String category = input.nextLine();

                    System.out.print("Enter quantity: ");
                    int quantity = input.nextInt();

                    

                    //We will display which item was added
              
                    System.out.println("Item added");
                    break;

                case 2:
                    // We will display all the items here 

                    
                    System.out.println("Displaying items");
                    break;

                case 3:

                    // This case is if the user decides to exit from the program
                    ActiveProgram = false;
                    System.out.println("Exiting the program");
                    break;

                default:
                    //Outputting this result if user enters an invalid input
                    System.out.println("Invalid choice. Please enter from options 1-3.");
            }
        }

        input.close();
    }
}

/* Sample Code Output

Inventory Menu:
1. Add new item
2. Display all items
3. Exit
Enter your choice: 1
Enter item name: Sprite
Enter category: drink
Enter quantity: 2
Item added

Inventory Menu:
1. Add new item
2. Display all items
3. Exit
Enter your choice: 2
Displaying items

Inventory Menu:
1. Add new item
2. Display all items
3. Exit
Enter your choice: 3
Exiting the program*/

