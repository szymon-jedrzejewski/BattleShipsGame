public class Game {
    private final Player playerOne;
    private final Player playerTwo;
    private final Judge judge;
    private View view;

    public Game(Player playerOne, Player playerTwo, Judge judge, View view) {
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
        this.judge = judge;
        this.view = view;
    }

    public void startGame() {
        initializeShips();
        view.displayMessage("\nPlayer one ships: " + playerOne.getShips().toString());
        view.displayMessage("\nPlayer two ships: " + playerTwo.getShips().toString());

        while (true) {
            Coordinate playerOneShot = playerOne.shot();
            if (judge.isAnyShipHit(playerTwo.getShips(), playerOneShot)) {
                view.displayMessage("\nPlayer two ship got hit.");
                if (judge.areAllShipsSunk(playerTwo.getShips())) {
                    view.displayMessage("\nPlayer one win");
                    break;
                }
            }

            Coordinate playerTwoShot = playerTwo.shot();
            view.displayMessage("\nPlayer two shot: " + playerTwoShot);

            if (judge.isAnyShipHit(playerOne.getShips(), playerTwoShot)) {
                view.displayMessage("\nPlayer one ship got hit.");
                if (judge.areAllShipsSunk(playerOne.getShips())) {
                    view.displayMessage("\nPlayer two win");
                    break;
                }
            }
        }
    }

    public void initializeShips() {
        for (ShipType type : ShipType.values()) {
            for (int i = 0; i < type.getAllowedNumberOfShips(); i++) {
                view.displayMessage("\nInitializing ship: " + type.toString());
                playerOne.initializeShip(type);
                playerTwo.initializeShip(type);
                view.displayMessage("\nShip " + type.toString() + " number: " + i + " was created!");
            }

        }
    }

}
