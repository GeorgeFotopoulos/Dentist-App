import java.util.Scanner;

public class Engine {

    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        Dentist D1 = new Dentist("Giorhs", "Fotakis", "6988888883", "Fotakis23@gmail.com", "AK-47", "AUEB", "Artis 23", "6", "123456723");
        Dentist D2 = new Dentist("Tzortz", "Pat", "6987777883", "GpaokMono4@gmail.com", "M4A1", "Huawei", "Folegandrou 10", "1", "12341234");
        Dentist D3 = new Dentist("Takaros", "Gdimenos", "6981234563", "Rouxa80%Off@gmail.com", "Grenade", "Tipota", "Kalamatara", "20", "192837465");
        //printMenu();
        Dentist.seeListOfDentists();
    }


    private static void printMenu() {
        System.out.println("1. For Dentist");
        System.out.println("2. for Clients");
        int choice;
        do {
            try {
                System.out.println("Give 1 or 2,depending on the use you want");
                choice = Integer.parseInt(in.next());
            } catch (Exception e) {
                choice = 0;
            }
        } while (choice != 1 && choice != 2);

        if (choice == 1) {
            SignInDentists();

        } else {
            menuforClients();
        }
    }

    private static void SignInDentists() {
        System.out.println("Dentist Application");

        System.out.println("1. Register Dentist");
        System.out.println("2. Log In Dentist");
        int choice;
        do {
            try {
                System.out.println("Give 1 or 2,depending on the use you want");
                choice = Integer.parseInt(in.next());
            } catch (Exception e) {
                choice = 0;
                continue;
            }
        } while (choice != 1 && choice != 2);

        if (choice == 1) {
            createAccount();
        } else {
            LogInDentists();
        }
    }

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
                        System.out.println("Type \"back\" if you want to try a new password/Press anything else if you want to retype the password.\n");
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

    private static Dentist LogInDentists() {
        Scanner in = new Scanner(System.in);
        String email, password;
        System.out.println("Enter your e-mail address: ");
        email = in.nextLine();
        System.out.println("Enter your password: ");
        password = in.nextLine();
        Dentist D = Dentist.logIn(email, password);
        if (D == null) {
            System.out.println("Wrong Details.Try again!");
            LogInDentists();
        } else {
            System.out.println("The details are valid.");
        }
        return D;

    }

    private static void menuforClients() {
        Scanner in = new Scanner(System.in);
        System.out.println("1. For Dentist");
        System.out.println("2. for Clients");
        int choice;
        do {
            try {
                System.out.println("Give 1 or 2,depending on the use you want");
                choice = Integer.parseInt(in.next());
            } catch (Exception e) {
                choice = 0;
                continue;
            }
        } while (choice != 1 && choice != 2);
    }
}