package utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AnalisisInput {
    Matcher matcher;
    public AnalisisInput(String input) {
        Pattern pattern = Pattern.compile("^[0-9]+(\\.[0-9]+)?$");
        this.matcher = pattern.matcher(input);

    }

    public Matcher getMatcher() {
        return matcher;
    }
}
