package servlet;

import services.UserService;
import validation.UserDataValidation;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/reg")
public class RegistrationServlet extends HttpServlet {
    private final UserService userService = new UserService();
    private final UserDataValidation validation = new UserDataValidation();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        getServletContext().getRequestDispatcher("/pages/reg.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String userName = req.getParameter("userName");
        String password = req.getParameter("password");
        String role = req.getParameter("role");

        if (validation.nameValidation(name) && validation.passwordValidation(password)){
            userService.create(name, userName, password, role);
            resp.sendRedirect("/");
        } else {
            resp.getWriter().println("Incorrect data ...");
        }
    }
}
