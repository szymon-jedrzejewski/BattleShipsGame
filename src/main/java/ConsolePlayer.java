import java.util.Scanner;

public class ConsolePlayer extends Player{

    boolean createShip(ShipType type) {
        Scanner sc = new Scanner(System.in);
        Ship ship = new Ship(type);
        for (int i = 0; i < type.getShipSize(); i++) {
            boolean isOk = ship.addCoordinate(new Coordinate(sc.next(), sc.next()));
            if (!isOk) {
                return false;
            }
        }

        if (!CoordinateValidator.doesShipHaveOccupiedCoords(getShips(), ship)) {
            addShip(ship);
            return true;
        }

        return false;
    }
}
