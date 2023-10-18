package servlet;

import domain.User;
import services.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@WebServlet("/profile")
public class ProfileServlet extends HttpServlet {
    UserService userService = UserService.getInstance();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String userName = req.getParameter("userName");
        Optional <User> userByName = userService.getUserByName(userName);

        if (userByName.isPresent()){
            userByName.get();

            req.setAttribute("user", userByName.orElse(null));
        }
        getServletContext().getRequestDispatcher("/pages/profile.jsp").forward(req, resp);
    }
}
