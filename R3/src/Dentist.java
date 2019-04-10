import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Dentist {
    static ArrayList<Dentist> dentists = new ArrayList<Dentist>();
    static int ID = 15139;
    public String firstName, lastName, telNo, email, exerciseLicense, universityAttended, infirmaryLocation, timeOfExperience, password, dentistID;
    public HashMap<String, String> credentials = new HashMap<>();
    public HashMap<String, String> statistics = new HashMap<>();
    public ArrayList<String> appointmentList = new ArrayList<>();
    static public boolean logIn;

    public Dentist() {
        this.dentistID = ID + "";
        ID++;
        dentists.add(this);
    }

    public Dentist(String firstName, String lastName, String telNo, String email, String exerciseLicense, String universityAttended, String infirmaryLocation, String timeOfExperience, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.telNo = telNo;
        this.email = email;
        this.exerciseLicense = exerciseLicense;
        this.universityAttended = universityAttended;
        this.infirmaryLocation = infirmaryLocation;
        this.timeOfExperience = timeOfExperience;
        this.password = password;
        this.dentistID = ID + "";
        ID++;
        dentists.add(this);

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

    /**
     * This method is used by a particular dentist so that he can have access to all the current requests for appointments by the clients.
     *
     * @return Appointment list for the dentist that called the method.
     */
    public ArrayList<String> viewAppointmentList() {
        return appointmentList;
    }


    public static Dentist logIn(String email, String password) {
        for(int i=0; i< dentists.size(); i++) {
            if (dentists.get(i).email.equalsIgnoreCase(email) && dentists.get(i).password.equals(password)) {
                return dentists.get(i);
            }
        }
        return null;
    }

    /**
     * This method is called by the dentist whenever he wants to view all of the statistics of all the services he/she has provided.
     */
    public void viewAllStatistics() {
        for (String key : this.statistics.keySet()) {
            System.out.println(this.statistics.get(key));
        }
    }

    /**
     * This method is called by the dentist whenever he wants to view a particular one of the statistics of all the services he/she has provided.
     */
    public void viewSpecificStatistics(String service) {
        for (String key : this.statistics.keySet()) {
            System.out.println(this.statistics.get(key).equals(service));
        }
    }

    /**
     * This method modifies the current firstName attribute and sets a new one, the one given as a parameter.
     *
     * @param newData The new value of the attribute.
     */
    public void setFirstName(String newData) {
        this.firstName = newData;
    }

    /**
     * This method modifies the current lastName attribute and sets a new one, the one given as a parameter.
     *
     * @param newData The new value of the attribute.
     */
    public void setLastName(String newData) {
        this.lastName = newData;
    }

    /**
     * This method modifies the current telNo attribute and sets a new one, the one given as a parameter.
     *
     * @param newData The new value of the attribute.
     */
    public void setTelNo(String newData) {
        this.telNo = newData;
    }

    /**
     * This method modifies the current email attribute and sets a new one, the one given as a parameter.
     *
     * @param newData The new value of the attribute.
     */
    public void setEmail(String newData) {
        this.email = newData;
    }

    /**
     * This method modifies the current exerciseLicense attribute and sets a new one, the one given as a parameter.
     *
     * @param newData The new value of the attribute.
     */
    public void setExerciseLicense(String newData) {
        this.exerciseLicense = newData;
    }

    /**
     * This method modifies the current universityAttended attribute and sets a new one, the one given as a parameter.
     *
     * @param newData The new value of the attribute.
     */
    public void setUniversityAttended(String newData) {
        this.universityAttended = newData;
    }

    /**
     * This method modifies the current infirmaryLocation attribute and sets a new one, the one given as a parameter.
     *
     * @param newData The new value of the attribute.
     */
    public void setInfirmaryLocation(String newData) {
        this.infirmaryLocation = newData;
    }

    /**
     * This method modifies the current timeOfExperience attribute and sets a new one, the one given as a parameter.
     *
     * @param newData The new value of the attribute.
     */
    public void setTimeOfExperience(String newData) {
        this.timeOfExperience = newData;
    }

    /**
     * This method modifies the current password attribute and sets a new one, the one given as a parameter.
     *
     * @param newData The new value of the attribute.
     */
    public void setPassword(String newData) {
        this.password = newData;
    }

    /**
     * This method is used to print all the non-sensitive dentist data on the screen.
     */
    public void printDentistData() {
        System.out.println("ID: " + this.dentistID);
        System.out.println("First name: " + this.firstName);
        System.out.println("Last name: " + this.lastName);
        System.out.println("Telephone number:" + this.telNo);
        System.out.println("E-mail: " + this.email);
        System.out.println("Exercise License: " + this.exerciseLicense);
        System.out.println("University of studies:" + this.universityAttended);
        System.out.println("Infirmary location:" + this.infirmaryLocation);
        System.out.println("Work experience time:" + this.timeOfExperience);
        System.out.println("---------------------------------");
    }

    /**
     * The following method allows modifications for one particular dentist attribute and replace the current value
     * with the one given as an input.
     */
    public void modifyData() {
        Scanner in = new Scanner(System.in);
        System.out.println("1. Change first name\n2. Change last name\n3.Change telephone number\n" +
                "4. Change e-mail address\n5. Change exercise license details\n6. Change university of studies\n" +
                "7. Change infirmary location\n8. Change work experience time\n9. Change Password\n");
        int choice = in.nextInt();
        while (choice < 1 || choice > 9) {
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