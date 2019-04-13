import java.util.Scanner;

public class Engine {
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        Dentist D1 = new Dentist("Giorhs", "Fotakis", "6988888883", "F", "AK-47", "AUEB", "Artis 23", "6", "123456723", "Endodontic");
        Dentist D2 = new Dentist("Tzortz", "Pat", "6987777883", "GpaokMono4@gmail.com", "M4A1", "Huawei", "Folegandrou 10", "1", "12341234", "Pedodontic");
        Dentist D3 = new Dentist("Takaros", "Gdimenos", "6981234563", "Rouxa80%Off@gmail.com", "Grenade", "Tipota", "Kalamatara", "20", "192837465", "Orthodontist");
        Administrator.addService("Filling");
        Administrator.addService("Teeth Whitening");
        Administrator.addService("Dental Cleaning");
        Administrator.addSpecialization("Endodontic");
        Administrator.addSpecialization("Pedodontic");
        Administrator.addSpecialization("Orthodontist");
        Administrator.addSpecialization("Prosthodontist");

        Client C1 = new Client("Takis", "Makis", "Kapou magika", "2721066666", "Magas98@gmail.com");
        Services S1 = new Services("25/09/1998", "Filling", "");
        Services S2 = new Services("26/09/1998", "Teeth Whitening", "");
        C1.visits.add(S1);
        C1.visits.add(S2);
        Client.clients.put("160198", C1);



        D1.statistics.put("Filling", 4);
        D1.statistics.put("Dental Cleaning", 10);
        Appointment A1 = new Appointment("16/05/1995", 18, "George Fotopoulos", true, D1);
        Appointment A2 = new Appointment("18/05/1995", 11, "Panagiotis Ntymenos", true, D1);
        Appointment A3 = new Appointment("19/05/1995", 13, "George Patrikis", true, D2);
        Appointment A4 = new Appointment("16/05/1995", 12, "Tasos Zikapika", false, D1);
        Appointment A5 = new Appointment("19/05/1995", 9, "Stamatis Bongos", true, D3);
        printMenu();
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
        if (email.equalsIgnoreCase(Administrator.getUsername()) && password.equals(Administrator.getPassword())) {
            System.out.println("Master Login successful!");
            masterMenu();
            return null;
        }
        Dentist D = Dentist.logIn(email, password);
        if (D == null) {
            System.out.println("The e-mail or password you entered was invalid. Please try again!");
            dentistLogIn();
        } else {
            System.out.println("Login successful!");
            System.out.println();
            dentistMenu(D);
        }
        return D;
    }

    /**
     * This is the administrator Menu.
     */
    private static void masterMenu() {
        Scanner in = new Scanner(System.in);
        String service, specialization;
        System.out.println("0. Exit");
        System.out.println("1. Add Service");
        System.out.println("2. Add Specialization");
        int choice;
        do {
            try {
                System.out.println("Type 1 for services or 2 for specialization: ");
                choice = Integer.parseInt(in.next());
            } catch (Exception e) {
                choice = -1;
                continue;
            }
        } while (choice != 1 && choice != 2 && choice != 0);
        if (choice == 1) {
            System.out.println("Give Service: ");
            do {
                service = in.next();
                if (Administrator.services.contains(service)) {
                    System.out.println("This Service already exists.Give another one or press 0 to go to the menu: ");
                }
            } while (Administrator.services.contains(service) && !service.equals("0"));
            if (!service.equals("0")) {
                Administrator.addService(service);
            }
            masterMenu();
        } else if (choice == 2) {
            System.out.println("Give Specialization: ");
            do {
                specialization = in.next();
                if (Administrator.specializations.contains(specialization)) {
                    System.out.println("This Specialization already exists.Give another one or press 0 to go to the menu: ");
                }
            } while (Administrator.specializations.contains(specialization) && !specialization.equals("0"));
            if (!specialization.equals("0")) {
                Administrator.addSpecialization(specialization);
            }
            masterMenu();
        }
    }

    /**
     * This is the dentist Menu.
     */
    public static void dentistMenu(Dentist D) {
        Scanner in = new Scanner(System.in);
        System.out.println("0. Log Out");
        System.out.println("1. View Profile");
        System.out.println("2. Update Account");
        System.out.println("3. View Client History");
        System.out.println("4. Appointment Management");
        System.out.println("5. View Statistics");
        System.out.println("6. View Schedule");
        System.out.println("7. Record Provided Service");
        int choice = Integer.parseInt(in.next());
        if (choice == 0) {
            printMenu();
        } else if (choice == 1) {
            D.printDentistData();
            dentistMenu(D);
        } else if (choice == 2) {
            D.modifyData();
            dentistMenu(D);
        } else if (choice == 3) {
            Client.viewClientHistory();
            dentistMenu(D);
        } else if (choice == 4) {
            D.viewAppointmentRequests();
            dentistMenu(D);
        } else if (choice == 5) {
            D.findStatistics();
            dentistMenu(D);
        } else if (choice == 6) {
            D.viewApprovedAppointments();
            dentistMenu(D);
        } else if (choice == 7) {
            D.recordService();
            dentistMenu(D);
        } else {
            System.out.println("Wrong input, you have to choose between 0-7!");
            dentistMenu(D);
        }
    }

    /**
     * This is the client Menu.
     */
    private static void clientMenu() {
        Scanner in = new Scanner(System.in);
        System.out.println("0. Exit");
        System.out.println("1. Make Appointment");
        int choice;
        String name;
        choice = Integer.parseInt(in.next());
        if (choice == 0) {
            printMenu();
        } else if (choice == 1) {
            System.out.println("Choose one of the doctors IDs below or press 0 to exit:");
            Dentist.printListOfDentists();
            System.out.println("Give ID:");
            do {
                choice = Integer.parseInt(in.next());
                if (choice == 0) {
                    clientMenu();
                } else if (choice > 0 && choice <= Dentist.dentists.size()) {
                    Dentist D = Client.chooseDentist(choice - 1);
                    System.out.println("View The statistics of Dr. " + D.lastName);
                    D.findStatistics();
                    System.out.println("Do you want to make an appointment with Dr. " + D.lastName + "?");
                    System.out.println("Press 1 for 'Yes' or anything else for 'No'");
                    choice = Integer.parseInt(in.next());
                    if (choice == 1) {
                        System.out.println("Enter a name:");
                        System.out.print(">");
                        name = in.next();
                        Client.requestAppointment(D, name);

                        printMenu();
                    } else {
                        clientMenu();
                    }
                } else {
                    System.out.println("Choose between 0 or " + Dentist.dentists.size() + ".Try again:");
                }

            } while (choice < 0 || choice > Dentist.dentists.size());

        } else {
            System.out.println("Choose between 0 or 1.Try again:");
            clientMenu();
        }


    }
}