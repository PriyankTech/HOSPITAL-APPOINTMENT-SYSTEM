public class doctor {
    private String id;
    private String name;
    private String speciality;

    public doctor(String id, String name, String speciality) {
        this.id = id;
        this.name = name;
        this.speciality = speciality;
    }

    // Getters and setters (if needed)

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getspeciality() {
        return speciality;
    }

    public void setspeciality(String speciality) {
        this.speciality = speciality;
    }
}
