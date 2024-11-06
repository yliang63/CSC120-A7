import java.util.ArrayList;

public class CampusMap {

    ArrayList<Building> buildings;

    /* Default constructor, initializes empty ArrayList */
    public CampusMap() {
        buildings = new ArrayList<Building>();
    }

    /**
     * Adds a Building to the map
     * @param b the Building to add
     */
    public void addBuilding(Building b) {
        System.out.println("Adding building...");
        buildings.add(b);
        System.out.println("-->Successfully added " + b.getName() + " to the map.");
    }

    /**
     * Removes a Building from the map
     * @param b the Building to remove
     * @return the removed Building
     */
    public Building removeBuilding(Building b) {
        System.out.println("Removing building...");
        buildings.remove(b);
        System.out.println("-->Successfully removed " + b.getName() + " to the map.");
        return b;
    }

    /**
     * Output a string that shows the campus map and the building.
     * 
     * @return A string with the directory of the building around campus.
     */
    public String toString() {
        String mapString = "DIRECTORY of BUILDINGS";

        for (int i = 0; i < this.buildings.size(); i ++) {
            mapString += "\n  " + (i+1) + ". "+ this.buildings.get(i).getName() + " (" + this.buildings.get(i).getAddress() + ")";
        }
        return mapString;
    }

    /**
     * Main method shows the functionality of the Building class.
     * 
     * @param args
     */
    public static void main(String[] args) {
        CampusMap myMap = new CampusMap();
        myMap.addBuilding(new Building("Ford Hall", "100 Green Street Northampton, MA 01063", 4));
        myMap.addBuilding(new Building("Bass Hall", "4 Tyler Court Northampton, MA 01063", 4));
        myMap.addBuilding(new Cafe("Center Campus Cafe", "123 Main St Northampton, MA 01063", 1));
        myMap.addBuilding(new Building("Center Campus", "100 Elm St Northampton, MA 01063", 4));
        myMap.addBuilding(new House("Cutter House", "1 Henshaw Ave Northampton, MA 01063", 3, true,true));
        myMap.addBuilding(new Library("Neilson Library", "7 Neilson Drive Northampton, MA 01063", 4, true));
        myMap.addBuilding(new Library("Alumnae Gym", "83 Green St Northampton, MA 01063", 4, true));
        myMap.addBuilding(new House("Ziskind House", "1 Henshaw Ave Northampton, MA 01063", 3, true,true));
        myMap.addBuilding(new House("Chapin House", "3 CHapin Way Northampton, MA 01063", 4, true,true));
        myMap.addBuilding(new House("Gillett House", "47 Elm St Northampton, MA 01063", 4, true,true));
        System.out.println(myMap);
    }
    
}
