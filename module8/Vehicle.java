package module8;

// Class which implements multiple interfaces
// Drawable, Rotatable, Resizable, Sounds
// for a Vehicle object

public class Vehicle implements Drawable, Rotatable, Resizable, Sounds {

    // Class Methods

    public Vehicle(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void drawObject() {
        System.out.println("Drawing a vehicle");
    }
    
    public void rotateObject() {
        System.out.println("Rotating a vehicle");
    }
    
    public void resizeObject() {
        System.out.println("Resizing a vehicle");
    }

    public void playSound() {
        System.out.println("Vehicle Sound");
    }
    
    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Class Members
    private int age; 
    private String name; 
} // end class Vehicle
