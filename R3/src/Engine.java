import java.util.Scanner;

public class Engine {
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        Dentist D1 = new Dentist("Giorhs", "Fotakis", "6988888883", "F", "AK-47", "AUEB", "Artis 23", "6", "f", "Endodontic");
        Dentist D2 = new Dentist("Tzortz", "Pat", "6987777883", "GpaokMono4@gmail.com", "M4A1", "Huawei", "Folegandrou 10", "1", "12341234", "Pedodontic");
        Dentist D3 = new Dentist("Takaros", "Gdimenos", "6981234563", "Rouxa80%Off@gmail.com", "Grenade", "Tipota", "Kalamatara", "20", "192837465", "Orthodontist");
        Appointment A1 = new Appointment("16/05/1995", 18, "George Fotopoulos", true, D1);
        Appointment A2 = new Appointment("18/05/1995", 11, "Panagiotis Ntymenos", true, D1);
        Appointment A3 = new Appointment("19/05/1995", 13, "George Patrikis", true, D2);
        Appointment A4 = new Appointment("16/05/1995", 12, "Tasos Zikapika", false, D1);
        Appointment A5 = new Appointment("19/05/1995", 9, "Stamatis Bongos", true, D3);
        Client C1 = new Client("Takis", "Makis", "Kapou magika", "2721066666", "Magas98@gmail.com");
        Services S1 = new Services("25/09/1998", "Filling", "");
        Services S2 = new Services("26/09/1998", "Teeth Whitening", "");
        Administrator admin = new Administrator("admin", "admin");

