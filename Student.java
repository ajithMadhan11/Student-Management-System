import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

public class Student {
    static int lastRegisteredId = 101;
    int id;
    String name;
    int year;
    ArrayList<Integer> courseList = new ArrayList<Integer>(5);
    int fees;
    Scanner sc = new Scanner(System.in);

    // Add student method
    public void addStudent() {
        System.out.println("Enter Student name");
        this.name = sc.nextLine();
        this.id = lastRegisteredId++;
        System.out.println("Enter Graduation year");
        this.year = sc.nextInt();
        System.out.println("Student Added Successfully");
    }

    // Printing student details
    public void getDetails() {
        System.out.println(this.id + "           " + this.name + "             " + this.year);
    };

    // Printing Student details in different format
    public void getDetails(String r) {

        System.out.print(this.id);
        System.out.print("              ");
        System.out.print(this.name);
        System.out.print("            ");
        courseEnrolled();
        System.out.print("                         ");
        System.out.print(this.fees);
        System.out.println();

    }

    // Print Student full details
    public void getFullDetails() {
        System.out.println("-----------------------------------------");
        System.out.println("|         Student Full Detail           |");
        System.out.println("-----------------------------------------");
        System.out.println("Name            | " + this.name);
        System.out.println("Id              | " + this.id);
        System.out.println("Graduation year | " + this.year);
        System.out.println("Pending fees    | " + this.fees);
        System.out.print("Couses enrolled | ");
        courseEnrolled();
        System.out.println();
        System.out.println("----------------------------------------");

    }

    // Add course to student
    public void enrollCourse(int c_id) {

        // Checking if total enrolled courses is not more than 5
        if (courseList.size() == 5) {
            System.out.println("Can't enroll more than 5 courses");
            return;
        }
        // Checking course duplication in Student
        for (int id : courseList) {
            if (id == c_id) {
                System.out.println("Course already enrolled!");
                return;
            }
        }
        courseList.add(c_id);
        this.fees += 5000;
        System.out.println("Course enrolled sucessfully");
    }

    public void unEnrollCourse(int c_id) {
        boolean check = false;
        for (int id : courseList) {
            if (id == c_id) {
                check = true;
                break;
            }
        }
        if (check) {
            Iterator itr = courseList.iterator();
            while (itr.hasNext()) {
                int data = (Integer) itr.next();
                if (data == c_id) {
                    itr.remove();
                    break;
                }
            }
            this.fees = this.fees - 4000;
            System.out.println("Course Removed sucessfully 20% service charge has been deducted!");

        } else {
            System.out.println("No Course found in that ID!");

        }
    }

    // Fees paying method
    public boolean checkFees() {
        if (this.fees == 0) {
            System.out.println("No pending fees available for this studnet!");
            return false;
        } else {
            System.out.println("The pending fees is ₹" + this.fees);
            return true;
        }
    }

    public void payFees(int amt) {
        if (amt > this.fees) {
            System.out.println("Entered amount is greater than payable fees!");
            return;
        }
        this.fees -= amt;
        System.out.println("Fees paid sucessfully");
    }

    public void courseEnrolled() {
        for (int id : courseList) {
            System.out.print(id + "|");
        }

    }

    public void editDetails() {
        System.out.println("What field do you want to edit?");
        System.out.println("           1.Name");
        System.out.println("           2.Year");
        System.out.println("           3.Courses enrolled");

        int choice;
        try {
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    editUserDetail("name");
                    break;
                case 2:
                    editUserDetail("year");
                    break;
                case 3:
                    editUserDetail("courseList");
                    break;

                default:
                    break;
            }
        } catch (InputMismatchException a) {
            System.out.println("Please enter a valid Input!");
            sc.next();
        }

    }

    public void editUserDetail(String type) {
        if (type == "name") {
            System.out.println("Please enter new name : ");
            sc.nextLine();
            String newName = sc.nextLine();
            this.name = newName;
            System.out.println("Student name edited sucessfully! ");
            return;
        } else if (type == "year") {
            System.out.println("Please enter new year : ");
            int newYear = sc.nextInt();
            this.year = newYear;
            System.out.println("Student's graduation year has been edited sucessfully! ");
            return;
        } else if (type == "courseList") {
            if (courseList.size() == 0) {
                System.out.print("No courses enrolled yet!");
                return;
            }
            System.out.print("Enrolled courses : ");
            courseEnrolled();
            System.out.println();
            System.out.print("Please enter the course ID to unenroll ");
            int c_id = sc.nextInt();
            unEnrollCourse(c_id);
            return;

        }

    }

}
