
public class Car {
    int noOfWheels;
    String color;
    float maxSpeed;
    float currentFuelInLiter;
    int noOfSeats;

//    public void start()
    public Car start()
    {
        if (currentFuelInLiter == 0)
            System.out.println("Car is out of Fuel can not Start.");
        else if (currentFuelInLiter < 5) {
            System.out.println("Car is in reserved mode. Please refuel.");
            currentFuelInLiter--;
        }
        else
            System.out.println("Car is Started...brum..brum..");

        return this;
    }

    public void drive() {
        System.out.println("Car is driving");
        currentFuelInLiter--;
    }

    public void addFuel(float currentFuelInLiter) {
        this.currentFuelInLiter += currentFuelInLiter;
    }

    public float getCurrentFuelLevel() {
        return currentFuelInLiter;
    }

//    public static void main(String[] args)
//    {
//    }

}
