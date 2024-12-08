package Business;

/**
 * Enum class for the strategy of the combat.
 */
public enum Strategy {
    balanced;

    /**
     * Method to get the strategy.
     * @param strategyNum The number of the strategy.
     * @return The strategy.
     * @throws IllegalArgumentException If the strategy number is not valid.
     */
    public static Strategy getStrategy(int strategyNum) throws IllegalArgumentException {
        if (strategyNum < 1 || strategyNum > Strategy.values().length) {
            throw new IllegalArgumentException("\tOption not valid!");
        }
        return Strategy.values()[strategyNum - 1];
    }
}


