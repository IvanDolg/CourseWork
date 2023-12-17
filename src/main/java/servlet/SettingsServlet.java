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

@WebServlet("/settings")
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024,
        maxFileSize = 1024 * 1024 * 5,
        maxRequestSize = 1024 * 1024 * 5 * 5
)
public class SettingsServlet extends HttpServlet {
    private final static String NAME = "name";
    private final static String SURNAME = "surname";
    private final static String USERNAME = "userName";
    private final static String EMAIL = "email";
    private final static String PASSWORD = "password";
    private final static String COUNTRY = "country";
    private final static String PHOTO = "photo";

    private final UserService userService = UserService.getInstance();
    private final Validator validator = new Validator();
    private final CountryService countryService = CountryService.getInstance();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Country> countryList = countryService.getAll();
        req.setAttribute("countries", countryList);


        getServletContext().getRequestDispatcher("/pages/settings.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getSession().getAttribute("user") == null){
            resp.sendRedirect(req.getContextPath() + "/pages/login.jsp");
        } else {
        User user = (User) req.getSession().getAttribute("user");
            String name = req.getParameter(NAME);
            String surname = req.getParameter(SURNAME);
            String username = req.getParameter(USERNAME);
            Country country = countryService.getById(Integer.parseInt(req.getParameter(COUNTRY))).orElse(new Country());
            InputStream photo = req.getPart(PHOTO).getInputStream();
            String email = req.getParameter(EMAIL);
            String password = req.getParameter(PASSWORD);

            user.setName(name);
            user.setSurname(surname);
            user.setUserName(username);
            user.setCountry(country);
            user.setPhoto(Base64.getEncoder().encodeToString(photo.readAllBytes()));
            user.setEmail(email);
            user.setPassword(Base64.getEncoder().encodeToString(password.getBytes()));

            if (!validator.validate(user)) {
                req.setAttribute("invalid data", "Registration failed");
            }
            userService.update(user);
            resp.sendRedirect("/pages/settings.jsp");
       }
    }
}