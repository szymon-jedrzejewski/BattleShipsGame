import java.util.List;

public class Board {
    private int width;
    private int height;
    private List<Ship> playerOneShips;
    private List<Ship> playerTwoShips;

    public Board() {
    }

    public Board(int width, int height, List<Ship> playerOneShips, List<Ship> playerTwoShips) {
        this.width = width;
        this.height = height;
        this.playerOneShips = playerOneShips;
        this.playerTwoShips = playerTwoShips;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
