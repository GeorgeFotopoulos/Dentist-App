import java.util.ArrayList;

public class Client {
    public ArrayList<String> appointmentsRequested = new ArrayList<>();
    public ArrayList<String> servicesProvided = new ArrayList<>();
    public String firstName, lastName, address, telNo, email, AMKA;

    /**
     * Client constructor.
     *
     * @param firstName Client's name.
     * @param lastName  Client's surname.
     * @param address   Client's home address.
     * @param telNo     Client's telephone number.
     * @param email     Client's email address.
     * @param AMKA      Client's AMKA number.
     */
    public Client(String firstName, String lastName, String address, String telNo, String email, String AMKA) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.telNo = telNo;
        this.email = email;
        this.AMKA = AMKA;
    }

    /**
     * This method allows the client to search through the list of all available dentists.
     *
     * @return
     */
    public Dentist searchDentist() {
     return null;
     }

     /**
     * This method is called by the client, after he has searched and decided which dentist he
     * wants to visit so that he can request an appointment.
     *
     * @param dentist The dentist that the client is interested for.
     */
    public void requestAppointment(Dentist dentist) {
    }
}