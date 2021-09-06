import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ShipTest {

    @Test
    public void shouldPassIfCoordsAreSorted() {
        List<Coordinate> coords = new ArrayList<>();
        coords.add(new Coordinate("A", "2"));
        coords.add(new Coordinate("A", "1"));
        coords.add(new Coordinate("A", "4"));
        coords.add(new Coordinate("A", "3"));
        Ship ship = new Ship(ShipType.DESTROYER);
        ship.setCoords(coords);
        ship.sortCoords();

        List<Coordinate> expected = new ArrayList<>();
        expected.add(new Coordinate("A", "1"));
        expected.add(new Coordinate("A", "2"));
        expected.add(new Coordinate("A", "3"));
        expected.add(new Coordinate("A", "4"));
        for (int i = 0; i < coords.size(); i++) {
            assertEquals(ship.getCoords().get(i).getCoordinate(), expected.get(i).getCoordinate());
        }
    }

    @Test
    public void shouldPassIfLastCoordsAreSorted() {
        List<Coordinate> coords = new ArrayList<>();
        coords.add(new Coordinate("A", "10"));
        coords.add(new Coordinate("A", "8"));
        coords.add(new Coordinate("A", "7"));
        coords.add(new Coordinate("A", "9"));
        Ship ship = new Ship(ShipType.DESTROYER);
        ship.setCoords(coords);
        ship.sortCoords();

        List<Coordinate> expected = new ArrayList<>();
        expected.add(new Coordinate("A", "7"));
        expected.add(new Coordinate("A", "8"));
        expected.add(new Coordinate("A", "9"));
        expected.add(new Coordinate("A", "10"));
        for (int i = 0; i < coords.size(); i++) {
            assertEquals(ship.getCoords().get(i).getCoordinate(), expected.get(i).getCoordinate());
        }
    }
}