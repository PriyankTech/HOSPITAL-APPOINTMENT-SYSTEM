
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AppointmentCheck")
public class AppointmentCheck extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        String patientName = request.getParameter("patientName");
        String patientID = request.getParameter("patientID");
        String doctorID = request.getParameter("doctorID");
        String appointmentDate = request.getParameter("appointmentDate");
        String appointmentTime = request.getParameter("appointmentTime");
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital", "root", "");
            String query ;

            
            query = "INSERT INTO appointment ( Did,Pid, name, date, time) VALUES (?, ?, ?, ?, ?)";

            if (query != null) {

                PreparedStatement preparedStatement = connection.prepareStatement(query);
                preparedStatement.setString(1, doctorID);
                preparedStatement.setString(2, patientID);
                preparedStatement.setString(3, patientName);
                preparedStatement.setString(4, appointmentDate);
                preparedStatement.setString(5, appointmentTime);

                preparedStatement.executeUpdate();

                preparedStatement.close();
                connection.close();

                /* if (rowsInserted > 0) {
                    response.sendRedirect("success.html");
                } else {
                    response.sendRedirect("errorPage.jsp");
                }*/
            } else {
                response.sendRedirect("errorPage.jsp");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("errorPage.jsp");
        }
    }

    // Helper method to check if a user is a patient
}
