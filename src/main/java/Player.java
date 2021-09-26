import java.util.ArrayList;
import java.util.List;

public abstract class Player {
    private List<Ship> ships = new ArrayList<>();
    private List<Coordinate> shots = new ArrayList<>();

    public abstract void initializeShip(ShipType type);

    protected List<Ship> getShips() {
        return ships;
    }

    protected void addShip(Ship ship) {
        ships.add(ship);
    }

    public abstract Coordinate shot();

    protected void addShot(Coordinate coordinate) {
        shots.add(coordinate);
    }

    protected List<Coordinate> getShots() {
        return shots;
    }
}
