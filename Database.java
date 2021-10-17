import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Database {

    static int lastRegisteredId = 105;
    static ArrayList<Student> allStudents = new ArrayList<Student>();
    static ArrayList<Course> allCourses = new ArrayList<Course>();
    static Scanner sc = new Scanner(System.in);

    // This method is initially called to populate the arraylist with some dummy
    // data.
    public void populateDatabase() {
        allStudents.add(new Student("Ajith", 101, 2020));
        allStudents.add(new Student("Priya", 102, 2021));
        allStudents.add(new Student("Kanna", 103, 2020));
        allStudents.add(new Student("vihal", 104, 2022));

        allCourses.add(new Course("English", 201, 5000));
        allCourses.add(new Course("Tamil", 202, 5000));
        allCourses.add(new Course("Maths", 203, 5000));
        allCourses.add(new Course("Science", 204, 5000));
        allCourses.add(new Course("Social", 205, 5000));
    }

    // This method is used to display studnet detail in a table format
    public void displayStudentDetails() {
        System.out.println("-----------------------------------------------");
        System.out.printf("%5s %15s %15s", "Student Id", "Student Name", "Graduation year");
        System.out.println();
        System.out.println("-----------------------------------------------");
        for (Student s : allStudents) {
            System.out.printf("%5s %15s %10s", s.id, s.name, s.year);
            System.out.println();
        }
        System.out.println("-----------------------------------------------");

    }

    // This method is used to display course detalis in a table frmat
    public void displayCourseDetails() {
        System.out.println("-----------------------------------------------");
        System.out.printf("%5s %15s %15s", "Course Id", "Course Name", "Fees");
        System.out.println();
        System.out.println("-----------------------------------------------");
        for (Course c : allCourses) {
            System.out.printf("%5s %15s %15s", c.courseId, c.courseName, c.fees);
            System.out.println();
        }
        System.out.println("-----------------------------------------------");
    }

    /**
     * This method is used to print the courses enrolled by paticular studnet
     * 
     * @param s_id studnet ID is passed as an parameter
     */

    public void printCourses(int s_id) {
        if (getStudent(s_id).courseList.isEmpty()) {
            System.out.print("-");
        }
        for (int id : getStudent(s_id).courseList) {
            System.out.print(id + " | ");
        }
    }

    /**
     * This method is used to check if the Student is present in database or not
     * 
     * @param s_id studnet ID is passed as an parameter
     * @return true if valid stuent or false
     */
    public boolean isvalidStudent(int s_id) {
        Iterator<Student> itr = allStudents.iterator();
        while (itr.hasNext()) {
            Student student = itr.next();
            if (student.id == s_id) {
                return true;
            }
        }
        return false;
    }

    /**
     * This method is used to get the studnet object by its ID
     * 
     * @param s_id studnet ID is passed as an parameter
     * @return the particular student for that ID or null
     */

    public Student getStudent(int s_id) {
        for (Student s : allStudents) {
            if (s.id == s_id) {
                return s;
            }
        }
        return null;
    }

    /**
     * This method is used to print the courses enrolled by paticular studnet
     * 
     * @param s_id studnet ID is passed as an parameter
     */
    public int printEnrolledCourses(int s_id) {
        if (getStudent(s_id).courseList.isEmpty()) {
            System.out.print("-");
            return 0;
        }
        for (int id : getStudent(s_id).courseList) {
            System.out.print(id + " | ");
        }
        return 1;
    }

    /**
     * This method checks whether the passed course ID is for valid course or nt
     * 
     * @param c_id
     * @return true if it is a valid course or returns false
     */
    public boolean isvalidCourse(int c_id) {
        Iterator<Course> itr = allCourses.iterator();
        while (itr.hasNext()) {
            Course course = itr.next();
            if (course.courseId == c_id) {
                return true;
            }
        }
        return false;
    }

    // This method is used t show reprt of the user.
    public void showReport() {
        System.out.println(
                "-----------------------------------------------------------------------------------------------");
        System.out.println("                       STUDENT MANAGEMENT SYSTEM - REPORT");
        System.out.println(
                "-----------------------------------------------------------------------------------------------");
        System.out.printf("%5s %15s %20s %20s %20s", "Student Id", "Studnet Name", "Graduation year", "Pending fees",
                "Enrolled courses");
        System.out.println();
        System.out.println(
                "-----------------------------------------------------------------------------------------------");
        for (Student s : allStudents) {
            System.out.printf("%5s %15s %15s %15s %15s", s.id, s.name, s.year, s.fees, "|");
            printCourses(s.id);
            System.out.println();
        }
        System.out
                .println("-------------------------------------------------------------------------------------------");

    }

    // This is an helper method to clear the console screen
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
