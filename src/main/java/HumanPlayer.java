import java.util.ArrayList;
import java.util.List;

public class HumanPlayer implements Player{
    List<Ship> ships = new ArrayList<>();

    @Override
    public Coordinate enterCoordinate() {
        return null;
    }

    @Override
    public List<Ship> getShips() {
        return ships;
    }

    @Override
    public void createShip(Ship ship) {
        ships.add(ship);
    }
}
