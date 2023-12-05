package servlet;

import entity.User;
import services.UserService;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;
import java.util.Properties;

@WebServlet("/sendEmail")
public class PasswordRecoveryServlet extends HttpServlet {
    static final String SENDER_EMAIL_ADDRESS = "ivandolgolaptev@gmail.com";
    static final String SENDER_EMAIL_PASSWORD = "gois zgqo btrk ufyi";
    static final String SENDER_HOST = "smtp.gmail.com";
    static final String SENDER_PORT = "465";

    private final UserService userService = UserService.getInstance();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/pages/passwordRecovery.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String emailAddress = req.getParameter("email");
        Optional<User> getUser = userService.getUserByEmail(emailAddress);

        if (getUser.isPresent()){
            User user = getUser.get();

            if (user.getEmail().equals(emailAddress)){
               String name = user.getName();
                String surname = user.getSurname();
                String userName = user.getUserName();
                String email = user.getEmail();
                String password = user.getPassword();

                Properties properties = new Properties();

                properties.put("mail.smtp.host", SENDER_HOST);
                properties.put("mail.smtp.port", SENDER_PORT);
                properties.put("mail.smtp.ssl.enable", "true");
                properties.put("mail.smtp.auth", "true");


                Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(SENDER_EMAIL_ADDRESS, SENDER_EMAIL_PASSWORD);
                    }
                });

                session.setDebug(true);
                try {
                    Message message = new MimeMessage(session);
                    message.setFrom(new InternetAddress(SENDER_EMAIL_ADDRESS));
                    message.setRecipient(Message.RecipientType.TO, new InternetAddress(emailAddress));
                    message.setSubject("Данные для входа в свою учетную запись");
                    message.setText("Имя:" + name + "\n" +
                            "Фамилия: " + surname + "\n" +
                            "Имя пользователя: " + userName + "\n" +
                            "Почта: " + email + "\n" +
                            "Пароль: " + password);

                    Transport.send(message);

                    resp.sendRedirect("/pages/login.jsp");
                } catch (MessagingException e) {
                    e.printStackTrace();
                }
           } else  getServletContext().getRequestDispatcher("/pages/passwordRecovery.jsp").forward(req, resp);
       }
    }
}