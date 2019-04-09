import java.util.HashMap;

public class Dentist {
    public String firstName, lastName, telNo, email, exerciseLicense, universityAttended, infirmaryLocation, timeOfExperience, password, dentistID;
    public HashMap<String, String> credentials = new HashMap();

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

    /**
     * @param dentist The dentist who will be registered to the system.
     * @return The Hash Map containing that dentist's Username and Password.
     */
    public HashMap<String, String> register(Dentist dentist) {
        return credentials;
    }

    /**
     * This method is called whenever a dentist wants to view the past visit history of a particular client who's given as a parameter.
     *
     * @param AMKA This indicates the AMKA of the client for whom the dentist wants to view the past visits' history.
     */
    public void viewVisitHistory(String AMKA) {
        System.out.println();
    }

}