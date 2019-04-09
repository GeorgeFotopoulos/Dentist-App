public class Dentist {
    private String firstName, lastName, telNo, email, exerciseLicense, universityAttended, infirmaryLocation, timeOfExperience, password, dentistID;

    public Dentist(String firstName, String lastName, String telNo, String email, String exerciseLicense, String universityAttended, String infirmaryLocation, String timeOfExperience, String password, String dentistID) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.telNo = telNo;
        this.email = email;
        this.exerciseLicense = exerciseLicense;
        this.universityAttended = universityAttended;
        this.infirmaryLocation = infirmaryLocation;
        this.timeOfExperience = timeOfExperience;
        this.password = password;
        this.dentistID = dentistID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTelNo() {
        return telNo;
    }

    public void setTelNo(String telNo) {
        this.telNo = telNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getExerciseLicense() {
        return exerciseLicense;
    }

    public void setExerciseLicense(String exerciseLicense) {
        this.exerciseLicense = exerciseLicense;
    }

    public String getUniversityAttended() {
        return universityAttended;
    }

    public void setUniversityAttended(String universityAttended) {
        this.universityAttended = universityAttended;
    }

    public String getInfirmaryLocation() {
        return infirmaryLocation;
    }

    public void setInfirmaryLocation(String infirmaryLocation) {
        this.infirmaryLocation = infirmaryLocation;
    }

    public String getTimeOfExperience() {
        return timeOfExperience;
    }

    public void setTimeOfExperience(String timeOfExperience) {
        this.timeOfExperience = timeOfExperience;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDentistID() {
        return dentistID;
    }

    public void setDentistID(String dentistID) {
        this.dentistID = dentistID;
    }
}