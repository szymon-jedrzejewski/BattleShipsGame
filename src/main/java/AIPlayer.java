import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Random;

public class AIPlayer extends Player {
    private static final Logger logger = LogManager.getLogger(AIPlayer.class);
    private final Random random = new Random();
    private final String LETTERS = "ABCDEFGHIJ";


    private String generateRandomNumber() {
        int randomNumber = random.nextInt((10 - 1) + 1) + 1;
        return String.valueOf(randomNumber);
    }

    private String generateRandomLetter() {
        int randomNumber = random.nextInt(10);
        return String.valueOf(LETTERS.charAt(randomNumber));
    }

    private boolean isHorizontal() {
        return random.nextBoolean();
    }

    boolean createShip(ShipType type) {
        final char MID_LETTER = 'E';
        final int MID_NUMBER = 5;
        Ship ship = new Ship(type);
        String number = generateRandomNumber();
        String letter = generateRandomLetter();
        logger.debug("Number: " + number);
        logger.debug("Letter: " + letter);
        if (isHorizontal()) {
            int letterIndex = LETTERS.indexOf(letter);
            if (letter.charAt(0) > MID_LETTER) {
                for (int i = 0; i < type.getShipSize(); i++) {
                    String previousLetter = String.valueOf(LETTERS.charAt(letterIndex - i));
                    logger.debug("PreviousLetter: " + previousLetter);
                    ship.addCoordinate(new Coordinate(previousLetter, number));
                }
            } else {
                for (int i = 0; i < type.getShipSize(); i++) {
                    String nextLetter = String.valueOf(LETTERS.charAt(letterIndex + i));
                    logger.debug("NextLetter: " + nextLetter);
                    ship.addCoordinate(new Coordinate(nextLetter, number));
                }
            }

        } else {
            if (Integer.parseInt(number) > MID_NUMBER) {
                for (int i = 0; i < type.getShipSize(); i++) {
                    String previousNumber = String.valueOf(Integer.parseInt(number) - i);
                    logger.debug("PreviousNumber: " + previousNumber);
                    ship.addCoordinate(new Coordinate(letter, previousNumber));
                }
            } else {
                for (int i = 0; i < type.getShipSize(); i++) {
                    String nextNumber = String.valueOf(Integer.parseInt(number) + i);
                    logger.debug("NextNumber: " + nextNumber);
                    ship.addCoordinate(new Coordinate(letter, nextNumber));
                }
            }
        }

        if (!CoordinateValidator.doesShipHaveOccupiedCoords(getShips(), ship)) {
            addShip(ship);
            return true;
        }

        return false;
    }
}
