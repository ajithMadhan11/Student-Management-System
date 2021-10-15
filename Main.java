import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    // Creating Scanner Global object
    static Scanner sc = new Scanner(System.in);

    // Student Array
    static Student student[] = new Student[50];

    // Main method
    public static void main(String[] args) {

        // Creating object for Login class
        Authenticate admin = new Login();
        boolean authenticated = false;

        // Check Authentication
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
        int i = 0;

        // Admin menu
        do {
            System.out.println();
            System.out.println("-------------ADMIN MENU-------------");
            System.out.println("          1. Add Student");
            System.out.println("          2. View Student list");
            System.out.println("          3. Get student Details");
            System.out.println("          4. Enroll in course");
            System.out.println("          5. Pay fees");
            System.out.println("          6. Edit student detail");
            System.out.println("          7. View Report");
            System.out.println("          8. Logout");
            System.out.println("------------------------------------");
            System.out.println();
            int choice;

            try {
                // Switch case according to user input
                choice = sc.nextInt();
                switch (choice) {
                    case 1: {
                        // Creating new Student
                        student[i] = new Student();
                        student[i].addStudent();
                        i++;
                    }
                        break;
                    case 2: {
                        // Displaying Student details
                        studentDetails();
                    }
                        break;
                    case 3: {
                        // Displaying Student details
                        getStudentDetails();
                    }
                        break;
                    case 4: {
                        // Enrolling student to course
                        enrollStudents();
                    }
                        break;
                    case 5: {
                        // Fees payment
                        payFees();
                    }
                        break;
                    case 6: {
                        // Edit studnet info
                        editStudentInfo();
                    }
                        break;
                    case 7: {
                        // Report generation
                        generateReport();
                    }
                        break;
                    case 8: {
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

            } catch (InputMismatchException a) {
                System.out.println("Please enter a valid Input!");
                sc.next();
            }

        } while (!exit);

    }

    // Helper functions

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    // Getting specific student ID
    public static int getStudentId() {
        studentDetails();
        System.out.println();
        System.out.println("Please enter the Student ID");
        int userChoice = sc.nextInt();
        for (int j = 0; student[j] != null; j++) {
            if (student[j].id == (userChoice)) {
                return j;
            }
        }
        return -1;
    }

    // Report generation
    public static void generateReport() {
        clearScreen();
        System.out.println("---------------------------------------------------------------------------");
        System.out.println("                    Student Information System - Report                    ");
        System.out.println("---------------------------------------------------------------------------");
        System.out.println("Student Id      Student name      Courses Enrolled             Pending fees");
        System.out.println("---------------------------------------------------------------------------");
        for (int j = 0; student[j] != null; j++) {
            student[j].getDetails("report");
        }
        System.out.println("---------------------------------------------------------------------------");
    }

    // Fees payment method
    public static void payFees() {
        int searchId = getStudentId();
        if (searchId == -1) {
            System.out.println("No Student Found in that ID :(");
            return;
        }
        if (student[searchId].checkFees()) {
            System.out.println("Enter Amount paid :");
            int amt = sc.nextInt();
            student[searchId].payFees(amt);
        }
    }

    // Get student details method
    public static void studentDetails() {
        System.out.println("--------------------------------------------");
        System.out.println("Id            Name           Graduation year");
        System.out.println("--------------------------------------------");
        for (int j = 0; student[j] != null; j++) {
            student[j].getDetails();
        }
        System.out.println("--------------------------------------------");
    }

    public static void getStudentDetails() {
        studentDetails();
        System.out.println("Enter Student Id who details to be fetched : ");
        int searchId = getStudentId();
        if (searchId == -1) {
            System.out.println("No Student Found in that ID :(");
            return;
        }
        student[searchId].getFullDetails();
    }

    // Enroll studnet in course method
    public static void enrollStudents() {
        int searchId = getStudentId();
        if (searchId == -1) {
            System.out.println("No Student Found in that ID :(");
            return;
        }
        Course course = new Course();
        course.enrollCourse(student[searchId]);
    }

    public static void editStudentInfo() {
        // studentDetails();
        System.out.println("Enter Student Id who details to be Edited : ");
        int searchId = getStudentId();
        if (searchId == -1) {
            System.out.println("No Student Found in that ID :(");
            return;
        }
        student[searchId].editDetails();
    }
}
