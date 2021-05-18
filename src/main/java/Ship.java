import java.util.ArrayList;
import java.util.List;

public class Ship {

    private ShipType type;
    private List<Coordinate> shipCoords = new ArrayList<>();
    private int lives;
    private boolean isSunk = false;

    public Ship(ShipType type) {
        this.type = type;
        lives = type.getShipSize();
    }

    public ShipType getType() {
        return type;
    }

    public List<Coordinate> getShipCoords() {
        return shipCoords;
    }

    public boolean addCoordinate(Coordinate coordinate) {
        if (shipCoords.size() < type.getShipSize()) {
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

    public int getShipLives() {
        return lives;
    }
}
