import java.util.List;
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
        int randomNumber = random.nextInt(10);
        return String.valueOf(LETTERS.charAt(randomNumber));
    }

    private boolean isHorizontal() {
        return random.nextBoolean();
    }

    public Ship generateShip(ShipType type) {
        final char MID_LETTER = 'E';
        final int MID_NUMBER = 5;
        Ship ship = new Ship(type);
        String number = generateRandomNumber();
        String letter = generateRandomLetter();
        System.out.println("Number: " + number);
        System.out.println("Letter: " + letter);
        if (isHorizontal()) {
            int letterIndex = LETTERS.indexOf(letter);
            if (letter.charAt(0) > MID_LETTER) {
                for (int i = 0; i < type.getShipSize(); i++) {
                    String previousLetter = String.valueOf(LETTERS.charAt(letterIndex - i));
                    System.out.println("PreviousLetter: " + previousLetter);
                    ship.addCoordinate(new Coordinate(previousLetter, number));
                }
            } else {
                for (int i = 0; i < type.getShipSize(); i++) {
                    String nextLetter = String.valueOf(LETTERS.charAt(letterIndex + i));
                    System.out.println("NextLetter: " + nextLetter);
                    ship.addCoordinate(new Coordinate(nextLetter, number));
                }
            }

        } else {
            if (Integer.parseInt(number) > MID_NUMBER) {
                for (int i = 0; i < type.getShipSize(); i++) {
                    String previousNumber = String.valueOf(Integer.parseInt(number) - i);
                    System.out.println("PreviousNumber: " + previousNumber);
                    ship.addCoordinate(new Coordinate(letter, previousNumber));
                }
            } else {
                for (int i = 0; i < type.getShipSize(); i++) {
                    String nextNumber = String.valueOf(Integer.parseInt(number) + i);
                    System.out.println("NextNumber: " + nextNumber);
                    ship.addCoordinate(new Coordinate(letter, nextNumber));
                }
            }
        }
        return ship;
    }

    public boolean doesShipHaveUnoccupiedCoords(List<Ship> ships, Ship ship) {
        for (Ship shipfromList : ships) {
            for (Coordinate coordinate : shipfromList.getCoords()) {
                return ship
                        .getCoords()
                        .stream()
                        .anyMatch(coord -> coord.getCoordinate().equals(coordinate.getCoordinate()));
            }
        }
        return false;
    }


}
