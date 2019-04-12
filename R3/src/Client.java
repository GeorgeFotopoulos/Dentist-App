import java.util.ArrayList;
import java.util.Scanner;

public class Client {
    public ArrayList<Appointment> appointmentsRequested = new ArrayList<>();
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
     * This method includes the procedure the client follows in order to search and choose a dentist for his needs.
     *
     * @return The dentist the client chose.
     */
    public Dentist searchDentist() {
        Dentist d;
        Scanner input = new Scanner(System.in);
        String option;
        Dentist.printListOfDentists();
        System.out.println("Press \"back\" if you would like to quit searching for Dentist: ");
        option = input.next();
        if (option.equalsIgnoreCase("back")) {
            Engine.clientMenu();
        } else {
            d = chooseDentist();
            return d;
        }
        return null;
    }

    /**
     * This method includes the procedure the client follows in order to choose a dentist for his needs.
     *
     * @return The dentist the client chose.
     */
    public Dentist chooseDentist() {
        Dentist d;
        d = Dentist.dentists.get(0);
        return d;
    }

    /**
     * This method is called by the client, after he has searched and decided which dentist he
     * wants to visit so that he can request an appointment.
     *
     * @param dentist The dentist that the client is interested for.
     */
    public void requestAppointment(Dentist dentist) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter desired date for the appointment: ");
        String date = input.nextLine();
        System.out.println("Enter desired time for the appointment: ");
        int time = Integer.parseInt(input.next());
        String clientName = this.firstName + " " + this.lastName;
        this.appointmentsRequested.add(new Appointment(date, time, clientName, false, dentist));
    }
}