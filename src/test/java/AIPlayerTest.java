import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class AIPlayerTest {
    @Test
    public void shouldPassIfShipIsCoordsOfDestroyerAreCorrect() {
        Player player = new AIPlayer();
        player.createShip(ShipType.DESTROYER);
        Ship ship = player.getShips().get(0);
        ship.sortCoords();
        System.out.println(ship.getCoords());
        assertTrue(CoordinateValidator.areCoordsCorrect(ShipType.DESTROYER, ship.getCoords()));
    }

    @Test
    public void shouldPassIfShipIsCoordsOfBattleShipAreCorrect() {
        Player player = new AIPlayer();
        player.createShip(ShipType.BATTLESHIP);
        Ship ship = player.getShips().get(0);
        ship.sortCoords();
        System.out.println(ship.getCoords());
        assertTrue(CoordinateValidator.areCoordsCorrect(ShipType.BATTLESHIP, ship.getCoords()));
    }
}