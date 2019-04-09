import java.util.ArrayList;

public class Administrator {
    public ArrayList<String> services = new ArrayList<>();
    public ArrayList<String> specializations = new ArrayList<>();
    private String username, password;

    public Administrator(String username, String password) {
        this.username = username;
        this.password = password;
    }

    /**
     * This method adds the service given as parameter to the list containing all the available services.
     *
     * @param service Service to be added in the list.
     */
    public void addService(String service) {
        services.add(service);
    }

    /**
     * This method adds the specialization given as a parameter to the list containing all the available specializations.
     *
     * @param specialization Specialization to be added in the list.
     */
    public void addSpecialization(String specialization) {
        specializations.add(specialization);
    }
}