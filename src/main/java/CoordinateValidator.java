import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CoordinateValidator {

    private CoordinateValidator() {
    }

    public static boolean isTheSameLetter(List<Coordinate> coords) {
        Set<String> letters = new HashSet<>();
        for (Coordinate coordinate : coords) {
            letters.add(coordinate.getX());
        }
        return letters.size() == 1;
    }

    public static boolean isTheSameNumber(List<Coordinate> coords) {
        Set<String> numbers = new HashSet<>();
        for (Coordinate coordinate : coords) {
            numbers.add(coordinate.getY());
        }
        return numbers.size() == 1;
    }

    public static boolean areCorrectNumbersInCoords(List<Coordinate> coords) {
        int previousNumberInCoordinate = Integer.parseInt(coords.get(0).getY());

        for (int i = 1; i < coords.size(); i++) {
            if (Integer.parseInt(coords.get(i).getY()) != previousNumberInCoordinate + 1) {
                return false;
            }
            previousNumberInCoordinate = Integer.parseInt(coords.get(i).getY());
        }
        return true;
    }


    public static boolean areCorrectLettersInCoords(List<Coordinate> coords) {
        final String LETTERS = "ABCDEFGHIJ";
        int indexOfFirstLetter = LETTERS.indexOf(coords.get(0).getX());

        for (int i = 1; i < coords.size(); i++) {
            if (indexOfFirstLetter + 1 != LETTERS.indexOf(coords.get(i).getX())) {
                return false;
            }
            indexOfFirstLetter = LETTERS.indexOf(coords.get(i).getX());
        }
        return true;
    }

    public static boolean areCoordsCorrect(ShipType type, List<Coordinate> coords) {
        if (type.getShipSize() > 1) {
            if (!CoordinateValidator.isTheSameLetter(coords) && !CoordinateValidator.isTheSameNumber(coords)) return false;
            if (CoordinateValidator.isTheSameLetter(coords)) return CoordinateValidator.areCorrectNumbersInCoords(coords);
            if (CoordinateValidator.isTheSameNumber(coords)) return CoordinateValidator.areCorrectLettersInCoords(coords);
        }
        return true;
    }

    public static boolean doesShipHaveOccupiedCoords(List<Ship> ships, Ship ship) {
        for (Ship shipFromList : ships) {
            for (Coordinate coordinate : shipFromList.getCoords()) {
                return ship
                        .getCoords()
                        .stream()
                        .anyMatch(coord -> coord.getCoordinate().equals(coordinate.getCoordinate()));
            }
        }
        return false;
    }
}
