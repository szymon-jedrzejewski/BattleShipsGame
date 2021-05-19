import java.util.ArrayList;
import java.util.List;

public class Ship {

    private ShipType type;
    private List<Coordinate> shipCoords = new ArrayList<>();
    private int lives;

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

    public void updateLives(int lives) {
        this.lives = lives;
    }

    public int getLives() {
        return lives;
    }
}
