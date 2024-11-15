import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/PatientDashboard")
public class PatientDashboard extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<doctor> doctor = new ArrayList<>();

        // Database connection and query
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital", "root", "");
            String query = "SELECT id, name, speciality FROM doctor";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String doctorId = resultSet.getString("id");
                String doctorName = resultSet.getString("name");
                String speciality = resultSet.getString("speciality");
                doctor.add(new doctor(doctorId, doctorName, speciality));
            }

            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            // Handle database connection errors
        }

        request.setAttribute("doctor", doctor);
        request.getRequestDispatcher("/patientDashboard.jsp").forward(request, response);
    }
}
