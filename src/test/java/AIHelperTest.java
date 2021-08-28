import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class AIHelperTest {

    @Test
    public void shouldReturnTrueIfAnyCoordsAreTheSame() {
        Ship ship1 = new Ship(ShipType.DESTROYER);
        ship1.addCoordinate(new Coordinate("A", "1"));
        ship1.addCoordinate(new Coordinate("A", "2"));
        ship1.addCoordinate(new Coordinate("A", "3"));
        ship1.addCoordinate(new Coordinate("A", "4"));
        AIHelper aiHelper = new AIHelper();
        assertTrue(aiHelper.doesShipHaveUnoccupiedCoords(createShips(), ship1));
    }

    @Test
    public void shouldReturnFalseIfAnyCorrdsFromShipDidNotAppear() {
        Ship ship1 = new Ship(ShipType.DESTROYER);
        ship1.addCoordinate(new Coordinate("F", "1"));
        ship1.addCoordinate(new Coordinate("G", "2"));
        ship1.addCoordinate(new Coordinate("H", "3"));
        ship1.addCoordinate(new Coordinate("I", "4"));
        AIHelper aiHelper = new AIHelper();
        assertFalse(aiHelper.doesShipHaveUnoccupiedCoords(createShips(), ship1));
    }

    @Test
    public void shouldPassIfShipIsCoordsOfDestroyerArOk() {
        Ship ship = new AIHelper().generateShip(ShipType.DESTROYER);
        ship.toString();
        assertTrue(CoordinateValidator.areCoordsCorrect(ShipType.DESTROYER, ship.getCoords()));
    }

    @Test
    public void shouldPassIfShipIsCoordsOfBattleShipArOk() {
        Ship ship = new AIHelper().generateShip(ShipType.BATTLESHIP);
        ship.toString();
        assertTrue(CoordinateValidator.areCoordsCorrect(ShipType.BATTLESHIP, ship.getCoords()));
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