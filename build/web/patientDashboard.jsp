
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %> 
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Patient Dashboard</title>
    </head>
    <body>
        <h1>Welcome, Patient!</h1>
        <h2>Available Doctors:</h2>
        <table>
            <thead>
                <tr>
                    <th>Doctor ID</th>
                    <th>Doctor Name</th>
                    <th>Specialization</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${doctor}" var="doctor">
                    <tr>
                        <td>${doctor.id}</td>
                        <td>${doctor.name}</td>
                        <td>${doctor.speciality}</td>
                        <td>
                            <form action="appointment.jsp" method="post">
                                <input type="submit" value="Schedule Appointment">
                            </form>

                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>
