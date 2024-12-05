package Business;

import Persistence.PersonalizedException;

public class UiManager {

    public int checkUserInput(String userInput, int min, int max) throws PersonalizedException {


        try {
            int option = Integer.parseInt(userInput);

            if (userInput.isEmpty()) { // Check if the user input is empty
                throw new PersonalizedException("ERROR: User input cannot be empty.");
            } else if (option < min || option > max) { // Check if the user input is within the range
                throw new PersonalizedException("ERROR: Option is not in the correct format!");
            } else {
                return option;
            }
        } catch (NumberFormatException e) {
            throw new PersonalizedException("ERROR: Input is not a number!");
        }

    }
}
