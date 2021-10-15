import java.util.Scanner;

public class Course {

    Scanner sc = new Scanner(System.in);

    public void enrollCourse(Student student) {

        System.out.println("Which course do you want to enroll?");
        System.out.println("--------------------------------------");
        System.out.println("CourseId         Name             Fees");
        System.out.println("--------------------------------------");
        System.out.println("  201           English          ₹5000");
        System.out.println("  202           Tamil            ₹5000");
        System.out.println("  203           Science          ₹5000");
        System.out.println("  204           Maths            ₹5000");
        System.out.println("  205           Social           ₹5000");
        System.out.println("--------------------------------------");
        System.out.println("Please enter Course id to enroll!");

        int course_id = sc.nextInt();
        student.enrollCourse(course_id);

    }
}
