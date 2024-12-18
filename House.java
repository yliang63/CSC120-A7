/* This is a stub for the House class */
import java.util.ArrayList;

/**
 * The class respresents the building class and manages the residents in the house.
 */

public class House extends Building {
    private ArrayList<String> residents;
    private boolean hasDiningRoom;
    private boolean hasELevator;

    /**
     * Construct with provided name, address, floors number and dining hall status.
     *
     * @param name Name of the house
     * @param address Address of the house
     * @para nFloors FLoors number in the house
     * @hasDiningRoom Whether the house has dining room, if it has, it is true, if it has not,  it is false.
     */
    public House(String name, String address, int nFloors, boolean hasDiningRoom) {
        super(name, address, nFloors);
        this.residents = new ArrayList<>();
        this.hasDiningRoom = hasDiningRoom;
    }

    /**
     * Overloaded method. This constructs house with provided name, address, number of floor, dining hall status, and elevator status.
     * 
     * @param name Name of the house 
     * @param address Address of the house
     * @param nFloors Number of the floors
     * @param hasDiningRoom Whether the house has dining hall, if it has, it is true, if it has not, it returns false.
     * @param hasElevator Whether the house has elevators, if it has, return true. If it has not, return false.
     */
    
    public House(String name, String address, int nFloors, boolean hasDiningRoom, boolean hasElevator) {
      super(name, address, nFloors);
      this.residents = new ArrayList<>();
      this.hasDiningRoom = hasDiningRoom;
      this.hasELevator = hasElevator;
    }

   /**
    * Check if the house has dining hall.
    * 
    * @return whether the house has dining Hall.
    */
    public boolean hasDiningRoom(){
        return hasDiningRoom;
    }
  
    /**
     * Returns the number of residents in the house.
     * 
     * @return the number of people living in the house.
     */
    public int nResidents(){
        return residents.size();
    }

    /**
     * Add new the residents to the house.
     * 
     * @param The name of the new resident.
     */
    public void moveIn(String name){
        residents.add(name);
    }



 
    /**
     * Overloaded method. This method allows adding multiple residents to the house at once.
     *
     * @param names Array of names of the new residents to be added.
     */
    public void moveIn(String[] names) {
        for (String name : names) {
            residents.add(name);
        }
    }

    /**
     * Move residents out of the class.
     * 
     * @param The name of the removed resident.
     * @return The name of the removed resident or return null if the residents name is not found.
     */
    public String moveOut(String name){
        if(residents.contains(name)){
            residents.remove(name);
            return name;
        } else{
            return null;
        }
    }  
    
    /**
     * Overloaded the parent class method. Allow user to use the elevator or move around the floor.
     */  
    public void goToFloor(int floorNum) {
        if (this.activeFloor == -1) {
            throw new RuntimeException("You are not inside this Library. Must call enter() before navigating between floors.");
        }
        if(!hasELevator && Math.abs(floorNum - this.activeFloor) > 1) {
            throw new RuntimeException("Unable to move directly to non-adjacent floor. Library does not have an elevator.");
        }
        System.out.println("Moving to floor #" + floorNum + " of " + this.name);
        this.activeFloor = floorNum;
    }
    
    /**
     * Overloaded the parent class method. Print special option for this class.
     */  
    public void showOptions() {
        super.showOptions();
        System.out.println("Available options at " + this.name + ":\n + moveOut \n + moveIn ");
    }

    /**
     * Main method to show the functionality of the House class.
     */
    public static void main(String[] args){
        House myHouse = new House("My House", "Lower Elm Str", 2, true, true);
        System.out.println("You have built a house: 🏠");
        System.out.println("House Name: " + myHouse.getName());
        System.out.println("House Address: " + myHouse.getAddress());
        System.out.println("Number of Floors: " + myHouse.getFloors());
        System.out.println("Has Dining Room: " + myHouse.hasDiningRoom);
  
    }
 
}