package servlet;

import entity.Country;
import entity.User;
import services.CountryService;
import services.UserService;
import utils.Validator;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

@WebServlet("/reg")
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024,
        maxFileSize = 1024 * 1024 * 5,
        maxRequestSize = 1024 * 1024 * 5 * 5
)
public class RegistrationServlet extends HttpServlet {
    private final static String NAME = "name";
    private final static String SURNAME = "surname";
    private final static String USERNAME = "userName";
    private final static String EMAIL = "email";
    private final static String PASSWORD = "password";
    private final static String COUNTRY = "country";
    private final static String PHOTO = "photo";
    private final static String ROLE = "role";
    private final UserService userService = UserService.getInstance();
    private final CountryService countryService = CountryService.getInstance();
    private final Validator validation = new Validator();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        List<Country> countryList = countryService.getAll();
        req.setAttribute("countries", countryList);
        getServletContext().getRequestDispatcher("/pages/reg.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        InputStream photoInputStream = req.getPart(PHOTO).getInputStream();
        String name = req.getParameter(NAME);
        String surname = req.getParameter(SURNAME);
        String username = req.getParameter(USERNAME);
        String email = req.getParameter(EMAIL);
        String password = req.getParameter(PASSWORD);
        String role = req.getParameter(ROLE);
        Country country = countryService.getById(Integer.parseInt(req.getParameter(COUNTRY))).orElse(new Country());

        User user = User.builder()
                .name(name)
                .surname(surname)
                .userName(username)
                .email(email)
                .password(password)
                .country(country)
                .role(role)
                .photo(Base64.getEncoder().encodeToString(photoInputStream.readAllBytes()))
                .build();

        Optional<User> byUsername = userService.getUserByName(username);

        if (!validation.validate(user)){
            req.setAttribute("invalid data", "Registration failed. Check the entered data!");
        }

        if (byUsername.isEmpty()){
            UserService.getInstance().add(user);
            resp.sendRedirect("/login");
            return;
        } else {
            req.setAttribute("massage", "This user already exists!");
        }

        if (!byUsername.isPresent()){
            req.setAttribute("errormassage", "Registration failed. Check the entered data!");
        }
        getServletContext().getRequestDispatcher("/pages/register.jsp").forward(req, resp);
    }
}
