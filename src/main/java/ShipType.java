public enum ShipType {
    BATTLESHIP(5, 1), DESTROYER(4, 2);

    private final int shipSize;
    private final int allowedNumberOfShip;

    ShipType(int shipSize, int allowedNumberOfShip) {
        this.shipSize = shipSize;
        this.allowedNumberOfShip = allowedNumberOfShip;
    }

    public int getShipSize() {
        return shipSize;
    }

    public int getAllowedNumberOfShips() {
        return allowedNumberOfShip;
    }
}
