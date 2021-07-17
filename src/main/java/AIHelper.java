import java.util.Random;

public class AIHelper {
    private final Random random = new Random();
    private final int LIMIT_OF_SHIPS = 3;
    private final String LETTERS = "ABCDEFGHIJ";


    private String generateRandomNumber() {
        int randomNumber = random.nextInt((10 - 1) + 1) + 1;
        return String.valueOf(randomNumber);
    }

    private String generateRandomLetter() {
        int randomNumber = random.nextInt((10 - 1) + 1) + 1;
        return String.valueOf(LETTERS.charAt(randomNumber));
    }

    private boolean isHorizontal() {
        return random.nextBoolean();
    }

    private Ship generateShip(ShipType type) {
        Ship ship = new Ship(type);
        if (isHorizontal()) {
            String number = generateRandomNumber();
            for (int i = 0; i < type.getShipSize(); i++) {

            }
        } else {
            String letter = generateRandomLetter();
            for (int i = 0; i < type.getShipSize(); i++) {

            }
        }
        return ship;
    }

}
