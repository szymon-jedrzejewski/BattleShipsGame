import java.util.List;

public interface View {
    void displayMessage(String message);
    void displayShips(List<Ship> ships);
    void displayShots(List<Coordinate> coords);
}
