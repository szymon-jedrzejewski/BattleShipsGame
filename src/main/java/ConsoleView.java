import java.util.List;

public class ConsoleView implements View {
    @Override
    public void displayMessage(String message) {
        System.out.print(message);
    }

    @Override
    public void displayShips(List<Ship> ships) {
        ships.forEach(ship -> System.out.println(ship.toString()));
    }

    @Override
    public void displayShots(List<Coordinate> coords) {
        coords.forEach(coordinate -> System.out.println(coordinate.toString()));
    }
}
