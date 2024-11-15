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

@WebServlet("/DoctorDashboard")
public class DoctorDashboard extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String doctorId = request.getParameter("userId"); // You can get the doctor's ID from the session or request parameters

        List<appointment> appointment = new ArrayList<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital", "root", "");
            String query = "SELECT Pid,name,date, time FROM appointment WHERE Did = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, doctorId);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
         
                String id = resultSet.getString("Pid");
                String pname = resultSet.getString("name");
                String pdate = resultSet.getString("date");
                String ptime = resultSet.getString("time");
                appointment.add(new appointment(id,ptime,pdate,pname));
            }

            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            // Handle database connection errors
        }

        request.setAttribute("appointment", appointment);
        request.getRequestDispatcher("/doctorDashboard.jsp").forward(request, response);
    }
}
