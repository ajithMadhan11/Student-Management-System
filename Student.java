import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Student {

    int id;
    String name;
    int year;
    ArrayList<Integer> courseList = new ArrayList<Integer>(5);
    int fees;
    Scanner sc = new Scanner(System.in);

    /**
     * Student Constructor
     * 
     * @param name Name of the studnet
     * @param id   ID of the studnet
     * @param year Graduation year of the student
     */
    Student(String name, int id, int year) {
        this.name = name;
        this.id = id;
        this.year = year;
    }

    // This method is used to edit studnets name
    public void editName() {
        System.out.println("Enter new Student name :");
        this.name = (sc.nextLine());
        System.out.println("Student name Changed sucessfully!");
    }

    // This method is used to edit studnets graduation year
    public void editYear() {
        System.out.println("Enter new Graduation year :");
        this.year = (Integer.parseInt(sc.nextLine()));
        System.out.println("Student's graduation year Changed sucessfully!");
    }

    // This method is used to edit studnets enrolled courses
    public void editCourses(int c_id) {
        Iterator itr = courseList.iterator();
        while (itr.hasNext()) {
            int data = (Integer) itr.next();
            if (data == c_id) {
                itr.remove();
                this.fees -= 4000;
                System.out.println("Course unrolled sucessfully and 20% service charge has been deducted!");
                return;
            }
        }
        System.out.println("No course found in that ID");
    }

    // This method is used to enroll studnet in a course
    /**
     * 
     * @param c_id course ID that to be enrolled
     */
    public void enrollCourse(int c_id) {
        // if the length of courselist is more than 5 no more courses can be enrolled.
        if (courseList.size() >= 5) {
            System.out.println("You can't enroll more than 5 courses");
            return;
        }

        // This checks if the course is already enrolled
        for (int id : courseList) {
            if (id == c_id) {
                System.out.println("Course already enrolled!");
                return;
            }
        }

        // add() method adds the course to the list
        this.courseList.add(c_id);
        // Course fees is added to the fees
        this.fees += 5000;
        System.out.println("Course Enrolled Sucessfully!");

    }

    // This method is used to pay Studnets fees
    public void payFees() {
        boolean exit = false;

        // this shows users pending fees.
        System.out.println("Your pending fees is ₹" + this.fees);

        // if no pending fees returns a message
        if (this.fees == 0) {
            System.out.println("You don't have any pending fees! Thank you !");
            return;
        }
        // loops till user exits
        do {
            // gets users fees amt
            System.out.println("Enter amount to pay :");
            int amt = (Integer.parseInt(sc.nextLine()));
            // If entered amt is more than payable amount the return a message.
            if (amt > this.fees) {
                System.out.println("Entered amount is greater than your payable fees!");
            } else {
                // else reduces the amt from fees and exits.
                this.fees -= amt;
                System.out.println("Fees payed Sucessfully!");
                exit = true;
            }
        } while (!exit);

    }

}
