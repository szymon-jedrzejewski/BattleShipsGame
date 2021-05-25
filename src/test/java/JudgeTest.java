import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class JudgeTest {
    private Ship ship;
    private Judge judge;

    @Before
    public void setUp() {
        judge = new Judge();
        ship = new Ship(ShipType.DESTROYER);
        ship.addCoordinate(new Coordinate("A", "1"));
        ship.addCoordinate(new Coordinate("B", "1"));
        ship.addCoordinate(new Coordinate("C", "1"));
        ship.addCoordinate(new Coordinate("D", "1"));
    }

    @Test
    public void shouldPassIfShipGotShot() {
        Coordinate coordinate = new Coordinate("A", "1");
        assertTrue(judge.wasShipHit(ship, coordinate));
    }

    @Test
    public void shouldPassIfShipDidNotGetShot() {
        Coordinate coordinate = new Coordinate("A", "2");
        assertFalse(judge.wasShipHit(ship, coordinate));
    }

    @Test
    public void shouldPassIfLifeWasSubtracted() {
        judge.subtractLife(ship);
        assertEquals(3, ship.getLives());
    }

    @Test
    public void shouldPassIfShipHasNoLives() {
        judge.subtractLife(ship);
        judge.subtractLife(ship);
        judge.subtractLife(ship);
        judge.subtractLife(ship);
        assertEquals(0, ship.getLives());
    }

    @Test
    public void shouldPassIfAllShipsAreSunk() {
        List<Ship> ships = sinkAllShips(createShips());
        assertTrue(judge.areAllShipsSunk(ships));
    }
    
    private List<Ship> sinkAllShips(List<Ship> ships) {
        
        for (Ship ship : ships) {
            int lives = ship.getLives();
            for (int i = 0; i < lives; i++) {
                judge.subtractLife(ship);
            }
        }
        return ships;
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

        ships.add(ship1);
        ships.add(ship2);
        ships.add(ship3);

        return ships;
    }
}