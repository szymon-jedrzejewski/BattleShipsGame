import java.util.List;

public interface Player {
    Coordinate enterCoordinate();
    List<Ship> getShips();
    void createShip(Ship ship);
}
