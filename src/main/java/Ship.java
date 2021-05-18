import java.util.ArrayList;
import java.util.List;

public class Ship {

    private ShipType shipType;
    private List<Coordinate> shipCoords = new ArrayList<>();
    private boolean isSunk = false;

    public Ship(ShipType shipType) {
        this.shipType = shipType;
    }

    public ShipType getShipType() {
        return shipType;
    }

    public List<Coordinate> getShipCoords() {
        return shipCoords;
    }

    public boolean addCoordinate(Coordinate coordinate) {
        if (shipCoords.size() < shipType.getShipSize()) {
            shipCoords.add(coordinate);
            return true;
        }
        return false;
    }

    public boolean isSunk() {
        return isSunk;
    }

    public void setSunk(boolean sunk) {
        isSunk = sunk;
    }

    public int getShipSize() {
        return shipType.getShipSize();
    }
}
