
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %> 
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Appointment Form</title>
    </head>
    <body>
     
        <h1>Appointment Form</h1>

        <form action="AppointmentCheck" method="post">
            Doctor ID: <input type="text" name="doctorId" ><br>
            Patient ID :  <input type="text" name="patientID"><br>
            Patient Name: <input type="text" name="patientName"><br>
            Appointment Date: <input type="text" name="appointmentDate"><br>
            Appointment Time : <input type="text" name="appointmentTime"><br>
            
            <input type="submit" value="Submit Appointment">
        </form>
    </body>
</html>
