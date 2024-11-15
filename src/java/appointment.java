public class appointment {

    private String Pid;
    private String time; // Changed from "appointmentTime" to "time"
    private String date; // Changed from "appointmentDate" to "date"
    private String name;

    public appointment(String Pid, String time, String date, String name) {
        this.Pid = Pid;
        this.time = time;
        this.date = date;
        this.name = name;
    }

    public String getPid() {
        return Pid;
    }

    public void setPid(String Pid) {
        this.Pid = Pid;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
