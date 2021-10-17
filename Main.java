import java.util.InputMismatchException;

public class Main extends Database {

    public static void main(String[] args) {

        // Creating object for admin class
        Admin admin = new Admin();

        // initial keep authenticated status to false
        boolean authenticated = false;

        /**
         * Check authentication This loop executes untill the admin is getting
         * authenticated
         */

        do {
            System.out.println("---------------Welcome to Student Database---------------");
            System.out.println("ADMIN LOGIN : ");
            System.out.println("Enter your UserID: ");
            String userId = sc.nextLine();
            System.out.println("Enter your Password: ");
            String password = sc.nextLine();
            if (admin.authenticateUser(userId, password)) {
                clearScreen();
                System.out.println("Welcome Admin!");
                System.out.println();
                authenticated = true;
            } else {
                clearScreen();
                System.out.println("Authnetication failed please try again :( ");
                System.out.println();

            }
        } while (!authenticated);

        boolean exit = false;

        // Admin menu
        do {
            System.out.println();
            System.out.println("-------------ADMIN MENU-------------");
            System.out.println(" 1. Add Student to Database");
            System.out.println(" 2. Remove student from Database");
            System.out.println(" 3. Get student Details");
            System.out.println(" 4. Enroll in course");
            System.out.println(" 5. Pay fees");
            System.out.println(" 6. Edit student detail");
            System.out.println(" 7. View Report");
            System.out.println(" 8. Logout");
            System.out.println("------------------------------------");
            System.out.println();
            int choice;

            try {
                // Switch case according to user input
                choice = Integer.parseInt(sc.nextLine());
                switch (choice) {
                    case 1:
                        admin.addStudent();
                        break;

                    case 2:
                        admin.removeStudent();
                        break;

                    case 3:
                        admin.displayStudentDetails();
                        break;

                    case 4:
                        admin.enrollCourse();
                        break;

                    case 5:
                        admin.payFees();
                        break;

                    case 6:
                        admin.editStudentInfo();
                        break;
                    case 7:
                        admin.generateReport();
                        break;
                    case 8: {
                        // Exit from System
                        clearScreen();
                        System.out.println("----------------------------------");
                        System.out.println("------Thankyou for using SMS------");
                        System.out.println("----------------------------------");
                        exit = true;
                    }
                        break;
                    default:
                        System.out.println("Please enter a valid input!");
                        break;
                }

            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid Input!");
                sc.next();
            }

        } while (!exit);

    }

}
