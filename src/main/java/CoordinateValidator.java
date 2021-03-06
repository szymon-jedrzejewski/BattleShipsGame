import java.util.*;

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

    //TODO make it configurable in file
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
        if (coords.isEmpty()) {
            return true;
        }

        if (type.getShipSize() > 1) {
            if (!CoordinateValidator.isTheSameLetter(coords) && !CoordinateValidator.isTheSameNumber(coords))
                return false;
            if (CoordinateValidator.isTheSameLetter(coords))
                return CoordinateValidator.areCorrectNumbersInCoords(coords);
            if (CoordinateValidator.isTheSameNumber(coords))
                return CoordinateValidator.areCorrectLettersInCoords(coords);
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

    public static boolean isCoordinateOccupied(List<Ship> ships, Coordinate coordinate) {
        for (Ship ship : ships) {
            return ship
                    .getCoords()
                    .stream()
                    .anyMatch(coord -> coord.getCoordinate().equals(coordinate.getCoordinate()));
        }
        return false;
    }

    //TODO make it configurable in file
    public static boolean isLetterValid(String letter) {
        List<String> letters = new ArrayList<>(Arrays.asList("A", "B", "C", "D", "E", "F", "G", "H", "I", "J"));
        return letters.contains(letter);
    }

    //TODO make it configurable in file
    public static boolean isNumberValid(String number) {
        List<String> numbers = new ArrayList<>(Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9", "10"));
        return numbers.contains(number);
    }

    public static boolean wasCoordinateUsed(List<Coordinate> coords, Coordinate coordinate) {
        return coords
                .stream()
                .noneMatch(coord -> coord.getCoordinate().equals(coordinate.getCoordinate()));
    }
}
