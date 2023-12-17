package servlet;

import services.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/persondata/delete")
public class DeletePersonServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final UserService userService = UserService.getInstance();
        int id_deletePerson;
        id_deletePerson= Integer.parseInt(req.getParameter("id"));

        userService.deleteHuman(id_deletePerson);
        resp.sendRedirect("/allUsers");
    }

}