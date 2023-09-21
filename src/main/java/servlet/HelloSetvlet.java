package servlet;

import domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@WebServlet(name = "HelloSetvlet", urlPatterns = "/")
public class HelloSetvlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User currentUser = (User) req.getSession().getAttribute("currentUser");
        if (currentUser != null){
            resp.getWriter().println("<h1>Hello "  + currentUser + " !!!</h1>");
        } else {
            resp.getWriter().println("<h1>Hello Guest !!!</h1>");
        }
        String myName = req.getParameter("name");
        String myFlag = req.getParameter("flag");

        List<String> strings = List.of("Test 1", "Test 2", "Test 3", "Test 4", "Test 5");

        req.setAttribute("users", strings);

        req.setAttribute("date", new Date());

        req.setAttribute("name", myName);
        req.setAttribute("flag", myFlag);

        getServletContext().getRequestDispatcher("/pages/home.jsp").forward(req, resp);
    }
}
