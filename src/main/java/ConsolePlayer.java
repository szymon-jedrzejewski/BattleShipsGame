import java.util.Scanner;

public class ConsolePlayer extends Player{

    public void initializeShip(ShipType type) {
        Scanner sc = new Scanner(System.in);
        Ship ship = new Ship(type);
        for (int i = 0; i < type.getShipSize(); i++) {
            ship.addCoordinate(new Coordinate(sc.next(), sc.next()));

        }

        if (!CoordinateValidator.doesShipHaveOccupiedCoords(getShips(), ship)) {
            addShip(ship);
        }
    }

    private String playerInput(String message) {
        System.out.println(message);
        return new Scanner(System.in).next();
    }
}
