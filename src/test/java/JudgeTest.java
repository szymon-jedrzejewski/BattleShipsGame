import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class JudgeTest {
    private Ship ship;

    @Before
    public void setUp() {
        ship = new Ship(ShipType.DESTROYER);
        ship.addCoordinate(new Coordinate("A", "1"));
        ship.addCoordinate(new Coordinate("B", "1"));
        ship.addCoordinate(new Coordinate("C", "1"));
        ship.addCoordinate(new Coordinate("D", "1"));
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
}