import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;

public class Dentist {
    private static ArrayList<Dentist> dentists = new ArrayList<>();
    static int ID = 15139;
    private String password;
    public String firstName, lastName, telNo, email, exerciseLicense, universityAttended, infirmaryLocation, timeOfExperience;
    public int dentistID;
    public HashMap<String, String> credentials = new HashMap<>();
    public HashMap<String, String> statistics = new HashMap<>();
    public HashMap<String, ArrayList<Appointment>> appointmentList = new HashMap<>();

    /**
     * Default constructor.
     */
    public Dentist() {
        this.dentistID = ID++;
        dentists.add(this);
    }

    /**
     * Constructor with parameters for each field of data.
     *
     * @param firstName          Dentist's first name.
     * @param lastName           Dentist's last name.
     * @param telNo              Dentist's telephone number.
     * @param email              Dentist's e-mail address, used for the login.
     * @param exerciseLicense    Dentist's exercise license number.
     * @param universityAttended Dentist's university of attendance.
     * @param infirmaryLocation  Dentist's infirmary location.
     * @param timeOfExperience   Dentist's time of experience.
     * @param password           Dentist's password, used for the login.
     */
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
        this.dentistID = ID++;
        dentists.add(this);
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

    public void viewAppointmentRequests() {
        ArrayList<String> toBeRemoved = new ArrayList<String>();
        Scanner in = new Scanner(System.in);
        String choice;
        System.out.println("Appointments Waiting to be Approved!!");
        for (String key : this.appointmentList.keySet()) {
            for (int i = 0; i < this.appointmentList.get(key).size(); i++) {
                if (!this.appointmentList.get(key).get(i).accepted) {
                    System.out.println();
                    System.out.println("Client's Name: " + this.appointmentList.get(key).get(i).clientName);
                    System.out.println("Time: " + this.appointmentList.get(key).get(i).time + ":00");
                    System.out.println("Date: " + key);
                    System.out.println();
                    System.out.println("Press 1 to accept the appointment ,2 to decline it, or anything else to review later!");
                    choice = in.nextLine();
                    if (choice.equals("1")) {
                        this.appointmentList.get(key).get(i).accepted = true;
                        System.out.println("Appointment Approved Successfully!");
                    } else if (choice.equals("2")) {
                        this.appointmentList.get(key).remove(i);
                        i--;
                        if (this.appointmentList.get(key).isEmpty()) {
                            System.out.println("Appointment Removed Successfully!");
                            toBeRemoved.add(key);
                            break;
                        }
                    }
                }
            }
        }
        if (!toBeRemoved.isEmpty()) {
            for (int i = 0; i < toBeRemoved.size(); i++) {
                this.appointmentList.remove(toBeRemoved.get(i));
            }
        }
    }

    public void viewApprovedAppointments() {
        int OK = 0;
        int OKAY = 0;
        System.out.println();
        for (String key : this.appointmentList.keySet()) {

            OK = 0;
            if (!this.appointmentList.get(key).isEmpty()) {
                for (int i = 0; i < this.appointmentList.get(key).size(); i++) {
                    if (this.appointmentList.get(key).get(i).accepted) {
                        OK++;
                        OKAY++;
                        if (OKAY == 1) {
                            System.out.println("APPROVED...");
                        }
                        if (OK == 1) {
                            System.out.println();
                            System.out.println("Appointments of the Day: " + key);
                        }
                        System.out.println("Client's Name: " + this.appointmentList.get(key).get(i).clientName);
                        System.out.println("Time: " + this.appointmentList.get(key).get(i).time + ":00");

                    }
                }
            } else {
                System.out.println("No appointments!");
            }
        }

        OKAY = 0;
        System.out.println();

        for (String key : this.appointmentList.keySet()) {
            OK = 0;
            if (!this.appointmentList.get(key).isEmpty()) {

                for (int i = 0; i < this.appointmentList.get(key).size(); i++) {
                    if (!this.appointmentList.get(key).get(i).accepted) {
                        OK++;
                        OKAY++;
                        if (OKAY == 1) {
                            System.out.println("PENDING...");
                        }
                        if (OK == 1) {
                            System.out.println();
                            System.out.println("Appointments of the Day: " + key);
                        }
                        System.out.println("Client's Name: " + this.appointmentList.get(key).get(i).clientName);
                        System.out.println("Time: " + this.appointmentList.get(key).get(i).time + ":00");
                    }
                }
            } else {
                System.out.println("No appointments!");
            }
        }

    }

