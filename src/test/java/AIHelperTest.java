import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class AIHelperTest {
    @Test
    public void shouldPassIfShipIsCoordsOfDestroyerAreCorrect() {
        Ship ship = new AIHelper().generateShip(ShipType.DESTROYER);
        ship.sortCoords();
        System.out.println(ship.getCoords());
        assertTrue(CoordinateValidator.areCoordsCorrect(ShipType.DESTROYER, ship.getCoords()));
    }

    @Test
    public void shouldPassIfShipIsCoordsOfBattleShipAreCorrect() {
        Ship ship = new AIHelper().generateShip(ShipType.BATTLESHIP);
        ship.sortCoords();
        System.out.println(ship.getCoords());
        assertTrue(CoordinateValidator.areCoordsCorrect(ShipType.BATTLESHIP, ship.getCoords()));
    }
}