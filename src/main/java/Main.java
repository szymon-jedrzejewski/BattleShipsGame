public class Main {
    public static void main(String[] args) {
        Game game = new Game(new ConsolePlayer(new ConsoleView()), new AIPlayer(), new Judge(), new ConsoleView());
        game.startGame();
    }
}
