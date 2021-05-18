import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class JudgeTest {
    private Ship ship;
    private Player player;

    @Before
    public void setUp() {
        ship = new Ship(ShipType.DESTROYER);
        ship.addCoordinate(new Coordinate("A", "1"));
        ship.addCoordinate(new Coordinate("B", "1"));
        ship.addCoordinate(new Coordinate("C", "1"));
        ship.addCoordinate(new Coordinate("D", "1"));
        player = new Player();
        createShipsForPlayer();

    }

    @Test
    public void shouldReturnTrueIfShipGotShot() {
        Judge judge = new Judge();
        Coordinate coordinate = new Coordinate("A", "1");
        assertTrue(judge.wasShipHit(ship, coordinate));
    }

    @Test
    public void shouldReturnFalseIfShipDidNotGetShot() {
        Judge judge = new Judge();
        Coordinate coordinate = new Coordinate("A", "2");
        assertFalse(judge.wasShipHit(ship, coordinate));
    }

    @Test
    public void shouldReturnTrueIfLifeWasSubtracted() {
        Judge judge = new Judge();
        judge.subtractLife(ship);
        assertEquals(3, ship.getLives());
    }


    private void sinkAllShips(List<Ship> ships) {
        for (Ship ship : ships) {
            ship.setSunk(true);
        }
    }


    private void createShipsForPlayer() {
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

        player.addShip(ship1);
        player.addShip(ship2);
        player.addShip(ship3);
    }
}