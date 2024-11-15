import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String userType = request.getParameter("userType");
        String userId = request.getParameter("userId");
        String password = request.getParameter("password");

        String redirectPage = null; // Initialize with a null value

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital", "root", "");

            // Check if the user is a patient
            if ("Patient".equals(userType)) {
                String query = "SELECT * from patient where id = ? AND Password = ?";
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                preparedStatement.setString(1, userId);
                preparedStatement.setString(2, password);

                ResultSet resultSet = preparedStatement.executeQuery();

                if (resultSet.next()) {
                    redirectPage = "PatientDashboard"; // Redirect to patient dashboard
                }

                resultSet.close();
                preparedStatement.close();
            }
            
            // Check if the user is a doctor
            else if ("Doctor".equals(userType)) {
                String query = "SELECT * from doctor where id = ? AND Password = ?";
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                preparedStatement.setString(1, userId);
                preparedStatement.setString(2, password);
                

                ResultSet resultSet = preparedStatement.executeQuery();

                if (resultSet.next()) {
                    redirectPage = "DoctorDashboard"; // Redirect to doctor dashboard
                }

                resultSet.close();
                preparedStatement.close();
            }

            connection.close();
            
            if (redirectPage != null) {
                response.sendRedirect(request.getContextPath() + "/" + redirectPage);
            } else {
                response.sendRedirect(request.getContextPath() + "/errorPage.jsp");
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            response.sendRedirect(request.getContextPath() + "/errorPage.jsp");
        }
    }
}
