import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Dentist {
    public String firstName, lastName, telNo, email, exerciseLicense, universityAttended, infirmaryLocation, timeOfExperience, password, dentistID;
    public HashMap<String, String> credentials = new HashMap();
    public ArrayList<String> appointmentList = new ArrayList<>();

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
        return dentist.credentials;
    }

    /**
     * This method is called whenever a dentist wants to view the past visit history of a particular client who's given as a parameter.
     *
     * @param AMKA This indicates the AMKA of the client for whom the dentist wants to view the past visits' history.
     */
    public void viewVisitHistory(String AMKA) {
        System.out.println();
    }

    /**
     * This method allows the dentist to create a new tab for a specific patient using his AMKA number as a guide.
     *
     * @param AMKA This indicates the AMKA of the client for whom the dentist wants to create a tab for future use.
     */
    public void createPatientCard(String AMKA) {

    }

    public ArrayList<String> viewAppointmentList() {
        return appointmentList;
    }

    /**
     * The following methods allow modifications for one particular dentist attribute and replace the current value
     * with the one given as a parameter.
     *
     * @param data The new value of the attribute.
     */
    public void setFirstName(String data) {
        this.firstName = data;
    }

    public void setLastName(String data) {
        this.lastName = data;
    }

    public void setTelNo(String data) {
        this.telNo = data;
    }

    public void setEmail(String data) {
        this.email = data;
    }

    public void setExerciseLicense(String data) {
        this.exerciseLicense = data;
    }

    public void setUniversityAttended(String data) {
        this.universityAttended = data;
    }

    public void setInfirmaryLocation(String data) {
        this.infirmaryLocation = data;
    }

    public void setTimeOfExperience(String data) {
        this.timeOfExperience = data;
    }

    public void setPassword(String data) {
        this.password = data;
    }

    public void modifyData() {
        Scanner in = new Scanner(System.in);
        System.out.println("1. Change first name\n2. Change last name\n3.Change telephone number\n" +
                "4. Change e-mail address\n5. Change exercise license details\n6. Change university of studies\n" +
                "7. Change infirmary location\n8. Change work experience time\n9. Change Password\n");
        int choice = in.nextInt();
        while(choice<1 || choice > 9) {
            System.out.println("Invalid input, please choose a value between 1 and 9: ");
            in.nextInt();
        }
        switch (choice) {
            case 1:
                this.setFirstName(in.nextLine());
                break;
            case 2:
                this.setLastName(in.nextLine());
                break;
            case 3:
                this.setTelNo(in.nextLine());
                break;
            case 4:
                this.setEmail(in.nextLine());
                break;
            case 5:
                this.setExerciseLicense(in.nextLine());
                break;
            case 6:
                this.setUniversityAttended(in.nextLine());
                break;
            case 7:
                this.setInfirmaryLocation(in.nextLine());
                break;
            case 8:
                this.setTimeOfExperience(in.nextLine());
                break;
            case 9:
                this.setPassword(in.nextLine());
                break;
            default:
                break;
        }
    }
}