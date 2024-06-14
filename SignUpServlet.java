// SignUpServlet.java
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SignUpServlet")
public class SignUpServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Retrieve user details from the form
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        // Create a User object
        User user = new User(username, email, password);

        // Create a UserDatabase object
        UserDatabase userDatabase = new UserDatabase("users.dat");

        // Add the user to the database
        userDatabase.addUser(user);

        // Redirect to a success page or login page
        response.sendRedirect("signup-success.html");
    }
}
