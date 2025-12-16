import java.io.*;

public class Inventory {
    private Item[] items;
    private int itemCount;
    private final int MAX_SIZE = 100;

    public Inventory() {
        items = new Item[MAX_SIZE];
        itemCount = 0;
    }

    public boolean addItem(Item newItem) {
        if (itemCount >= MAX_SIZE) {
            return false;
        }

        for (int i = 0; i < itemCount; i++) {
            if (items[i].getName().equalsIgnoreCase(newItem.getName())) {
                return false;
            }
        }

        items[itemCount] = newItem;
        itemCount++;
        return true;
    }

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

    public int getTotalQuantity() {
        int total = 0;
        for (int i = 0; i < itemCount; i++){
            total += items[i].getQuantity();
        }
        return total;
    }

    public int getItemCount() {
        return itemCount;
    }

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

    public Item searchItem(String name) {
        for (int i = 0; i < itemCount; i++) {
            if (items[i].getName().equalsIgnoreCase(name)) {
                return items[i];
            }
        }
        return null;
    }
    
}
