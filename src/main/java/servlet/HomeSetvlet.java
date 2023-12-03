package servlet;

import entity.Exercises;
import services.ExercisesService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;
@WebServlet(urlPatterns = "/")
public class HomeSetvlet extends HttpServlet {
    private final ExercisesService exercisesService = ExercisesService.getInstance();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/pages/home.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String exerciseId = req.getParameter("exerciseId");

        if (exerciseId != null) {
            int id = Integer.parseInt(exerciseId);
            Optional<Exercises> optionalExercise = exercisesService.getUserById(id);

            if (optionalExercise.isPresent()) {
                Exercises exercise = optionalExercise.get();

                String description = exercise.getDescription();
                req.setAttribute("description", description);
                resp.sendRedirect("/pages/home.jsp");
            }
        }
    }
}
