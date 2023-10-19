package utils;

import entity.User;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
    private final Pattern EMAIL_PATTERN = Pattern.compile("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$");
    private final Pattern NAME_SURNAME_PATTERN = Pattern.compile("^[A-Z][a-zA-Z]*$");
    private final Pattern PASSWORD_PATTERN = Pattern.compile("^(?=.*?[A-Z])(?=(.*[a-z]){1,})(?=(.*[\\d]){1,})(?=(.*[\\W]){1,})(?!.*\\s).{8,}$");
    private final Pattern USERNAME_PATTERN = Pattern.compile("^(?!.*[.!,{}?|/+=#$%^&*]$)[A-Za-z0-9][A-Za-z0-9.!,{}?|/+=#$%^&*]{0,18}[A-Za-z0-9]$");

    public boolean validate(User user) {
        return  nameSurnameValidation(user.getName()) &&
                nameSurnameValidation(user.getUserName()) &&
                passwordValidation(user.getPassword());
    }

    private boolean emailValidation(String email) {
        Matcher matcher = EMAIL_PATTERN.matcher(email);

        if (matcher.matches())
            return true;

        throw new RuntimeException("Invalid email!");
    }

    private boolean nameSurnameValidation(String nameSurname) {
        Matcher matcher = NAME_SURNAME_PATTERN.matcher(nameSurname);

        if (matcher.matches())
            return true;

        throw new RuntimeException("Invalid!");
    }

    private boolean passwordValidation(String password) {
        Matcher matcher = PASSWORD_PATTERN.matcher(password);

        if (matcher.matches())
            return true;

        throw new RuntimeException("Invalid password!");
    }

    private boolean usernameValidation(String username) {
        Matcher matcher = USERNAME_PATTERN.matcher(username);

        if (matcher.matches())
            return true;

        throw new RuntimeException("Invalid username");
    }

}
