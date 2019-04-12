import java.util.Scanner;

public class Engine {
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        Dentist D1 = new Dentist("Giorhs", "Fotakis", "6988888883", "Fotakis23@gmail.com", "AK-47", "AUEB", "Artis 23", "6", "123456723");
        Dentist D2 = new Dentist("Tzortz", "Pat", "6987777883", "GpaokMono4@gmail.com", "M4A1", "Huawei", "Folegandrou 10", "1", "12341234");
        Dentist D3 = new Dentist("Takaros", "Gdimenos", "6981234563", "Rouxa80%Off@gmail.com", "Grenade", "Tipota", "Kalamatara", "20", "192837465");
        //printMenu();
        //D1.printDentistData();
        //D1.modifyData();
        //D1.printDentistData();
        Appointment A1 = new Appointment("18/05/1995", 18, "George Fotopoulos", true, D1);
        Appointment A2 = new Appointment("18/05/1995", 11, "Panagiotis Ntymenos", true, D1);
        Appointment A3 = new Appointment("18/05/1995", 13, "George Patrikis", true, D2);

        D1.viewAppointmentRequests();
        System.out.println("----------------------------------");
        D2.viewAppointmentRequests();

    }

    /**
     * This is the main menu of our application.
     */
    private static void printMenu() {
        System.out.println("1. Dentist Menu");
        System.out.println("2. Client Menu");
        int choice;
        do {
            try {
                System.out.println("Choose 1 for dentist menu or 2 for client menu: ");
                choice = Integer.parseInt(in.next());
            } catch (Exception e) {
                choice = 0;
            }
        } while (choice != 1 && choice != 2);
        if (choice == 1) {
            dentistSignIn();
        } else {
            clientMenu();
        }
    }

    /**
     * This method is used whenever a dentist wants to sign in his account or sign up for a new one.
     */
    private static void dentistSignIn() {
        System.out.println("Dentist Application");
        System.out.println("1. Sign Up");
        System.out.println("2. Log In");
        int choice;
        do {
            try {
                System.out.println("Type 1 for sign up or 2 f or log in: ");
                choice = Integer.parseInt(in.next());
            } catch (Exception e) {
                choice = 0;
                continue;
            }
        } while (choice != 1 && choice != 2);
        if (choice == 1) {
            createAccount();
        } else {
            dentistLogIn();
        }
    }

    /**
     * This method is called whenever a dentist wants to create a new account and is prompted to enter his data.
     */
    private static void createAccount() {
        Dentist newReg = new Dentist();
        String choice;
        do {
            try {
                System.out.println("Enter first name: ");
                choice = in.nextLine();
            } catch (Exception e) {
                choice = 0 + "";
            }
        } while (choice.length() < 2);
        newReg.setFirstName(choice);
        do {
            try {
                System.out.println("Enter last name: ");
                choice = in.nextLine();
            } catch (Exception e) {
                choice = 0 + "";
            }
        } while (choice.length() < 2);
        newReg.setLastName(choice);
        do {
            try {
                System.out.println("Enter telephone number: ");
                choice = in.nextLine();
            } catch (Exception e) {
                choice = 0 + "";
            }
        } while (choice.length() < 10);
        newReg.setTelNo(choice);
        do {
            try {
                System.out.println("Enter email address: ");
                choice = in.nextLine();
            } catch (Exception e) {
                choice = 0 + "";
            }
        } while (choice.length() < 5);
        newReg.setEmail(choice);
        do {
            try {
                System.out.println("Enter exercise license number: ");
                choice = in.nextLine();
            } catch (Exception e) {
                choice = 0 + "";
            }
        } while (choice.length() < 5);
        newReg.setExerciseLicense(choice);
        do {
            try {
                System.out.println("Enter university of studies: ");
                choice = in.nextLine();
            } catch (Exception e) {
                choice = 0 + "";
            }
        } while (choice.length() < 5);
        newReg.setUniversityAttended(choice);
        do {
            try {
                System.out.println("Enter infirmary location: ");
                choice = in.nextLine();
            } catch (Exception e) {
                choice = 0 + "";
            }
        } while (choice.length() < 5);
        newReg.setInfirmaryLocation(choice);
        do {
            try {
                System.out.println("Enter time of experience: ");
                choice = in.nextLine();
            } catch (Exception e) {
                choice = 0 + "";
            }
        } while (choice.length() < 5);
        newReg.setTimeOfExperience(choice);
        String tempPassword;
        while (true) {
            do {
                try {
                    System.out.println("Enter password (At least 8 characters): ");
                    choice = in.nextLine();
                } catch (Exception e) {
                    choice = 0 + "";
                }
            } while (choice.length() < 8);
            tempPassword = choice;
            do {
                if (!choice.equals(tempPassword)) {
                    System.out.println("Passwords do not match!");
                    try {
                        System.out.println("Type \"back\" if you want to return to the main menu./Press anything else if you want to retype the password.\n");
                        choice = in.nextLine();
                    } catch (Exception e) {
                        choice = 0 + "";
                    }
                    if (choice.equalsIgnoreCase("back")) {
                        break;
                    }
                }
                try {
                    System.out.println("Re-enter password (At least 8 characters): ");
                    choice = in.nextLine();
                } catch (Exception e) {
                    choice = 0 + "";
                }

            } while (!choice.equals(tempPassword));
            if (choice.equals(tempPassword)) break;
        }
        newReg.setPassword(tempPassword);
    }

    /**
     * This method prompts the user to enter his/her email and password in order to log in the system.
     *
     * @return Returns the dentist that was logged in the system using his/her credentials.
     */
    private static Dentist dentistLogIn() {
        Scanner in = new Scanner(System.in);
        String email, password;
        System.out.println("Enter your e-mail address: ");
        email = in.nextLine();
        System.out.println("Enter your password: ");
        password = in.nextLine();
        Dentist D = Dentist.logIn(email, password);
        if (D == null) {
            System.out.println("The e-mail or password you entered was invalid. Please try again!");
            dentistLogIn();
        } else {
            System.out.println("Login successful!");
        }
        return D;
    }

    public void viewAppointmentSchedule() {

    }

    /**
     * This is the client menu.
     */
    private static void clientMenu() {
    }
}