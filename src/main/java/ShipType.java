public enum ShipType {
    BATTLESHIP(5), DESTROYER(4);

    private final int shipSize;

    ShipType(int shipSize) {
        this.shipSize = shipSize;
    }

    public int getShipSize() {
        return shipSize;
    }
}
