package servlet;

import services.UserService;
import domain.User;
import utils.Validator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
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
       User user = new User();

        String userName = req.getParameter("userName");
        String password = req.getParameter("password");

        user.setUserName(userName);
        user.setPassword(password);

        if (validation.validate(user)) {
            Optional<User> byUserName = userService.findByUsername(userName);

            if (byUserName.isPresent()) {
                user = byUserName.get();

                if (user.getPassword().equals(password)) {
                    req.getSession().setAttribute("user", user);
                    resp.sendRedirect("/");
                } else {
                    resp.sendError(400, "Wrong password!!!");
                }
            } else {
                resp.sendError(400, "User not found!!!");
            }
        }
        else {
            resp.getWriter().println("Incorrect data ...");
        }
    }
}
