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
        Inventory inventory = new Inventory();

        

        while (ActiveProgram) {
            //We will display the UI to the user so they know what different options they have
            System.out.println();

            System.out.println("Inventory Menu:");

            System.out.println("1. Add new item");

            System.out.println("2. Remove item");

            System.out.println("3. Display all items");

            System.out.println("4. Search for an item");

            System.out.println("5. See statistics");

            System.out.println("6. Save inventory to a file");

            System.out.println("7. Exit");

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

                    input.nextLine();

                            
                    //We will display which item was added
                    
                    boolean added = inventory.addItem(new Item(name, category, quantity));
                    if (added) {
                        System.out.println("Item has been added successfully");
                    }
                    else{
                        System.out.println("Item not added. The item may already exist or inventory is full");
                    }
                    break;

                case 2:

                    //This case will remove an item from inventory
                    System.out.print("Enter the name of the item that you want to remove: ");
                    String removeName = input.nextLine();
                    boolean removed = inventory.removeItem(removeName);
                    
                    if (removed) {
                        System.out.println("Item removed successfully");
                    }
                    else {
                        System.out.println("Item not found");
                    }
                    break;

                case 3:

                    // We will display all the items here 

                    System.out.println("Displaying items");
                    inventory.printInventory(); 
                    
                    break;
                
                case 4:

                    System.out.print("Enter the name of whichever item you want to search for: ");
                    String nameSearch = input.nextLine();
                    Item found = inventory.searchItem(nameSearch);

                    if (found != null) {
                        System.out.println("Item found: ");
                        System.out.println(found);
                    }
                    else{
                        System.out.println("Item not found");
                    }
                    break;
                    
                case 5: 

                    //Showing the statistics
                    System.out.println("Total different items: " + inventory.getItemCount());
                    System.out.println("Total quantity of all the items: " + inventory.getTotalQuantity());
                    break;

                case 6:
                    
                    System.out.print("Enter the filename in which you want to save the information: ");
                    String filename = input.nextLine();
                    inventory.saveToFile(filename);
                    break;
                
                case 7: 
                    // This case is if the user decides to exit from the program

                    ActiveProgram = false;
                    System.out.println("Exiting the program");
                    break;
                default:

                    //Outputting this result if user enters an invalid input
                    
                    System.out.println("Invalid choice. Please enter from options 1-7.");
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

