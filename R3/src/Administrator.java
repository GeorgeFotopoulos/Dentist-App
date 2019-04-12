import java.util.ArrayList;

public class Administrator {
    public static ArrayList<String> services = new ArrayList<>();
    public static ArrayList<String> specializations = new ArrayList<>();
    private static String username, password;

    /**
     * Administrator constructor.
     *
     * @param username Admin's username.
     * @param password Admin's password.
     */
    public Administrator(String username, String password) {
        this.username = username;
        this.password = password;
    }

    /**
     * This method returns the admin's username.
     *
     * @return Administrator's username.
     */
    public static String getUsername() {
        return username;
    }

    /**
     * This method returns the admin's password.
     *
     * @return Administrator's password.
     */
    public static String getPassword() {
        return password;
    }

    /**
     * This method adds the service given as parameter to the list containing all the available services.
     *
     * @param service Service to be added in the list.
     */
    public static void addService(String service) {
        services.add(service);
    }

    /**
     * This method adds the specialization given as a parameter to the list containing all the available specializations.
     *
     * @param specialization Specialization to be added in the list.
     */
    public static void addSpecialization(String specialization) {
        specializations.add(specialization);
    }
}