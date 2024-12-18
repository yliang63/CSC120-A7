/**
 * This class represents a cafe that sells coffee.
 */
public class Cafe extends Building {

    private int nCoffeeOunces;
    private int nSugarPackets;
    private int nCreams;
    private int nCups;

    /**
     * Constructs a Cafe object with the provided name, address, number of floors, and initial inventory.
     *
     * @param name Name of the cafe
     * @param address Address of the cafe
     * @param nFloors Number of floors in the cafe
     * @param nCoffeeOunces Quantity of coffee ounces in inventory
     * @param nSugarPackets Quantity of sugar packets in inventory
     * @param nCreams Quantity of cream packets in inventory
     * @param nCups Quantity of cups in inventory
     */
    public Cafe(String name, String address, int nFloors,int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups) {
        super(name, address, nFloors);
        this.nCoffeeOunces = nCoffeeOunces;
        this.nSugarPackets = nSugarPackets;
        this.nCreams = nCreams;
        this.nCups = nCups;
    }
    
    /**
     * Overloaded constructor without number of Coffee , Sugarpackets, creams and cups.
     *
     * @param name Name of the cafe
     * @param address Address of the cafe
     * @param nFloors Number of floors in the cafe
     */
    public Cafe(String name, String address, int nFloors) {
        super(name, address, nFloors);
    }

    /**
     * Sells a coffee with their size of coffee, sugarpackets and creams that it needs.
     *If the stuff needed is available, it will make a coffee. If they are not available, it will restock all the ingredients.
     * @param size size of the coffee in ounces.
     * @param nSugarPackets number of sugarpackets the drink requires.
     * @param nCreams Number of creams the drink requires.
     */
    public void sellCoffee(int size, int nSugarPackets, int nCreams) {
        if (size <= nCoffeeOunces && nSugarPackets <= this.nSugarPackets && nCreams <= this.nCreams && nCups > 0) {
            this.nCoffeeOunces -= size;
            this.nSugarPackets -= nSugarPackets;
            this.nCreams -= nCreams;
            this.nCups--;
            System.out.println("Enjoy your coffee!");
        } else {
            System.out.println("Sorry, we are out of stock for the requested coffee.");
            restock(10, 10, 20, 30); // Restock with default values
        }
    }

    /**
     * Restocked the ingredients when called
     * 
     * @param nCoffeeOunces number of coffee ounces
     * @param nSugarPackets number of sugar packets
     * @param nCreams number of creams
     * @param nCups number of cups
     */
    private void restock(int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups) {
        this.nCoffeeOunces = nCoffeeOunces;
        this.nSugarPackets = nSugarPackets;
        this.nCreams = nCreams;
        this.nCups = nCups;
        System.out.println("Inventory has been restocked.");
    }

    /**
     * Overloaded the parent class method. Print special option for this class.
     */  
    public void showOptions(){
        super.showOptions();
        System.out.println("Available options at " + this.name + ":\n + sellCoffee \n + restock");
    }
    
    /**
     * Overloaded the parent class method. Do not allow user to move to another floor.
     */  
    public void goToFloor(int floorNum) {
        throw new RuntimeException("There is only one floor in Cafe.");
    }
    
    /**
     * Main method to show the functionality of the Cafe class.
     */
    public static void main(String[] args) {
        System.out.println("You have built a cafe: ☕");
        Cafe cafe = new Cafe("Cafe", "123 Main St", 1, 20, 20, 40, 50);
        cafe.sellCoffee(15, 3, 2); 
        cafe.sellCoffee(10, 5, 4);
        cafe.showOptions();
    }
}
