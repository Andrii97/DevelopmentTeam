package ua.training.controller.validator;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by andrii on 25.01.17.
 */
public class Errors {
    private Map<String, String> messages = new HashMap<>();
    private boolean result = true;

    public void addMessage(String attribute, String message) {
        messages.put(attribute, message);
    }

    public Map<String, String> getMessages() {
        return messages;
    }

    public boolean hasError(){
        return !result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public boolean getResult() {
        return result;
    }
}
