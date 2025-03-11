package module8;

// Class which tests the animal and vehicle classes
// and their implementations of interfaces by calling 
// their methods while storing both types of class
// in an array

public class Manipulater {

    // Program entry point
    public static void main(String[] args) {
        // Create an array of animals and vehicles
        // and store them in the array
        Object[] objects = new Object[4];
        objects[0] = new Animal("Dog");
        objects[1] = new Vehicle("Car", 4);
        objects[2] = new Animal("Cat");
        objects[3] = new Vehicle("Bike", 2);

        // Loop through the array and call the methods
        // on the casted objects
        for (Object object : objects) {
            if (object instanceof Animal) {
                Animal animal = (Animal) object;
                animal.drawObject();
                animal.rotateObject();
                animal.resizeObject();
                animal.playSound();
            } else if (object instanceof Vehicle) {
                Vehicle vehicle = (Vehicle) object;
                vehicle.drawObject();
                vehicle.rotateObject();
                vehicle.resizeObject();
                vehicle.playSound();
            }
        }
    } // end main
    
} // end class Manipulater
