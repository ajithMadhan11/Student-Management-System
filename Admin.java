import java.util.InputMismatchException;
import java.util.Iterator;

public class Admin extends Database implements AdminServices {

    /**
     * autheticateUser method which is used to authenticate the input
     * 
     * @param userName and password
     * @return true if valid user or false
     */

    public boolean authenticateUser(String userName, String password) {
        return validateUser(userName, password);
    }

    /**
     * addStudent method user to add studnet to the database
     */

    public void addStudent() {
        clearScreen();

        // gets name and graduation year from user
        System.out.println("Enter Student name :");
        String s_name = sc.nextLine();
        System.out.println("Enter Graduation year :");
        int s_year = Integer.parseInt(sc.nextLine());

        // using the users input this creates a new student object and adds in the
        // Database arrayList
        allStudents.add(new Student(s_name, lastRegisteredId++, s_year));
        System.out.println("Student Added Successfully :");
    }

    // Remove student method to remove a student object from Database arrayList
    public void removeStudent() {
        clearScreen();
        displayStudentDetails();

        // gets userID of student whse ID wants to be deleted
        System.out.println("Enter Student Id to remove :");
        int s_id = Integer.parseInt(sc.nextLine());

        // creating an Iterator for allStudents arraylist.
        Iterator<Student> itr = allStudents.iterator();
        while (itr.hasNext()) {
            Student student = itr.next();
            if (student.id == s_id) {

                // remove() method removes the object from the list.
                itr.remove();
                System.out.println("Student with ID " + s_id + " has been removed successfully!");
                return;
            }
        }
        // IF there is no such ID in student list a message is printed
        System.out.println("No student found with that ID :(");

    }

    // This method is used to edit Students information.
    public void editStudentInfo() {

        boolean exit = false;

        // do-while loop to repeat the options till user gets correct choice
        do {
            try {
                clearScreen();
                displayStudentDetails();

                // getting Studnet ID whose detail to be edited.
                System.out.println("Enter Student Id to edit details:");
                int s_id = Integer.parseInt(sc.nextLine());

                // checking wheather the Student object is present and displaying edit opttions
                if (getStudent(s_id) != null) {
                    System.out.println("------------------------------------");
                    System.out.println("Select option that you want to edit!");
                    System.out.println("------------------------------------");
                    System.out.println("        1.Student Name");
                    System.out.println("        2.Graduation year");
                    System.out.println("        3.Remove enrolled courses");
                    System.out.println("        4.Exit");
                    System.out.println("------------------------------------");
                    System.out.println("Please Enter you choice: ");
                    int choice = Integer.parseInt(sc.nextLine());

                    // To edit name,this calls editName method in Studnet class with the studnet
                    // Object
                    if (choice == 1) {
                        getStudent(s_id).editName();
                        return;
                    }

                    // To edit year,this calls the editYear method in Student class with the student
                    // Object
                    else if (choice == 2) {
                        getStudent(s_id).editYear();
                        return;

                    }

                    // To edit the enrolled courses
                    else if (choice == 3) {

                        // This displayes the currently enrolled courses of student.
                        System.out.println("Currently enrolled Courses :");
                        if (printEnrolledCourses(s_id) == 0) {
                            System.out.println("-No courses enrolled yet!-- ");
                            return;
                        }

                        // Gets user input to unenroll the particular course
                        System.out.println("Enter Course id to unenroll:");
                        int c_id = Integer.parseInt(sc.nextLine());

                        // calls the editCourse method in Student class to unenrll selected course
                        getStudent(s_id).editCourses(c_id);
                        return;

                        // exits from the loop
                    } else if (choice == 4) {
                        exit = true;
                    } else
                        System.out.println("Invalid Choice");
                } else
                    System.out.println("No student found with the ID " + s_id + ":(");
                // Exceptins are created for handly scanner inputs
            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid Input!");
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid Input!");
            }
        } while (!exit);

    }

    // enrollCourse method is called to enroll user with specific course
    public void enrollCourse() {
        clearScreen();
        displayStudentDetails();

        // gets input of Studnet ID to enroll course
        System.out.println("Enter Student Id to enroll course:");
        int s_id = Integer.parseInt(sc.nextLine());

        // IF the studnet ID is valid then displaying the available courses to enroll
        if (getStudent(s_id) != null) {
            displayCourseDetails();

            // geting users input of course to enroll
            System.out.println("Enter Course Id to enroll :");
            int c_id = Integer.parseInt(sc.nextLine());

            // If the input is a valid courseID then enrollCourse method in Studnet class is
            // called with Student object
            if (isvalidCourse(c_id)) {
                getStudent(s_id).enrollCourse(c_id);
                return;

            } else {

                // IF course ID is invalid then prints this message
                System.out.println("No Course found with the ID " + c_id + " :(");
                return;
            }
        }

        // If studnet ID is invalid then prints this message
        System.out.println("No student found with the ID " + s_id + ":(");
    }

    // Payfees method
    public void payFees() {
        clearScreen();
        displayStudentDetails();

        // getting user ID of student to pay fees
        System.out.println("Enter Student Id pay fees:");
        int s_id = Integer.parseInt(sc.nextLine());

        // If it is a valid studnet then payfees method in Studnet class is called with
        // student object.
        if (getStudent(s_id) != null) {
            getStudent(s_id).payFees();
            return;
        }

        // IF studnet ID is invalid then this message is printed.
        System.out.println("No Student found in that ID");

    }

    // methd to generate report
    public void generateReport() {
        clearScreen();
        showReport();
    }

}
