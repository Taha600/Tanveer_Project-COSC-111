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
            if (!input.hasNextInt()){
                System.out.println("Invalid input. Please try to enter a number between 1 & 7");
                // .nextLine() will clear out the invalid input from the user
                input.nextLine();
                continue;
            }
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

                    if (name.isEmpty()) {
                        System.out.println("Item name can't be empty");
                        break;
                    }

                    System.out.print("Enter category: ");
                    String category = input.nextLine();

                    if (category.isEmpty()) {
                        System.out.println("Category can't be empty");
                        break;
                    }

                    System.out.print("Enter quantity: ");

                    if (!input.hasNextInt()) {
                        System.out.println("Quantity should be a positive number");
                        input.nextLine();
                        break;
                    }

                    int quantity = input.nextInt();

                    input.nextLine();

                    if (quantity <= 0) {
                        System.out.println("Quantity must be greater than zero");
                        break;
                    }
                            
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
                    
                    if (removeName.isEmpty()) {
                        System.out.println("Item name can't be empty");
                        break;
                    }

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
                    //This case searches for an item that is given by the user
                    //If the item isn't null then we let the user know that the item was found
                    //Otherwise the item wasn't found
                    System.out.print("Enter the name of whichever item you want to search for: ");
                    String nameSearch = input.nextLine();
                    Item found = inventory.searchItem(nameSearch);

                   if (nameSearch.isEmpty()) {
                        System.out.println("Item name can't be empty");
                        break;
                    } 
                    
                    if (found != null) {
                        System.out.println(" Item found:");
                        System.out.println(found);
                    }
                    else{
                        System.out.println("Item not found");
                    }
                    break;
                    
                case 5: 

                    //Showing the statistics which includes quantitiy and the variety of items
                    System.out.println("Total different items: " + inventory.getItemCount());
                    System.out.println("Total quantity of all the items: " + inventory.getTotalQuantity());
                    break;

                case 6:
                    //We save the current inventory to a file according to the user
                    System.out.print("Enter the filename in which you want to save the information: ");
                    String filename = input.nextLine();

                    if (filename.isEmpty()) {
                        System.out.println("Filename can't be empty");
                        break;
                    }

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

        input.close(); //We close the scanner
    }
}

/* Sample Code Output

Inventory Menu:
1. Add new item
2. Remove item
3. Display all items
4. Search for an item
5. See statistics
6. Save inventory to a file
7. Exit
Enter your choice: 1
Enter item name: Chocolate
Enter category: Snack
Enter quantity: 7
Item has been added successfully

Inventory Menu:
1. Add new item
2. Remove item
3. Display all items
4. Search for an item
5. See statistics
6. Save inventory to a file
7. Exit
Enter your choice: 1
Enter item name: Chips
Enter category: Snack
Enter quantity: 3
Item has been added successfully

Inventory Menu:
1. Add new item
2. Remove item
3. Display all items
4. Search for an item
5. See statistics
6. Save inventory to a file
7. Exit
Enter your choice: 3
Displaying items
Chocolate
Category: Snack
Quantity: 7
Chips
Category: Snack
Quantity: 3

Inventory Menu:
1. Add new item
2. Remove item
3. Display all items
4. Search for an item
5. See statistics
6. Save inventory to a file
7. Exit
Enter your choice: 5
Total different items: 2
Total quantity of all the items: 10

Inventory Menu:
1. Add new item
2. Remove item
3. Display all items
4. Search for an item
5. See statistics
6. Save inventory to a file
7. Exit
Enter your choice: 4
Enter the name of whichever item you want to search for: Chips
Item found: 
Chips
Category: Snack
Quantity: 3

Inventory Menu:
1. Add new item
2. Remove item
3. Display all items
4. Search for an item
5. See statistics
6. Save inventory to a file
7. Exit
Enter your choice: 2
Enter the name of the item that you want to remove: Chocolate
Item removed successfully

Inventory Menu:
1. Add new item
2. Remove item
3. Display all items
4. Search for an item
5. See statistics
6. Save inventory to a file
7. Exit
Enter your choice: 3
Displaying items
Chips
Category: Snack
Quantity: 3

Inventory Menu:
1. Add new item
2. Remove item
3. Display all items
4. Search for an item
5. See statistics
6. Save inventory to a file
7. Exit
Enter your choice: 6
Enter the filename in which you want to save the information: output.txt
Inventory save to output.txt
2. Remove item
3. Display all items
4. Search for an item
5. See statistics
6. Save inventory to a file
7. Exit
Enter your choice: 7
Exiting the program*/

