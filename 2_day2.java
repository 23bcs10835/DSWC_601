package day2;
abstract class DeliveryDrone{
    protected String droneId;
    DeliveryDrone(String droneId){
        this.droneId = droneId;
    }
    public abstract void performDelivery();
    public abstract void deliverPackage();
}
interface Airborne {
    void flyToDestination();
    default void requestAirTrafficClearance() {
        System.out.println("Requesting air traffic clearance before takeoff...");
    }
}
interface GroundBased{
    void navigateSidewalks();
}
class Quadcopter extends DeliveryDrone implements Airborne {

    public Quadcopter(String droneId) {
        super(droneId);
    }

    public void flyToDestination() {
        System.out.println("Quadcopter " + droneId +
                           " is flying to the delivery destination.");
    }

    public void performDelivery() {
        deliverPackage();
    }

    public void deliverPackage() {
        requestAirTrafficClearance();
        flyToDestination();
        System.out.println("Quadcopter " + droneId +
                           " delivered the package.");
    }
}
class CityRover extends DeliveryDrone implements GroundBased {

    public CityRover(String droneId) {
        super(droneId);
    }
    public void navigateSidewalks() {
        System.out.println("CityRover " + droneId +
                           " is navigating sidewalks.");
    }
    public void performDelivery() {
        deliverPackage();
    }
    public void deliverPackage() {
        navigateSidewalks();
        System.out.println("CityRover " + droneId +
                           " delivered the package.");
    }
}
class HybridVTOL extends DeliveryDrone
        implements Airborne, GroundBased {

    public HybridVTOL(String droneId) {
        super(droneId);
    }
    public void flyToDestination() {
        System.out.println("HybridVTOL " + droneId +
                           " is flying to its destination.");
    }
    public void navigateSidewalks() {
        System.out.println("HybridVTOL " + droneId +
                           " is navigating on the ground.");
    }
    public void performDelivery() {
        deliverPackage();
    }
    public void deliverPackage() {
        requestAirTrafficClearance();
        flyToDestination();
        navigateSidewalks();
        System.out.println("HybridVTOL " + droneId +
                           " delivered the package.");
    }
}
class Day2 {
    public static void main(String[] args) {

        DeliveryDrone quadcopter = new Quadcopter("QC-101");
        DeliveryDrone cityRover = new CityRover("CR-202");
        DeliveryDrone hybrid = new HybridVTOL("HV-303");

        quadcopter.deliverPackage();
        System.out.println();

        cityRover.deliverPackage();
        System.out.println();

        hybrid.deliverPackage();
    }
}
