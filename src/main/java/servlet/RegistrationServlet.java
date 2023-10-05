package servlet;

import domain.User;
import services.UserService;
import utils.Validator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/reg")
public class RegistrationServlet extends HttpServlet {
    private final UserService userService = UserService.getInstance();
    private final Validator validation = new Validator();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        getServletContext().getRequestDispatcher("/pages/reg.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = new User();

        String name = req.getParameter("name");
        String userName = req.getParameter("userName");
        String password = req.getParameter("password");
        String role = req.getParameter("role");

        user.setName(name);
        user.setUserName(userName);
        user.setPassword(password);
        user.setRole(role);

        if (validation.validate(user)){
            userService.create(name, userName, password, role);
            resp.sendRedirect("/");
        } else {
            resp.getWriter().println("Incorrect data ...");
        }
    }
}
