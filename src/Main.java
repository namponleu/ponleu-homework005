import exception.CourseNotFoundException;
import service.CourseService;
import service.CourseServiceImp;
import view.View;

import java.util.InputMismatchException;


public class Main {
    private final static CourseService courseService = new CourseServiceImp();

    public static void main(String[] args) {
        while (true) {
            try {
                switch (View.menu()) {
                    case 0, 99 -> {
                        System.out.println("Exiting the application...");
                        System.exit(99);
                    }
                    case 1 -> courseService.addNewCourse();
                    case 2 -> courseService.listAllCourses();
                    case 3 -> courseService.findCourseByID();
                    case 4 -> courseService.findCourseByTitle();
                    case 5 -> courseService.removeCourse();
                    default -> System.out.println("[+] Invalid option!");
                }
            } catch (CourseNotFoundException courseNotFoundException) {
                System.out.println(courseNotFoundException.getMessage());
            }catch (InputMismatchException inputMismatchException){
                System.out.println("[+] Invalid input. Please try again.");
            }
        }
    }
}