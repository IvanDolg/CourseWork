package servlet;

import config.JdbcConnection;
import domain.User;
import services.UserService;

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
    private final String UPDATE_USER_DATA = "UPDATE \"greeting\" SET name = ?, username = ?, password = ?, role = ?\n" +
                                            "WHERE id = ?";
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       if (req.getSession().getAttribute("currentUser") == null){
            resp.sendRedirect(req.getContextPath() + "/pages/login.jsp");
        } else {
           getServletContext().getRequestDispatcher("/pages/settings.jsp").forward(req, resp);
       }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        User currentUser = (User) req.getSession().getAttribute("currentUser");
        String name = req.getParameter("name");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String role = req.getParameter("role");

        currentUser.setName(name);
        currentUser.setUserName(username);
        currentUser.setPassword(password);
        currentUser.setRole(role);


        if (req.getSession().getAttribute("currentUser") == null){
            resp.sendRedirect(req.getContextPath() + "/pages/login.jsp");
        } else {
           try(Connection connection = JdbcConnection.getConnection();
               PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USER_DATA)) {

               preparedStatement.setString(1, currentUser.getName());
               preparedStatement.setString(2, currentUser.getUserName());
               preparedStatement.setString(3, currentUser.getPassword());
               preparedStatement.setString(4, currentUser.getRole());
               preparedStatement.setInt(5, currentUser.getId());

               int rowsAffected = preparedStatement.executeUpdate();

               if (rowsAffected > 0) {
                   resp.sendRedirect(req.getContextPath() + "/pages/settings.jsp");
               } else {
                   resp.sendRedirect(req.getContextPath() + "/pages/error.jsp");
               }
           } catch (SQLException e) {
               throw new RuntimeException(e);
           }
       }
    }
}