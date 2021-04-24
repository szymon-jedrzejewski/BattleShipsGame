import java.util.List;

public class Judge {

    public boolean wasShipHit(Ship ship, Coordinate playerShot) {
        List<Coordinate> coords = ship.getShipCoords();
        for (Coordinate coordinate : coords) {
            if (coordinate.getCoordinate().equals(playerShot.getCoordinate())) {
                return true;
            }
        }
        return false;
    }
}
