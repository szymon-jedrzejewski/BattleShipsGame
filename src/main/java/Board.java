import java.util.List;

public class Board {
    private int width;
    private int height;
    private List<Ship> playerOneShips;
    private List<Ship> playerTwoShips;

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
