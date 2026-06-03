class PowerNode {

    byte sectorStates = 0;

    public void turnOnSector(int sectorIndex) {
        sectorStates = (byte)(sectorStates | (1 << sectorIndex));
    }

    public void turnOffSector(int sectorIndex) {
        sectorStates = (byte)(sectorStates & ~(1 << sectorIndex));
    }

    public boolean isSectorOn(int sectorIndex) {
        return (sectorStates & (1 << sectorIndex)) != 0;
    }

    public void displayState() {
        for (int i = 7; i >= 0; i--) {
            System.out.print((sectorStates >> i) & 1);
        }
        System.out.println();
    }
}

class PowerControl {
    public static void main(String[] args) {

        PowerNode node = new PowerNode();

        node.turnOnSector(0);
        node.turnOnSector(3);
        node.turnOnSector(7);

        System.out.print("Current State: ");
        node.displayState();

        System.out.println("Sector 3 ON? "
                + node.isSectorOn(3));

        node.turnOffSector(3);

        System.out.println("Sector 3 ON? "
                + node.isSectorOn(3));

        System.out.print("Current State: ");
        node.displayState();
    }
}