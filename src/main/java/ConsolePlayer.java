import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsolePlayer extends Player{

    public void initializeShip(ShipType type) {
        Ship ship = new Ship(type);
        for (int i = 0; i < type.getShipSize(); i++) {
            ship.addCoordinate(initializeCoordinate(type, ship));
        }

        if (!CoordinateValidator.doesShipHaveOccupiedCoords(getShips(), ship)) {
            addShip(ship);
        }
    }

    private String playerInput(String message) {
        System.out.print(message);
        return new Scanner(System.in).next().toUpperCase();
    }

    private Coordinate initializeCoordinate(ShipType type, Ship ship) {
        while (true) {
            String letter = playerInput("Please enter letter from A to J: ");
            String number = playerInput("Please enter number from 1 to 10: ");

            if (CoordinateValidator.isLetterValid(letter) && CoordinateValidator.isNumberValid(number)) {

                Coordinate coordinate = new Coordinate(letter, number);
                List<Coordinate> tempCoords = new ArrayList<>(ship.getCoords());
                tempCoords.add(coordinate);
                Ship tempShip = new Ship(type);
                tempShip.setCoords(tempCoords);
                tempShip.sortCoords();

                if (CoordinateValidator.areCoordsCorrect(type, tempShip.getCoords())) {
                    return coordinate;
                }

            }
            System.out.println("\nPlease enter coordinate once again!\n");
        }
    }

}
