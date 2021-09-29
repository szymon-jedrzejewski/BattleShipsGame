import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsolePlayer extends Player {
    private View view;

    public ConsolePlayer(View view) {
        this.view = view;
    }

    public void initializeShip(ShipType type) {
        Ship ship = new Ship(type);
        for (int i = 0; i < type.getShipSize(); i++) {
            ship.addCoordinate(initializeCoordinate(type, ship));
        }

        if (!CoordinateValidator.doesShipHaveOccupiedCoords(getShips(), ship)) {
            this.addShip(ship);
        }
    }

    @Override
    public Coordinate shot() {
        while (true) {
            String letter = playerInput("\nPlease enter letter from A to J: ");
            String number = playerInput("\nPlease enter number from 1 to 10: ");
            if (CoordinateValidator.isLetterValid(letter) && CoordinateValidator.isNumberValid(number)) {
                Coordinate coordinate = new Coordinate(letter, number);
                if (CoordinateValidator.wasCoordinateUsed(getShots(), coordinate)) {
                    this.addShot(coordinate);
                    view.displayMessage("\nPlayer shot: " + coordinate.toString());
                    return coordinate;
                }
                view.displayMessage("\nPlease enter coordinate once again!\n");
            }
        }
    }

    private String playerInput(String message) {
        view.displayMessage(message);
        return new Scanner(System.in).next().toUpperCase();
    }

    private Coordinate initializeCoordinate(ShipType type, Ship ship) {
        while (true) {
            String letter = playerInput("\nPlease enter letter from A to J: ");
            String number = playerInput("\nPlease enter number from 1 to 10: ");

            if (CoordinateValidator.isLetterValid(letter) && CoordinateValidator.isNumberValid(number)) {

                Coordinate coordinate = new Coordinate(letter, number);
                List<Coordinate> tempCoords = new ArrayList<>(ship.getCoords());
                tempCoords.add(coordinate);
                Ship tempShip = new Ship(type);
                tempShip.setCoords(tempCoords);
                tempShip.sortCoords();

                if (CoordinateValidator.areCoordsCorrect(type, tempShip.getCoords())) {
                    view.displayMessage("\nCoordinate created!\n");
                    return coordinate;
                }

            }
            view.displayMessage("\nPlease enter coordinate once again!\n");
        }
    }

}
