package servlet;

import entity.User;
import services.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/findUser")
public class FindUserServlet extends HttpServlet {
    private final UserService userService = UserService.getInstance();

/*    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getParameter("find")

        List<User> findUser = userService.getUserByName(name);
        req.setAttribute("listPerson",distListUser);
        doGet(req,resp);
    }*/
}
