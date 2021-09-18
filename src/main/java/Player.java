import java.util.ArrayList;
import java.util.List;

public abstract class Player {
    private List<Ship> ships = new ArrayList<>();

    abstract boolean createShip(ShipType type);

    protected List<Ship> getShips() {
        return ships;
    }

    protected void addShip(Ship ship) {
        ships.add(ship);
    }

}
