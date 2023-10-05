package servlet;

import config.JdbcConnection;
import domain.User;
import services.UserService;
import storage.UserStorage.JDBCUserStorage;
import storage.UserStorage.UserStorage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet("/settings")
public class SettingsServlet extends HttpServlet {
    private final UserStorage storage = JDBCUserStorage.getInstance();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
           getServletContext().getRequestDispatcher("/pages/settings.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getSession().getAttribute("user") == null){
            resp.sendRedirect(req.getContextPath() + "/pages/login.jsp");
        } else {
        User user = (User) req.getSession().getAttribute("user");

        String name = req.getParameter("name");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String role = req.getParameter("role");

        user.setName(name);
        user.setUserName(username);
        user.setPassword(password);
        user.setRole(role);

        storage.updateById(user);
        resp.sendRedirect("/pages/settings.jsp");
       }
    }
}