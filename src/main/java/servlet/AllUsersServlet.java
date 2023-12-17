package servlet;

import entity.User;
import services.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Base64;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@WebServlet("/allUsers")
public class AllUsersServlet extends HttpServlet {
    private final UserService userService = UserService.getInstance();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User> userList = userService.getAllUsers();
            req.setAttribute("userList", userList);
            getServletContext().getRequestDispatcher("/pages/allUserAdmin.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = req.getParameter("findname");
        Optional<User> optionalUser = userService.getUserByName(name);

        List<User> userList = optionalUser.map(Collections::singletonList).orElse(Collections.emptyList());
        req.setAttribute("userList", userList);

        String action = req.getParameter("action");

        if ("saveToFile".equals(action)) {
            List<User> userList1 = userService.getAllUsers();
            // Логика сохранения userList в файл

            // Пример сохранения в текстовый файл
            try (PrintWriter writer = new PrintWriter("userList.txt")) {
                for (User user : userList1) {
                    writer.println(user.toString());
                }
            }
            doGet(req,resp);
        }
        getServletContext().getRequestDispatcher("/pages/findUser.jsp").forward(req, resp);
    }
}
