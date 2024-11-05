/* This is a stub for the Library class */
import java.util.Hashtable;
import java.util.Map;

/**
 * This class extends the class building and manages the lists of books and collections.
 */
public class Library extends Building {
    private Hashtable<String, Boolean> collection;
    private boolean hasELevator;
    /**
     * Construct with provided name, address, floors number.
     *
     * @param name Name of the house
     * @param address Address of the house
     * @param nFloors FLoors number in the house
     * @param hasElevator Whether library has elevator
     */
    public Library(String name, String address, int nFloors, boolean hasElevator) {
        super(name, address, nFloors);
        this.collection = new Hashtable<>();
        this.hasELevator = hasElevator;
    }

    /**
     * The title of the books are added to the collection list.
     *
     * @param title Title of the added book.
     */
    public void addTitle(String title){
        collection.put(title,true);
    }
 
    /**
     * The title of the books are removed from the collection list.
     *
     * @param title Title of the removed books.
     * @return Title of the removed books.
     */  
    public String removeTitle(String title){
        collection.remove(title);
        return title;
    }

    /**
     * The title of the books that are borrowed out are changed to false at the key. And print the title is not found if the books are not found in the collection.
     *
     * @param title Title of the book that is borrowed.
     */  
    public void checkOut(String title){
        if(collection.containsKey(title)){
            collection.put(title,false);
        } else{
             System.out.println("Title is not found in the collection.");
        }
    }

    /**
     * The title of the books are changed to true for the key in the collection. If the title is not in collection, it will print the title is not in the collection.
     *
     * @param title Title of the returned books.
     */  
    public void returnBook(String title){
        if(collection.containsKey(title)){
            collection.put(title,true);
        } else{
            System.out.println("Title is not found in the collection.");
        }
    }
    
    /**
     * The title of the book is checked whether it is in the collection.
     *
     * @param title Title of the books that are going to be checked whether they are in the collection.
     * @return return true if the collection contains the titles, return false if the collection did not contain the titles.
     */  
    public boolean containsTitle(String title){
        return collection.containsKey(title);
    }

    /**
     * The title of the books are removed from the collection list.
     *
     * @param title Title of the removed books.
     * @return True if the book is they are available, False if the collection is not available or not existing in the collection.
     */  
    public boolean isAvailable(String title){
        return collection.getOrDefault(title,false);
    }

    /**
     * Print the books in the collection and their status.
     */  
    public void printCollection(){
        System.out.println("Library Collection");
        for(Map.Entry<String, Boolean> entry:collection.entrySet()){
            String status = entry.getValue()?"Available":"Checked out";
            System.out.println(entry.getKey()+"-"+status);
        }
    }

    public void showOptions() {
        super.showOptions();
        System.out.println("Available options at " + this.name + ":\n + checkOut \n + printCollection \n + isAvailable \n + containsTitle \n + addTitle \n + removeTitle");
    }

    public void goToFloor(int floorNum) {
        if (this.activeFloor == -1) {
            throw new RuntimeException("You are not inside this Library. Must call enter() before navigating between floors.");
        }
        if (!hasELevator && Math.abs(floorNum - this.activeFloor) > 1) {
            throw new RuntimeException("Unable to move directly to non-adjacent floor. Library does not have an elevator.");
        }
        System.out.println("Moving to floor #" + floorNum + " of " + this.name);
        this.activeFloor = floorNum;
    }
    /**
     * Main method to show the functionality of the Library class.
     */
    public static void main(String[] args) {
        System.out.println("You have built a library: 📖");
        Library library = new Library("Yvonne" , "8 Neilson way",1,true);
        library.addTitle("To Kill a Mocking Bird");
        library.addTitle("Frankly in Love");
        library.checkOut("Frankly in Love");
        library.printCollection();
        library.returnBook("Frankly in Love");
        System.out.println(library.isAvailable("Gone with the wind"));


    }
  
  }
