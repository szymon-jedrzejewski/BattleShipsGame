import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class AIPlayerTest {
    @Test
    public void shouldPassIfShipIsCoordsOfDestroyerAreCorrect() {
        Player player = new AIPlayer();
        player.initializeShip(ShipType.DESTROYER);
        Ship ship = player.getShips().get(0);
        ship.sortCoords();
        System.out.println(ship.getCoords());
        assertTrue(CoordinateValidator.areCoordsCorrect(ShipType.DESTROYER, ship.getCoords()));
    }

    @Test
    public void shouldPassIfShipIsCoordsOfBattleShipAreCorrect() {
        Player player = new AIPlayer();
        player.initializeShip(ShipType.BATTLESHIP);
        Ship ship = player.getShips().get(0);
        ship.sortCoords();
        System.out.println(ship.getCoords());
        assertTrue(CoordinateValidator.areCoordsCorrect(ShipType.BATTLESHIP, ship.getCoords()));
    }

    @Test
    public void shouldPassIfShipGeneratesShipThatDoesNotExist() {
        Player player = new AIPlayer();
        player.addShip(getShip());
        player.initializeShip(ShipType.BATTLESHIP);
        Ship ship = player.getShips().get(0);
        ship.sortCoords();
        System.out.println(ship.getCoords());
        assertTrue(CoordinateValidator.areCoordsCorrect(ShipType.BATTLESHIP, ship.getCoords()));
    }

    private Ship getShip() {
        Ship ship = new Ship(ShipType.DESTROYER);
        ship.addCoordinate(new Coordinate("A", "1"));
        ship.addCoordinate(new Coordinate("A", "2"));
        ship.addCoordinate(new Coordinate("A", "3"));
        ship.addCoordinate(new Coordinate("A", "4"));
        return ship;
    }
}