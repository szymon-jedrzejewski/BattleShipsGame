import java.util.List;

public class Judge {

    public boolean wasShipHit(Ship ship, Coordinate playerShot) {
        List<Coordinate> coords = ship.getCoords();
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

    private boolean isShipSunk(Ship ship) {
        return ship.getLives() == 0;
    }

    public boolean areAllShipsSunk(List<Ship> ships) {
        int countSinkShips = 0;
        for (Ship ship : ships) {
            if (isShipSunk(ship)) {
                countSinkShips++;
            }
        }
        return countSinkShips == ships.size();
    }
}
