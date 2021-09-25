import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class CoordinateValidatorTest {

    @Test
    public void shouldPassIfIsTheSameLetter() {
        List<Coordinate> coords = new ArrayList<>();
        coords.add(new Coordinate("A", "1"));
        coords.add(new Coordinate("A", "2"));
        coords.add(new Coordinate("A", "3"));
        coords.add(new Coordinate("A", "4"));
        assertTrue(CoordinateValidator.isTheSameLetter(coords));
    }

    @Test
    public void shouldNotPassIfIsNotTheSameLetter() {
        List<Coordinate> coords = new ArrayList<>();
        coords.add(new Coordinate("A", "1"));
        coords.add(new Coordinate("B", "2"));
        coords.add(new Coordinate("A", "3"));
        coords.add(new Coordinate("A", "4"));
        assertFalse(CoordinateValidator.isTheSameLetter(coords));
    }

    @Test
    public void shouldPassIfIsTheSameNumber() {
        List<Coordinate> coords = new ArrayList<>();
        coords.add(new Coordinate("A", "1"));
        coords.add(new Coordinate("A", "1"));
        coords.add(new Coordinate("A", "1"));
        coords.add(new Coordinate("A", "1"));
        assertTrue(CoordinateValidator.isTheSameLetter(coords));
    }

    @Test
    public void shouldNotPassIfIsNotTheSameNumber() {
        List<Coordinate> coords = new ArrayList<>();
        coords.add(new Coordinate("A", "1"));
        coords.add(new Coordinate("B", "2"));
        coords.add(new Coordinate("A", "3"));
        coords.add(new Coordinate("A", "4"));
        assertFalse(CoordinateValidator.isTheSameLetter(coords));
    }

    @Test
    public void shouldPassIfThereAreCorrectLettersInCoords() {
        List<Coordinate> coords = new ArrayList<>();
        coords.add(new Coordinate("A", "1"));
        coords.add(new Coordinate("B", "1"));
        coords.add(new Coordinate("C", "1"));
        coords.add(new Coordinate("D", "1"));
        assertTrue(CoordinateValidator.areCorrectLettersInCoords(coords));
    }

    @Test
    public void shouldNotPassIfThereAreNotCorrectLettersInCoords() {
        List<Coordinate> coords = new ArrayList<>();
        coords.add(new Coordinate("A", "1"));
        coords.add(new Coordinate("B", "1"));
        coords.add(new Coordinate("D", "1"));
        coords.add(new Coordinate("E", "1"));
        assertFalse(CoordinateValidator.areCorrectLettersInCoords(coords));
    }

    @Test
    public void shouldPassIfThereAreCorrectNumbersInCoords() {
        List<Coordinate> coords = new ArrayList<>();
        coords.add(new Coordinate("B", "1"));
        coords.add(new Coordinate("B", "2"));
        coords.add(new Coordinate("B", "3"));
        coords.add(new Coordinate("B", "4"));
        assertTrue(CoordinateValidator.areCorrectNumbersInCoords(coords));
    }

    @Test
    public void shouldNotPassIfThereAreNotCorrectNumbersInCoords() {
        List<Coordinate> coords = new ArrayList<>();
        coords.add(new Coordinate("B", "1"));
        coords.add(new Coordinate("B", "2"));
        coords.add(new Coordinate("B", "5"));
        coords.add(new Coordinate("B", "4"));
        assertFalse(CoordinateValidator.areCorrectNumbersInCoords(coords));
    }

    @Test
    public void shouldPassIfOnlyOneCoordinate() {
        List<Coordinate> coords = new ArrayList<>();
        coords.add(new Coordinate("B", "1"));
        assertTrue(CoordinateValidator.areCorrectNumbersInCoords(coords));
    }

    @Test
    public void shouldPassIfCoordsAreCorrect() {
        List<Coordinate> coords = new ArrayList<>();
        coords.add(new Coordinate("A", "10"));
        coords.add(new Coordinate("B", "10"));
        coords.add(new Coordinate("C", "10"));
        coords.add(new Coordinate("D", "10"));
        coords.add(new Coordinate("E", "10"));
        Ship ship = new Ship(ShipType.BATTLESHIP);
        ship.setCoords(coords);
        assertTrue(CoordinateValidator.areCoordsCorrect(ShipType.BATTLESHIP, ship.getCoords()));

        coords = new ArrayList<>();
        coords.add(new Coordinate("J", "1"));
        coords.add(new Coordinate("J", "2"));
        coords.add(new Coordinate("J", "3"));
        coords.add(new Coordinate("J", "4"));
        coords.add(new Coordinate("J", "5"));
        ship = new Ship(ShipType.BATTLESHIP);
        ship.setCoords(coords);
        assertTrue(CoordinateValidator.areCoordsCorrect(ShipType.BATTLESHIP, ship.getCoords()));
    }


    @Test
    public void shouldReturnTrueIfAnyCoordsAreTheSame() {
        Ship ship1 = new Ship(ShipType.DESTROYER);
        ship1.addCoordinate(new Coordinate("A", "1"));
        ship1.addCoordinate(new Coordinate("A", "2"));
        ship1.addCoordinate(new Coordinate("A", "3"));
        ship1.addCoordinate(new Coordinate("A", "4"));
        assertTrue(CoordinateValidator.doesShipHaveOccupiedCoords(createShips(), ship1));
    }

    @Test
    public void shouldReturnFalseIfAnyCoordsFromShipDidNotAppear() {
        Ship ship1 = new Ship(ShipType.DESTROYER);
        ship1.addCoordinate(new Coordinate("F", "1"));
        ship1.addCoordinate(new Coordinate("G", "2"));
        ship1.addCoordinate(new Coordinate("H", "3"));
        ship1.addCoordinate(new Coordinate("I", "4"));
        assertFalse(CoordinateValidator.doesShipHaveOccupiedCoords(createShips(), ship1));
    }

    @Test
    public void shouldReturnTrueIfTrueIfCoordinateIsOccupied() {
        Coordinate coordinate = new Coordinate("A", "1");
        assertTrue(CoordinateValidator.isCoordinateOccupied(createShips(), coordinate));
    }

    @Test
    public void shouldReturnFalseIfTrueIfCoordinateIsNotOccupied() {
        Coordinate coordinate = new Coordinate("B", "10");
        assertFalse(CoordinateValidator.isCoordinateOccupied(createShips(), coordinate));
    }

    @Test
    public void shouldPassIfNumberInvalid() {
        assertFalse(CoordinateValidator.isNumberValid("0"));
        assertFalse(CoordinateValidator.isNumberValid("11"));
        assertFalse(CoordinateValidator.isNumberValid("12"));
    }

    @Test
    public void shouldPassIfNumberIsValid() {
        assertTrue(CoordinateValidator.isNumberValid("1"));
        assertTrue(CoordinateValidator.isNumberValid("5"));
        assertTrue(CoordinateValidator.isNumberValid("10"));
    }

    @Test
    public void shouldPassIfLetterIsValid() {
        assertTrue(CoordinateValidator.isLetterValid("A"));
        assertTrue(CoordinateValidator.isLetterValid("B"));
        assertTrue(CoordinateValidator.isLetterValid("J"));
    }

    @Test
    public void shouldPassIfLetterIsInvalid() {
        assertFalse(CoordinateValidator.isLetterValid("ABCDE"));
        assertFalse(CoordinateValidator.isLetterValid("*"));
        assertFalse(CoordinateValidator.isLetterValid("K"));
        assertFalse(CoordinateValidator.isLetterValid("L"));
    }

    private List<Ship> createShips() {
        List<Ship> ships = new ArrayList<>();

        Ship ship1 = new Ship(ShipType.DESTROYER);
        ship1.addCoordinate(new Coordinate("A", "1"));
        ship1.addCoordinate(new Coordinate("B", "1"));
        ship1.addCoordinate(new Coordinate("C", "1"));
        ship1.addCoordinate(new Coordinate("D", "1"));

        Ship ship2 = new Ship(ShipType.DESTROYER);
        ship2.addCoordinate(new Coordinate("A", "2"));
        ship2.addCoordinate(new Coordinate("B", "2"));
        ship2.addCoordinate(new Coordinate("C", "2"));
        ship2.addCoordinate(new Coordinate("D", "2"));

        Ship ship3 = new Ship(ShipType.BATTLESHIP);
        ship3.addCoordinate(new Coordinate("A", "3"));
        ship3.addCoordinate(new Coordinate("B", "3"));
        ship3.addCoordinate(new Coordinate("C", "3"));
        ship3.addCoordinate(new Coordinate("D", "3"));
        ship3.addCoordinate(new Coordinate("E", "3"));

        Ship ship4 = new Ship(ShipType.BATTLESHIP);
        ship4.addCoordinate(new Coordinate("A", "1"));
        ship4.addCoordinate(new Coordinate("A", "2"));
        ship4.addCoordinate(new Coordinate("A", "3"));
        ship4.addCoordinate(new Coordinate("A", "4"));
        ship4.addCoordinate(new Coordinate("A", "5"));

        ships.add(ship1);
        ships.add(ship2);
        ships.add(ship3);

        return ships;
    }
}