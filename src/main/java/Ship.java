import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    public void setCoords(List<Coordinate> coords) {
        this.coords = coords;
    }

    public boolean addCoordinate(Coordinate coordinate) {
        coords.add(coordinate);
        return CoordinateValidator.areCoordsCorrect(type, coords);
    }

    public void updateLives(int lives) {
        this.lives = lives;
    }

    public int getLives() {
        return lives;
    }

    public void sortCoords() {
        coords = coords.stream().sorted(new CoordinateComparator()).collect(Collectors.toList());

        List<Coordinate> tempCoords = new ArrayList<>(coords);

        coords.forEach(coordinate -> {
            if (coordinate.getCoordinate().contains("10")) {
                tempCoords.remove(coordinate);
                tempCoords.add(coordinate);
                coords = tempCoords;
            }
        });

    }

    @Override
    public String toString() {
        return "Ship{" +
                "type=" + type +
                ", coords=" + coords.toString() +
                ", lives=" + lives +
                '}';
    }
}
