<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %> 
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Doctor Dashboard</title>
    </head>
    <body>
        <h1>Welcome, Doctor!</h1>
        <h2>Your Appointments:</h2>
        <table>
            <thead>
                <tr>
                    <th>Patient ID</th>
                    <th>Patient Name</th>
                    <th>Appointment Date</th>
                    <th>Appointment Time</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${appointment}" var="appointment">
                    <tr>
                        <td>${appointment.Pid}</td>
                        <td>${appointment.name}</td>
                        <td>${appointment.date}</td> 
                        <td>${appointment.time}</td> 
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>
