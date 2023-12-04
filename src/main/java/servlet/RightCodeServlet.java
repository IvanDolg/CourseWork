package servlet;

import entity.Exercises;
import services.ExercisesService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/rightCode")
public class RightCodeServlet extends HttpServlet {
    private final ExercisesService exercisesService = ExercisesService.getInstance();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String exerciseId = req.getParameter("exerciseId");

        if (exerciseId == null){
            Exercises optionalExercise = exercisesService.getUserById(1);
            String rightCode = optionalExercise.getRightCode();
            req.setAttribute("rightCode", rightCode);

        }
        if (exerciseId != null) {
            int id = Integer.parseInt(exerciseId);
            Exercises optionalExercise = exercisesService.getUserById(id);

                String rightCode = optionalExercise.getRightCode();
                req.setAttribute("rightCode", rightCode);
        }
        getServletContext().getRequestDispatcher("/pages/rightCode.jsp").forward(req, resp);
    }
}
