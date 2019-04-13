import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Client {
    public static String firstName, lastName, address, telNo, email;
    public static HashMap<String, Client> clients = new HashMap<>();
    public static ArrayList<Services> visits = new ArrayList<>();

    /**
     * Client constructor.
     *
     * @param firstName Client's name.
     * @param lastName  Client's surname.
     * @param address   Client's home address.
     * @param telNo     Client's telephone number.
     * @param email     Client's email address.
     */
    public Client(String firstName, String lastName, String address, String telNo, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.telNo = telNo;
        this.email = email;
    }

    public static void viewClientHistory() {
        Scanner in = new Scanner(System.in);
        System.out.println("Give Client's AMKA: ");
        System.out.print("> ");
        String AM = in.next();
        if (clients.get(AM) != null) {
            System.out.println("Client's History: ");
            for (int i = 0; i < visits.size(); i++) {
                System.out.println(Client.clients.get(160198).visits.get(i));
            }
        } else {
            System.out.println("There's no Client in the system!! ");
        }
    }

    /**
     * This method includes the procedure the client follows in order to choose a dentist for his needs.
     *
     * @return The dentist with the most experience on a particular service, the client needs.
     */
    public static Dentist chooseDentist(int dent) {
        Dentist D = Dentist.dentists.get(dent);
        return D;
    }

    /**
     * This method is called by the client, after he has searched and decided which dentist he
     * wants to visit so that he can request an appointment.
     *
     * @param dentist The dentist that the client is interested for.
     */
    public static void requestAppointment(Dentist dentist, String name) {
        boolean flag = false;
        Scanner input = new Scanner(System.in);
        System.out.println("Enter desired date for the appointment: ");
        String date = input.nextLine();
        System.out.println("Enter desired time for the appointment: ");
        int time = Integer.parseInt(input.next());
        if (dentist.appointmentList.get(date) == null) {
            new Appointment(date, time, name, false, dentist);
            System.out.println("Appointment Successful.Waiting for approval!");
            System.out.println("Dr. " + dentist.lastName + " will contact you ASAP!");
        } else if (dentist.appointmentList.get(date) != null) {
            for (int i = 0; i < dentist.appointmentList.get(date).size(); i++) {
                if (dentist.appointmentList.get(date).get(i).time == time) {
                    System.out.println("Sorry man! No appointment fo you.Brush your teeth!!!! ");
                    flag = true;
                }
            }
            if (!flag) {
                new Appointment(date, time, name, false, dentist);
                System.out.println("Appointment Successful.Waiting for approval!");
                System.out.println("Dr. " + dentist.lastName + " will contact you ASAP!");
            }
        }
    }
}