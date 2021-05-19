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

    public void subtractLife (Ship ship) {
        final int LIFE_TAKEN_FOR_HIT = 1;
        int lives = ship.getLives() - LIFE_TAKEN_FOR_HIT;
        ship.updateLives(lives);
    }

    public boolean isShipSunk(Ship ship) {
        if (ship.getLives() == 0) {
            ship.setSunk(true);
            return true;
        }
        return false;
    }
}
