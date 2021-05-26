import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Ship {

    private ShipType type;
    private List<Coordinate> coords = new ArrayList<>();
    private int lives;

    public Ship(ShipType type) {
        this.type = type;
        lives = type.getShipSize();
    }

    public ShipType getType() {
        return type;
    }

    public List<Coordinate> getCoords() {
        return coords;
    }

    public boolean addCoordinate(Coordinate coordinate) {
        if (coords.size() < type.getShipSize()) {
            coords.add(coordinate);
            return areCoordsCorrect(coords);
        }
        return false;
    }

    public void updateLives(int lives) {
        this.lives = lives;
    }

    public int getLives() {
        return lives;
    }

    private boolean areCoordsCorrect(List<Coordinate> coords) {
        if (type.getShipSize() > 1) {
            if (!isTheSameLetter(coords) && !isTheSameNumber(coords)) return false;
            if (isTheSameLetter(coords)) return areCorrectNumbersInCoords(coords);
            if (isTheSameNumber(coords)) return areCorrectLettersInCoords(coords);
        }
        return true;
    }

    private boolean isTheSameLetter(List<Coordinate> coords) {
        Set<String> letters = new HashSet<>();
        for (Coordinate coordinate : coords) {
            letters.add(coordinate.getX());
        }
        return letters.size() == 1;
    }

    private boolean isTheSameNumber(List<Coordinate> coords) {
        Set<String> numbers = new HashSet<>();
        for (Coordinate coordinate : coords) {
            numbers.add(coordinate.getY());
        }
        return numbers.size() == 1;
    }

    private boolean areCorrectNumbersInCoords(List<Coordinate> coords) {
        int previousNumberInCoordinate = Integer.parseInt(coords.get(0).getY());

        for (int i = 1; i < coords.size(); i++) {
            if (Integer.parseInt(coords.get(i).getY()) != previousNumberInCoordinate + 1) {
                return false;
            }
            previousNumberInCoordinate = Integer.parseInt(coords.get(i).getY());
        }
        return true;
    }


    private boolean areCorrectLettersInCoords(List<Coordinate> coords) {
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
}
