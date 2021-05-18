import java.util.ArrayList;
import java.util.List;

public class Ship {

    private int shipSize;
    private List<Coordinate> shipCoords = new ArrayList<>();
    private boolean isSunk = false;

    public Ship(int shipSize) {
        this.shipSize = shipSize;
    }

    public int getShipSize() {
        return shipSize;
    }

    public List<Coordinate> getShipCoords() {
        return shipCoords;
    }

    public boolean addCoordinate(Coordinate coordinate) {
        if (shipCoords.size() < shipSize) {
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
}
