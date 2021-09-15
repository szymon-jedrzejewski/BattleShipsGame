public class Game {
    private Player playerOne;
    private Player playerTwo;

//    public Game(Player playerOne, Player playerTwo) {
//        this.playerOne = playerOne;
//        this.playerTwo = playerTwo;
//    }

    public void startGame() {
        Player player = new Player();
        AIHelper computerPlayer = new AIHelper();
        for (ShipType shipType : ShipType.values()) {
            for (int i = 0; i < shipType.getAllowedNumberOfShips(); i++) {
                Ship ship = new Ship(shipType);
            }
        }

    }



}