    /**
     * This method takes an email and a password as parameters and checks if they match any dentist's email and password.
     *
     * @param email    The email given as an input from the user.
     * @param password The password given as an input from the user.
     * @return Returns the dentist who matches the email and password given as input.
     */
    public static Dentist logIn(String email, String password) {
        for (int i = 0; i < dentists.size(); i++) {
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
    } // TODO;

    /**
     * This method is called by the dentist whenever he wants to view a particular one of the statistics of all the services he/she has provided.
     */
    public void viewSpecificStatistics(String service) {
        for (String key : this.statistics.keySet()) {
            System.out.println(this.statistics.get(key).equals(service));
        }
    } // TODO;

    /**
     * This method prints all dentists' data.
     */
    public static void seeListOfDentists() {
        for (int i = 0; i < Dentist.dentists.size(); i++) {
            dentists.get(i).printDentistData();
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
        System.out.println("Telephone number: " + this.telNo);
        System.out.println("E-mail: " + this.email);
        System.out.println("Exercise License: " + this.exerciseLicense);
        System.out.println("University of studies: " + this.universityAttended);
        System.out.println("Infirmary location: " + this.infirmaryLocation);
        System.out.println("Work experience time: " + this.timeOfExperience);
        System.out.println("---------------------------------");
    }

    /**
     * The following method allows modifications for one particular dentist attribute and replace the current value
     * with the one given as an input.
     */
    public void modifyData() {
        String newPassword, temp;
        int choice = -1;
        Scanner in = new Scanner(System.in);
        System.out.println("0. Exit\n1. Change first name\n2. Change last name\n3. Change telephone number\n" +
                "4. Change e-mail address\n5. Change exercise license details\n6. Change university of studies\n" +
                "7. Change infirmary location\n8. Change work experience time\n9. Change Password\n");
        try {
            choice = Integer.parseInt(in.nextLine());
        } catch (Exception e) {
            modifyData();
        }
        while (choice < 0 || choice > 9) {
            System.out.println("Invalid input, please choose a value between 1 and 9: ");
            in.nextInt();
        }

        switch (choice) {
            case 0:
                System.out.println("Exiting...");
                break;
            case 1:
                System.out.println("Enter new name: ");
                this.setFirstName(in.nextLine());
                break;
            case 2:
                System.out.println("Enter new surname: ");
                this.setLastName(in.nextLine());
                break;
            case 3:
                System.out.println("Enter new telephone number: ");
                this.setTelNo(in.nextLine());
                break;
            case 4:
                System.out.println("Enter new email address: ");
                this.setEmail(in.nextLine());
                break;
            case 5:
                System.out.println("Enter new exercise license number: ");
                this.setExerciseLicense(in.nextLine());
                break;
            case 6:
                System.out.println("Enter new value for university of attendance: ");
                this.setUniversityAttended(in.nextLine());
                break;
            case 7:
                System.out.println("Enter new location of infirmary: ");
                this.setInfirmaryLocation(in.nextLine());
                break;
            case 8:
                System.out.println("Enter new value for time of experience: ");
                this.setTimeOfExperience(in.nextLine());
                break;
            case 9:
                while (true) {
                    do {
                        try {
                            System.out.println("Enter password (At least 8 characters): ");
                            newPassword = in.nextLine();
                        } catch (Exception e) {
                            newPassword = 0 + "";
                        }
                    } while (newPassword.length() < 8);
                    temp = newPassword;
                    do {
                        if (!newPassword.equals(temp)) {
                            System.out.println("Passwords do not match!");
                            try {
                                System.out.println("Type \"back\" if you want to return to the modify data menu./Press anything else if you want to retype the password.\n");
                                newPassword = in.nextLine();
                            } catch (Exception e) {
                                newPassword = 0 + "";
                            }
                            if (newPassword.equalsIgnoreCase("back")) {
                                break;
                            }
                        }
                        try {
                            System.out.println("Re-enter password (At least 8 characters): ");
                            newPassword = in.nextLine();
                        } catch (Exception e) {
                            newPassword = 0 + "";
                        }

                    } while (!newPassword.equals(temp));
                    if (newPassword.equals(temp) || newPassword.equalsIgnoreCase("back")) break;
                }
                break;
            default:
                System.out.println("Not a valid choice, please choose between 0-9.");
                break;
        }
        if (choice != 0) {
            modifyData();
        }
        in.close();
    } // TODO elegxoi egkurothtas
}