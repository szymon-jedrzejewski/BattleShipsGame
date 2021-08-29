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
}