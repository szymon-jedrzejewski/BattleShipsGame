import java.util.Random;

public class AIHelper {
    private final Random random = new Random();

    private String generateRandomNumber() {
        int randomNumber = random.nextInt((10 - 1) + 1) + 1;
        return String.valueOf(randomNumber);
    }

    private String generateRandomLetter() {
        final String LETTERS = "ABCDEFGHIJ";
        int randomNumber = random.nextInt((10 - 1) + 1) + 1;
        return String.valueOf(LETTERS.charAt(randomNumber));
    }

    public Coordinate generateCoordinate() {
        return new Coordinate(generateRandomLetter(), generateRandomNumber());
    }

}
