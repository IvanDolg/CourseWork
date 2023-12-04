package servlet;

import entity.User;
import services.UserService;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.Authenticator;
import java.net.PasswordAuthentication;
import java.util.Optional;
import java.util.Properties;

@WebServlet("/sendEmail")
public class PasswordRecoveryServlet extends HttpServlet {
    private final UserService userService = UserService.getInstance();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/pages/passwordRecovery.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String emailAddress = req.getParameter("emailAddress");

        Optional<User> getUser = userService.getUserByEmail(emailAddress);

        if (getUser.isPresent()){
            User user = getUser.get();
            if (user.getEmail().equals(emailAddress)){
                req.getSession().setAttribute("user", user);

                resp.sendRedirect("/pages/profile.jsp");
            }
        }

        String recipientEmail = req.getParameter("recipientEmail"); // Адрес получателя
        String subject = req.getParameter("subject"); // Тема письма
        String message = req.getParameter("message"); // Сообщение

        // Конфигурация JavaMail API
        String host = "smtp.example.com"; // SMTP-сервер для отправки писем
        String username = "your_username"; // Ваше имя пользователя для авторизации на SMTP-сервере
        String password = "your_password"; // Ваш пароль для авторизации на SMTP-сервере

        // Настройка свойств для подключения к SMTP-серверу
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", "587");

        /*// Создание сессии
        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            // Создание объекта сообщения
            Message emailMessage = new MimeMessage(session);

            // Установка параметров сообщения
            emailMessage.setFrom(new InternetAddress(username));
            emailMessage.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipientEmail));
            emailMessage.setSubject(subject);
            emailMessage.setText(message);

            // Отправка письма
            Transport.send(emailMessage);

            // Отправка ответа клиенту
            response.getWriter().println("Email sent successfully");
        } catch (MessagingException e) {
            // Обработка ошибки отправки письма
            response.getWriter().println("Failed to send email: " + e.getMessage());
        }*/
    }
}