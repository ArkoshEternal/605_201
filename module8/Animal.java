package module8;

// Class which implements multiple interfaces
// Drawable, Rotatable, Resizable, Sounds
// for an Animal object

public class Animal implements Drawable, Rotatable, Resizable, Sounds{

    // Class Methods 

    public Animal(String name) {
        this.name = name;
    }

    public void drawObject() {
        System.out.println("Drawing an Animal");
    }
    
    public void rotateObject() {
        System.out.println("Rotating an Animal");
    }
    
    public void resizeObject() {
        System.out.println("Resizing an Animal");
    }
    
    public void playSound() {
        System.out.println("Animal Sound");
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // Class Members 

    private String name; 

} // end class Animal
