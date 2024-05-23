package repository;

import exception.CourseNotFoundException;
import model.Course;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class CourseRepository {
    static List<Course> courses = new ArrayList<>();
    static String title;

    public static void listAllCourse() {
        try{
            System.out.print("[+] Insert course title: ");
            title = new Scanner(System.in).nextLine();
            for(int i=0; i < 10; i++) {
                if(title.contains(String.valueOf(i))) {
                    throw new CourseNotFoundException("[+] Invalid title input!");
                }
            }

            System.out.print("[+] Insert instructor name: ");
            String[] instructor = new Scanner(System.in).nextLine().split(" , ");
            for(int i=0; i < instructor.length; i++) {
                for(int j=0; j < instructor.length; j++) {
                    if(instructor[i].contains(String.valueOf(i))) {
                        throw new CourseNotFoundException("[+] Invalid instructor input!");
                    }
                }
            }

            System.out.print("[+] Insert the requirement: ");
            String[] requirement = new Scanner(System.in).nextLine().split(" , ");
            for(int i=0; i < requirement.length; i++) {
                for(int j=0; j < requirement.length; j++) {
                    if(requirement[i].contains(String.valueOf(i))) {
                        throw new CourseNotFoundException("[+] Invalid requirement input!");
                    }
                }
            }

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            String date = LocalDateTime.now().format(formatter);

            Course course = new Course(new Random().nextInt(10000), title, instructor, requirement, new Date(date));
            courses.add(course);

        } catch (CourseNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<Course> getAllListCourses(){
        return courses;
    }
}
