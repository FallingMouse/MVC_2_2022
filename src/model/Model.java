package model;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class Model {
    // region fields ***
    private String fullInput = "";
    private String username = null;
    private int expectPriority = 1;
    private String message = "";
    private String respondText = "";
    // endregion fields ***

    // region constructors ***
    public Model() {
    
    }
    // endregion constructors ***
    
    // region private method ***
    // Check Syntax Method
    private void readInput(String fullInput) {
        // Reset message
        message = "";

        // Split input and Check Date
        LocalDateTime currentTime = LocalDateTime.now();
        LocalTime startTime = LocalTime.of(17, 0);
        LocalTime endTime = LocalTime.of(8, 0);
        boolean isWeekend = currentTime.getDayOfWeek().getValue() >= 6;
        if (currentTime.toLocalTime().isAfter(startTime) || currentTime.toLocalTime().isBefore(endTime) || isWeekend) {
            respondText = "Sorry, we are out of service in this moment";
        }
        else { // if not out of service, check syntax
            String[] splitInput = fullInput.split("###");
            if(splitInput.length == 3) {
                String currentUsername = splitInput[0];
                int currentPriority;

                // Check username
                if (username == null) {
                    username = currentUsername;
                } else if(!username.equals(currentUsername)) {
                    respondText = "Who are you? I am talking with " + username;
                    return;
                }
                
                // Check priority
                if (splitInput[1].matches("\\d+")) {
                    currentPriority = Integer.parseInt(splitInput[1]);
                } else {
                    respondText = "I do not understand";
                    return;
                }
                if(currentPriority != expectPriority) {
                    respondText = "I am sorry " + username + 
                                    ". I think the next question number should be " 
                                    + expectPriority;
                    return;
                }
                
                // Check message
                String text = splitInput[2];
                if (text.contains(" ")) {
                    respondText = "I do not understand";
                    return;
                }
                else {
                    for (int i = 0; i < text.length(); i++) {
                        char c = text.charAt(i);
                        if (i > 0 && Character.isUpperCase(c)) {
                            message += " ";
                        }
                        message += c;
                    }
                    respondText = "That is interesting " + username + 
                                    ", that you said " + message + 
                                    ". I will send this message to someone else very soon. Anything else I can help?";
                }
            }
            else {
                respondText = "I do not understand";
            }
            expectPriority++;
        }
    }
    // endregion private method ***

    // region public method ***
    public void execute() {
        if(!fullInput.equals("")) {
            readInput(fullInput);
        }
    }
    
    // Getter
    public String getRespondText() {
        return respondText;
    }

    // Setter
    public void setFullInput(String fullInput) {
        this.fullInput = fullInput;
    }
    // endregion public method ***
}
