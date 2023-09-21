package validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserDataValidation {
    public boolean passwordValidation (String type) {
        Pattern compile = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[A-Za-z\\d@$!%*?&]{8,}$");
        Matcher matcher = compile.matcher(type);
        return matcher.matches();
    }
    public boolean nameValidation (String type) {
        Pattern compile = Pattern.compile("^[a-zA-Z0-9._%+-]{4,}$");
        Matcher matcher = compile.matcher(type);
        return matcher.matches();
    }
}
