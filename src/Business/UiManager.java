package Business;

import Persistence.PersonalizedException;

public class UiManager {

    public int checkUserInput(String userInput, int min, int max) throws PersonalizedException {


        try {
            int option = Integer.parseInt(userInput);

            if (userInput.isEmpty()) { // Check if the user input is empty
                throw new PersonalizedException("\nERROR: User input cannot be empty.\n");
            } else if (option < min || option > max) { // Check if the user input is within the range
                throw new PersonalizedException("\nERROR: Option is invalid as it is out of range! Valid range [" + min + " - " + max + "]\n");
            } else {
                return option;
            }
        } catch (NumberFormatException e) {
            throw new PersonalizedException("\nERROR: Input is not a number!\n");
        }

    }
}
