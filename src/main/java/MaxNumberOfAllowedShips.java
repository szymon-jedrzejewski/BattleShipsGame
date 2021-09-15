public enum MaxNumberOfAllowedShips {
    MAX_NUMBER_OF_SHIPS(3);

    private int maxNumber;
    MaxNumberOfAllowedShips(int maxNumber) {
        this.maxNumber = maxNumber;
    }

    public int getMaxNumber() {
        return maxNumber;
    }
}
