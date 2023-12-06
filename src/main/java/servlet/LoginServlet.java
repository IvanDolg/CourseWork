package servlet;

import services.UserService;
import entity.User;
import utils.Validator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Base64;
import java.util.Optional;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private final UserService userService = UserService.getInstance();
    private final Validator validation = new Validator();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        getServletContext().getRequestDispatcher("/pages/login.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("userName");
        String password = req.getParameter("password");

       /* User user = User.builder()
                .setUserName(userName)
                .setPassword(password)
                .build();

        *//*if (!validation.validate(user)){
            req.setAttribute("invalid data", "Registration failed. Check the entered data!");
        }*/

        Optional<User> userByName = userService.getUserByName(userName);

        if (userByName.isPresent()){
            User user = userByName.get();

            String decodePassword = Base64.getEncoder().encodeToString(password.getBytes());

            if (user.getPassword().equals(decodePassword)){
                req.getSession().setAttribute("user", user);

                resp.sendRedirect("/pages/profile.jsp");
            } else {
                req.setAttribute("passwordStatus", "Invalid password");
                getServletContext().getRequestDispatcher("/pages/login.jsp").forward(req, resp);
            }
        } else {
            req.setAttribute("usernameStatus", "Invalid Username");
            getServletContext().getRequestDispatcher("/pages/login.jsp").forward(req, resp);
        }
    }
}
