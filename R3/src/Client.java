import java.util.HashMap;

public class Client {
    public HashMap<String, String> clientAppointment = new HashMap<>();
    public String firstName, lastName, address, telNo, email, AMKA;

    public Client(String firstName, String lastName, String address, String telNo, String email, String AMKA) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.telNo = telNo;
        this.email = email;
        this.AMKA = AMKA;
    }
}