package Business;

public enum Strategy {
    balanced;

    public static Strategy getStrategy(int strategyNum) throws IllegalArgumentException {
        if (strategyNum < 1 || strategyNum > Strategy.values().length) {
            throw new IllegalArgumentException("\tOption not valid!");
        }
        return Strategy.values()[strategyNum - 1];
    }
}


