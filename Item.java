/* This is a program which allows users to keep track of their items
 that they own which will be stored in an inventory.
  The purpose of this program is to allow the user to
   add, remove, view, and search for some specific item

   This class represents a singular item in an inventory

   By Syed Taha Tanveer
   @Fall 2025 - 11/30/25
   Professor Katie Tracy
 */


public class Item {

    //Our private variables
    private String name;
    private String category;
    private int quantity;

    //This is our constructor to initialize item
    public Item(String name, String category, int quantity) {
        this.name = name;
        this.category = category;
        this.quantity = quantity;
    }

    //Below we have our getters which return name, category, and quantity
    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public int getQuantity() {
        return quantity;
    }

    //This is our setter which is for our quantity(changes quantity)
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


    //Return a string in order to represent the items
    public String toString() {
        return name + "\nCategory: " + category + "\nQuantity: " + quantity;
    }
}
