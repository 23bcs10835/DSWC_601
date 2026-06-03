abstract class SpaceVessel {
    short shipId;
    boolean isOperational;
    char classification;

    SpaceVessel(short shipId, boolean isOperational, char classification) {
        this.shipId = shipId;
        this.isOperational = isOperational;
        this.classification = classification;
    }
}

class MiningShip extends SpaceVessel {

    float[][] cargoHold;

    MiningShip(short shipId, boolean isOperational,
               char classification, int bays, int containers) {

        super(shipId, isOperational, classification);
        cargoHold = new float[bays][containers];
    }

    public float calculateTotalOreWeight() {
        float total = 0;

        for (int i = 0; i < cargoHold.length; i++) {
            for (int j = 0; j < cargoHold[i].length; j++) {
                total += cargoHold[i][j];
            }
        }

        return total;
    }

    public float findHeaviestContainer() {
        float maxWeight = 0;

        for (int i = 0; i < cargoHold.length; i++) {
            for (int j = 0; j < cargoHold[i].length; j++) {
                if (cargoHold[i][j] > maxWeight) {
                    maxWeight = cargoHold[i][j];
                }
            }
        }

        return maxWeight;
    }
}

class Main {
    public static void main(String[] args) {

        SpaceVessel[] fleet = new SpaceVessel[3];

        fleet[0] = new MiningShip((short)101, true, 'A', 2, 3);
        fleet[1] = new MiningShip((short)102, false, 'B', 2, 2);
        fleet[2] = new MiningShip((short)103, true, 'C', 3, 3);

        MiningShip ship = (MiningShip) fleet[0];

        ship.cargoHold[0][0] = 120.5f;
        ship.cargoHold[0][1] = 300.0f;
        ship.cargoHold[1][2] = 450.75f;

        System.out.println("Total Ore Weight = "
                + ship.calculateTotalOreWeight());

        System.out.println("Heaviest Container = "
                + ship.findHeaviestContainer());
    }
}