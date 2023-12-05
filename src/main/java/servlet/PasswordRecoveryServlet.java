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
    private final UserService userService = UserService.getInstance();
    private String userName;
    private String name;
    private String surname;
    private String email;
    private String password;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/pages/passwordRecovery.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
/*        String emailAddress = req.getParameter("email");


        Optional<User> getUser = userService.getUserByEmail(emailAddress);

        if (getUser.isPresent()){
            User user = getUser.get();

            if (user.getEmail().equals(emailAddress)){
               name = user.getName();
               surname = user.getSurname();
               userName = user.getUserName();
               email = user.getEmail();
               password = user.getPassword();
               req.getSession().setAttribute("user", user);
           } else  getServletContext().getRequestDispatcher("/pages/passwordRecovery.jsp").forward(req, resp);
       }*/

        Properties properties = new Properties();

        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", 465);
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");


        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("ivandolgolaptev@gmail.com", "gois zgqo btrk ufyi");
            }
        });

        session.setDebug(true);
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("ivandolgolaptev@gmail.com"));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress("ivandolgolaptev@gmail.com"));
            message.setSubject("Тема письма");
            message.setText("Сообщение в письме");

            Transport.send(message);
            System.out.println("Письмо успешно отправлено");
        } catch (MessagingException e) {
            System.out.println("Письмо не отправлено");
            e.printStackTrace();
        }
    }
}