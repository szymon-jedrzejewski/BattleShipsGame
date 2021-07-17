import java.util.ArrayList;
import java.util.List;

public class Ship {

    private ShipType type;
    private List<Coordinate> coords = new ArrayList<>();
    private int lives;

    public Ship(ShipType type) {
        this.type = type;
        lives = type.getShipSize();
    }

    public ShipType getType() {
        return type;
    }

    public List<Coordinate> getCoords() {
        return coords;
    }

    public boolean addCoordinate(Coordinate coordinate) {
        if (coords.size() < type.getShipSize()) {
            coords.add(coordinate);
            return CoordinateValidator.areCoordsCorrect(type, coords);
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
