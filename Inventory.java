/* This is a program which allows users to keep track of their items
 that they own which will be stored in an inventory.
  The purpose of this program is to allow the user to
   add, remove, view, and search for some specific item

   This class handles the collections of item objects

   By Syed Taha Tanveer
   @Fall 2025 - 11/30/25
   Professor Katie Tracy
 */

import java.io.*;

public class Inventory {

    //We create an array variable to store items
    // count variable to keep track of number of items currently in the inventory
    // We also have a constact value which is the max amount of items we will allow to be stores
    private Item[] items;
    private int itemCount;
    private final int MAX_SIZE = 10;


    //This is the constructor which initializes the items in the array and in itemCount
    public Inventory() {
        items = new Item[MAX_SIZE];
        itemCount = 0;
    }


    //This method adds a new item in the inventory
    //It will return false is the inventory is full or if the item already exists
    public boolean addItem(Item newItem) {
        if (itemCount >= MAX_SIZE) {
            return false;
        }

        //This for loop prevents the addition of any duplicate items regardless of the case
        for (int i = 0; i < itemCount; i++) {
            if (items[i].getName().equalsIgnoreCase(newItem.getName())) {
                return false;
            }
        }

        //We add an item to the array
        items[itemCount] = newItem;
        itemCount++;
        return true;
    }

    //This method removes an item by its name
    //The method will return true if the item was removed
    //Successfully, otherwise it will return false
    public boolean removeItem(String name) {
        for (int i = 0; i < itemCount; i++){
            if (items[i].getName().equalsIgnoreCase(name)) {
                for (int j = i; j < itemCount - 1; j++) {
                    items[j] = items[j + 1];
                }
                items[itemCount - 1] = null;
                itemCount--;
                return true;
            }
        }
        return false;
    }

    //This method basically just prints all the items in the inventory
    public void printInventory() {
        if (itemCount == 0) {
            System.out.println("Inventory is empty");
        }
        else {
            for (int i = 0; i < itemCount; i++) {
                System.out.println(items[i]);
            }
        }
    }

    //This method return the total quantity of the all the items
    public int getTotalQuantity() {
        int total = 0;
        for (int i = 0; i < itemCount; i++){
            total += items[i].getQuantity();
        }
        return total;
    }

    //This method returns the number of different items 
    public int getItemCount() {
        return itemCount;
    }

    // This method saves the inventory to a text file according to the user
    public void saveToFile(String filename) {
        try {
            PrintWriter writer = new PrintWriter(filename);
            for (int i = 0; i < itemCount; i++) {
                Item item = items[i];
                writer.println(item.getName() + "," + item.getCategory() + "," + item.getQuantity());

            }
            writer.close();
            System.out.println("Inventory save to " + filename);

        } catch (FileNotFoundException e) {
            System.out.println("Error when saving the inventory: " + e.getMessage());
        }
    }

    //Lastly this method allows us to search for an item
    // By its name, it will return a value if the value is found
    //Otherwise this method will return null
    public Item searchItem(String name) {
        for (int i = 0; i < itemCount; i++) {
            if (items[i].getName().equalsIgnoreCase(name)) {
                return items[i];
            }
        }
        return null;
    }
    
}