        Administrator.addService("Filling");
        Administrator.addService("Teeth Whitening");
        Administrator.addService("Dental Cleaning");
        Administrator.addSpecialization("Endodontic");
        Administrator.addSpecialization("Pedodontic");
        Administrator.addSpecialization("Orthodontist");
        Administrator.addSpecialization("Prosthodontist");
        C1.visits.add(S1);
        C1.visits.add(S2);
        Client.clients.put("160198", C1);
        D1.statistics.put("Filling", 4);
        D1.statistics.put("Dental Cleaning", 10);
        printMenu();
    }

    /**
     * This is the main menu of our application.
     */
    private static void printMenu() {
        System.out.println("MAIN MENU\n0. Exit\n1. Dentist Menu\n2. Client Menu");
        int choice = -1;
        do {
            try {
                System.out.print("Type 0 to exit the application, 1 to view the dentist menu or 2 to view the client menu:\n> ");
                choice = Integer.parseInt(in.next());
            } catch (Exception e) {
                printMenu();
            }
        } while (choice < 0 || choice > 2);
        if (choice == 1) {
            dentistMenu();
        } else if (choice == 2) {
            clientMenu();
        } else {
            System.out.println("Exiting application...");
            System.exit(0);
        }
    }

    /**
     * This method is used whenever a dentist wants to sign in his account or sign up for a new one.
     */
    private static void dentistMenu() {
        System.out.println("DENTIST MENU\n0. Exit\n1. Sign Up\n2. Sign In\n3. Main Menu");
        int choice = -1;
        do {
            try {
                System.out.print("Type 0 to exit the application, 1 to sign up, 2 to log in or 3 to return to Main Menu:\n> ");
                choice = Integer.parseInt(in.next());
            } catch (Exception e) {
                dentistMenu();
            }
        } while (choice < 0 || choice > 3);
        if (choice == 0) {
            System.out.println("Exiting application...");
            System.exit(0);
        } else if (choice == 1) {
            createAccount();
        } else if (choice == 2) {
            dentistLogIn();
        } else {
            printMenu();
        }
    }

    /**
     * This method is called whenever a dentist wants to create a new account and is prompted to enter his data.
     */
    private static void createAccount() {
        Dentist newReg = new Dentist();
        String choice;
        in.nextLine();
        do {
            try {
                System.out.print("Enter first name: ");
                choice = in.nextLine();
            } catch (Exception e) {
                choice = 0 + "";
            }
        } while (choice.length() < 2);
        newReg.setFirstName(choice);
        do {
            try {
                System.out.print("Enter last name: ");
                choice = in.nextLine();
            } catch (Exception e) {
                choice = 0 + "";
            }
        } while (choice.length() < 2);
        newReg.setLastName(choice);
        do {
            try {
                System.out.print("Enter telephone number: ");
                choice = in.nextLine();
            } catch (Exception e) {
                choice = 0 + "";
            }
        } while (choice.length() < 10);
        newReg.setTelNo(choice);
        do {
            try {
                System.out.print("Enter email address: ");
                choice = in.nextLine();
            } catch (Exception e) {
                choice = 0 + "";
            }
        } while (choice.length() < 5);
        newReg.setEmail(choice);
        do {
            try {
                System.out.print("Enter exercise license number: ");
                choice = in.nextLine();
            } catch (Exception e) {
                choice = 0 + "";
            }
        } while (choice.length() < 5);
        newReg.setExerciseLicense(choice);
        do {
            try {
                System.out.print("Enter university of studies: ");
                choice = in.nextLine();
            } catch (Exception e) {
                choice = 0 + "";
            }
        } while (choice.length() < 5);
        newReg.setUniversityAttended(choice);
        do {
            try {
                System.out.print("Enter infirmary location: ");
                choice = in.nextLine();
            } catch (Exception e) {
                choice = 0 + "";
            }
        } while (choice.length() < 5);
        newReg.setInfirmaryLocation(choice);
        do {
            try {
                System.out.print("Enter time of experience: ");
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
                    System.out.print("Enter password (At least 8 characters): ");
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
                        System.out.print("Type \"back\" if you want to return to the Main Menu. Press anything else if you want to retype the password.\n> ");
                        choice = in.nextLine();
                    } catch (Exception e) {
                        choice = 0 + "";
                    }
                    if (choice.equalsIgnoreCase("back")) {
                        dentistMenu();
                    }
                }
                try {
                    System.out.print("Re-enter password (At least 8 characters): ");
                    choice = in.nextLine();
                } catch (Exception e) {
                    choice = 0 + "";
                }
            } while (!choice.equals(tempPassword));
            break;
        }
        newReg.setPassword(tempPassword);
    }

    /**
     * This method prompts the user to enter his/her email and password in order to log in the system.
     */
    private static void dentistLogIn() {
        Scanner in = new Scanner(System.in);
        String email, password;
        int temp = -1;
        System.out.print("Enter your e-mail address:\n> ");
        email = in.nextLine();
        System.out.print("Enter your password:\n> ");
        password = in.nextLine();
        if (email.equalsIgnoreCase(Administrator.getUsername()) && password.equals(Administrator.getPassword())) {
            System.out.println("Master Login successful!");
            masterMenu();
        }
        Dentist D = Dentist.logIn(email, password);
        if (D == null) {
            System.out.println("The e-mail or password you entered was invalid.");
            do {
                try {
                    System.out.print("Type 0 to return to the Dentist Menu or 1 to try again:\n> ");
                    temp = Integer.parseInt(in.next());
                } catch (Exception e) {
                }
            } while (temp != 0 && temp != 1);
            if (temp == 0) {
                dentistMenu();
            } else {
                dentistLogIn();
            }
        } else {
            System.out.println("Login successful!");
            dentistOptions(D);
        }
    }

    /**
     * This is the administrator Menu.
     */
    private static void masterMenu() {
        Scanner in = new Scanner(System.in);
        String service, specialization;
        System.out.println("MASTER MENU\n0. Exit\n1. Add Service\n2. Add Specialization\n3. Log Out");
        int choice = -1;
        do {
            try {
                System.out.print("Type 0 to exit the application, 1 to add services, 2 to add specializations or 3 to log out:\n> ");
                choice = Integer.parseInt(in.next());
            } catch (Exception e) {
                masterMenu();
            }
        } while (choice < 0 || choice > 3);
        if (choice == 0) {
            System.out.println("Exiting application...");
            System.exit(0);
        } else if (choice == 1) {
            System.out.print("Enter service:\n> ");
            do {
                service = in.next();
                if (Administrator.services.contains(service)) {
                    System.out.print("This service already exists. Enter a new one or press 0 to go to the menu.\n> ");
                }
            } while (Administrator.services.contains(service) && !service.equals("0"));
            if (!service.equals("0")) {
                Administrator.addService(service);
            }
            masterMenu();
        } else if (choice == 2) {
            System.out.print("Enter specialization:\n> ");
            do {
                specialization = in.next();
                if (Administrator.specializations.contains(specialization)) {
                    System.out.print("This specialization already exists. Enter a new one or press 0 to go to the menu.\n> ");
                }
            } while (Administrator.specializations.contains(specialization) && !specialization.equals("0"));
            if (!specialization.equals("0")) {
                Administrator.addSpecialization(specialization);
            }
            masterMenu();
        } else {
            dentistMenu();
        }
    }

    /**
     * This is the dentist Menu.
     */
    public static void dentistOptions(Dentist D) {
        Scanner in = new Scanner(System.in);
        System.out.print("OPTIONS\n0. Exit\n1. View Profile\n2. Update Account\n3. View Client History\n" +
                "4. Appointment Management\n5. View Statistics\n6. View Schedule\n7. Record Provided Service\n8. Log Out\n> ");
        int choice = -1;
        try {
            choice = Integer.parseInt(in.next());
        } catch (Exception e) {
        }
        if (choice == 0) {
            System.out.println("Exiting application...");
            System.exit(0);
        } else if (choice == 1) {
            D.printDentistData();
            dentistOptions(D);
        } else if (choice == 2) {
            D.modifyData();
            dentistOptions(D);
        } else if (choice == 3) {
            Client.viewClientHistory();
            dentistOptions(D);
        } else if (choice == 4) {
            D.viewAppointmentRequests();
            dentistOptions(D);
        } else if (choice == 5) {
            D.findStatistics(true);
            dentistOptions(D);
        } else if (choice == 6) {
            D.viewApprovedAppointments();
            dentistOptions(D);
        } else if (choice == 7) {
            D.recordService();
            dentistOptions(D);
        } else if (choice == 8) {
            dentistMenu();
        } else {
            System.out.println("Wrong input, you have to choose between 0-7!");
            dentistOptions(D);
        }
    }

    /**
     * This is the client Menu.
     */
    public static void clientMenu() {
        Scanner in = new Scanner(System.in);
        System.out.print("CLIENT MENU\n0. Exit\n1. Make Appointment\n2. Main Menu\n> ");
        int choice;
        String name;
        choice = -1;
        try {
            choice = Integer.parseInt(in.next());
        } catch (Exception e) {
        }
        if (choice == 0) {
            System.out.println("Exiting application...");
            System.exit(0);
        } else if (choice == 1) {
            System.out.println("LIST OF DENTISTS");
            Dentist.printListOfDentists();
            System.out.print("Choose one of the dentists' ID above or press 0 to exit:\n> ");
            do {
                try {
                    choice = Integer.parseInt(in.next());
                } catch (Exception e) {
                    choice = -1;
                }
                if (choice == 0) {
                    clientMenu();
                } else if (choice > 0 && choice <= Dentist.dentists.size()) {
                    Dentist D = Client.chooseDentist(choice - 1);
                    System.out.println("View the statistics of Dr. " + D.lastName + ": ");
                    D.findStatistics(false);
                    System.out.println("Do you want to make an appointment with Dr. " + D.lastName + "?");
                    System.out.println("Press 1 for 'Yes' or anything else for 'No'.");
                    try {
                        choice = Integer.parseInt(in.next());
                    } catch (Exception e) {
                    }
                    if (choice == 1) {
                        System.out.print("Enter a name:\n> ");
                        name = in.next();
                        Client.requestAppointment(D, name);
                        printMenu();
                    } else {
                        clientMenu();
                    }
                } else {
                    System.out.print("Choose 0 to quit looking for dentist or 1-" + Dentist.dentists.size() + " to choose a dentist:\n> ");
                }
            } while (choice < 0 || choice > Dentist.dentists.size());
        } else if (choice == 2) {
            printMenu();
        } else {
            System.out.println("Wrong input, you must choose between 0-2!");
            clientMenu();
        }
    }
}