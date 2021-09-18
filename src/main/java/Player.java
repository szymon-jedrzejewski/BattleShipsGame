import java.util.ArrayList;
import java.util.List;

public abstract class Player {
    protected List<Ship> ships = new ArrayList<>();

    abstract boolean createShip(ShipType type);

    protected List<Ship> getShips() {
        return ships;
    }

}
