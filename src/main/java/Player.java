import java.util.ArrayList;
import java.util.List;

public class Player {
    List<Ship> ships = new ArrayList<>();

    public Coordinate enterCoordinate(String x, String y) {
        return new Coordinate(x, y);
    }

    public List<Ship> getShips() {
        return ships;
    }

    public void addShip(Ship ship) {
        ships.add(ship);
    }
}
