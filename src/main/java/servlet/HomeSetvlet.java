package servlet;

import entity.Exercises;
import services.ExercisesService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.beans.Statement;
import java.io.IOException;

@WebServlet("/")
public class HomeSetvlet extends HttpServlet {
    private final ExercisesService exercisesService = ExercisesService.getInstance();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String exerciseId = req.getParameter("exerciseId");

        if (exerciseId == null){
            Exercises optionalExercise = exercisesService.getUserById(1);

            String description = optionalExercise.getDescription();
            req.setAttribute("description", description);

            int number = optionalExercise.getId();
            req.setAttribute("number", number);

            int score = optionalExercise.getScores();
            req.setAttribute("score", score);
        }

        if (exerciseId != null) {
            int id = Integer.parseInt(exerciseId);
            Exercises optionalExercise = exercisesService.getUserById(id);

                String description = optionalExercise.getDescription();
                req.setAttribute("description", description);

                int number = optionalExercise.getId();
                req.setAttribute("number", number);

                int score = optionalExercise.getScores();
                req.setAttribute("score", score);

        }
        getServletContext().getRequestDispatcher("/pages/home.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String sqlScript = req.getParameter("sqlScript");
        String cleanScriptWithYourCode = sqlScript.replaceAll("\\s", "");

        String exerciseId = req.getParameter("exerciseId");

        if (exerciseId == null){
            Exercises optionalExercise = exercisesService.getUserById(1);

            String rightCode = optionalExercise.getRightCode();
            String cleanScriptWithRightCode = rightCode.replaceAll("\\s", "");

            if (cleanScriptWithRightCode.equalsIgnoreCase(cleanScriptWithYourCode)){
                req.setAttribute("rightCode", rightCode);
            } else if (!sqlScript.isEmpty()){
                req.setAttribute("wrongCode", sqlScript);
            }
        }

        if (exerciseId != null) {
            int id = Integer.parseInt(exerciseId);
            Exercises optionalExercise = exercisesService.getUserById(id);

            String rightCode = optionalExercise.getRightCode();
            String cleanScriptWithRightCode = rightCode.replaceAll("\\s", "");

            if (cleanScriptWithRightCode.equalsIgnoreCase(cleanScriptWithYourCode) && !sqlScript.isEmpty()){
                req.setAttribute("rightCode", rightCode);
            } else  if (!sqlScript.isEmpty()){
                req.setAttribute("wrongCode", sqlScript);
            }
        }

        doGet(req, resp);
        getServletContext().getRequestDispatcher("/pages/home.jsp").forward(req, resp);
    }
}
