import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class JudgeTest {
    private Ship ship;
    private Coordinate coordinate;

    @Before
    public void setUp() {
        ship = new Ship(4);
        ship.addCoordinate(new Coordinate("A", "1"));
        ship.addCoordinate(new Coordinate("B", "1"));
        ship.addCoordinate(new Coordinate("C", "1"));
        ship.addCoordinate(new Coordinate("D", "1"));

        coordinate = new Coordinate("A", "1");
    }

    @Test
    public void shouldReturnTrueIfShipGotShot() {
        Judge judge = new Judge();
        assertTrue(judge.wasShipHit(ship, coordinate));
    }
}