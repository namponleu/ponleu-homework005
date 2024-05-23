package service;

import exception.CourseNotFoundException;
import model.Course;
import org.nocrala.tools.texttablefmt.BorderStyle;
import org.nocrala.tools.texttablefmt.CellStyle;
import org.nocrala.tools.texttablefmt.ShownBorders;
import org.nocrala.tools.texttablefmt.Table;
import repository.CourseRepository;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CourseServiceImp implements CourseService {
    Scanner scanner = new Scanner(System.in);
    @Override
    public void addNewCourse() {
        CourseRepository.listAllCourse();
    }

    @Override
    public void listAllCourses() {
        Table table = new Table(5, BorderStyle.UNICODE_BOX_DOUBLE_BORDER, ShownBorders.ALL);
        for (int i = 0; i < 5; i++) {
            table.setColumnWidth(i,35,35);
        }

        table.addCell("ID", new CellStyle(CellStyle.HorizontalAlign.CENTER));
        table.addCell("Title", new CellStyle(CellStyle.HorizontalAlign.CENTER));
        table.addCell("Instructor", new CellStyle(CellStyle.HorizontalAlign.CENTER));
        table.addCell("Requirement", new CellStyle(CellStyle.HorizontalAlign.CENTER));
        table.addCell("Start date", new CellStyle(CellStyle.HorizontalAlign.CENTER));

        for (Course course : CourseRepository.getAllListCourses()){
            table.addCell(String.valueOf(course.getId()), new CellStyle(CellStyle.HorizontalAlign.CENTER));
            table.addCell(course.getTitle(), new CellStyle(CellStyle.HorizontalAlign.CENTER));
            table.addCell(Arrays.toString(course.getInstructorName()), new CellStyle(CellStyle.HorizontalAlign.CENTER));
            table.addCell(Arrays.toString(course.getRequirement()), new CellStyle(CellStyle.HorizontalAlign.CENTER));
            table.addCell(String.valueOf(course.getStartDate()), new CellStyle(CellStyle.HorizontalAlign.CENTER));
        }
        System.out.println(table.render());
 }

    @Override
    public void findCourseByID() throws CourseNotFoundException{
        try {
            System.out.print("[+] Insert course ID for searching: ");
            String input = scanner.nextLine();
            Integer id = Integer.parseInt(input);
            var courses = CourseRepository.getAllListCourses().stream()
                    .filter(course -> course.getId().equals(id)).toList();

            if (courses.isEmpty()){
                throw new CourseNotFoundException("[!] No course found with id " + id);
            }

            Table table = new Table(5, BorderStyle.UNICODE_BOX_DOUBLE_BORDER, ShownBorders.ALL);
            for (int i = 0; i < 5; i++) {
                table.setColumnWidth(i,35,35);
            }

            table.addCell("ID", new CellStyle(CellStyle.HorizontalAlign.CENTER));
            table.addCell("Title", new CellStyle(CellStyle.HorizontalAlign.CENTER));
            table.addCell("Instructor", new CellStyle(CellStyle.HorizontalAlign.CENTER));
            table.addCell("Requirement", new CellStyle(CellStyle.HorizontalAlign.CENTER));
            table.addCell("Start date", new CellStyle(CellStyle.HorizontalAlign.CENTER));

            for (Course course : CourseRepository.getAllListCourses()){
                table.addCell(String.valueOf(course.getId()), new CellStyle(CellStyle.HorizontalAlign.CENTER));
                table.addCell(course.getTitle(), new CellStyle(CellStyle.HorizontalAlign.CENTER));
                table.addCell(Arrays.toString(course.getInstructorName()), new CellStyle(CellStyle.HorizontalAlign.CENTER));
                table.addCell(Arrays.toString(course.getRequirement()), new CellStyle(CellStyle.HorizontalAlign.CENTER));
                table.addCell(String.valueOf(course.getStartDate()), new CellStyle(CellStyle.HorizontalAlign.CENTER));
            }
            System.out.println(table.render());

        }catch (NumberFormatException numberFormatException){
            System.out.println("[!] Invalid input");
        }
    }

    @Override
    public void findCourseByTitle() throws CourseNotFoundException {
        System.out.print("[+] Insert course title for searching: ");
        String courseTitle = scanner.nextLine().toLowerCase().trim();
        var courses = CourseRepository.getAllListCourses().stream()
                .filter(course -> course.getTitle().toLowerCase().contains(courseTitle)).toList();

        if (courses.isEmpty()){
            throw new CourseNotFoundException("[!] No course found with title " + courseTitle);
        }

        Table table = new Table(5, BorderStyle.UNICODE_BOX_DOUBLE_BORDER, ShownBorders.ALL);
        for (int i = 0; i < 5; i++) {
            table.setColumnWidth(i,35,35);
        }

        table.addCell("ID", new CellStyle(CellStyle.HorizontalAlign.CENTER));
        table.addCell("Title", new CellStyle(CellStyle.HorizontalAlign.CENTER));
        table.addCell("Instructor", new CellStyle(CellStyle.HorizontalAlign.CENTER));
        table.addCell("Requirement", new CellStyle(CellStyle.HorizontalAlign.CENTER));
        table.addCell("Start date", new CellStyle(CellStyle.HorizontalAlign.CENTER));

        for (Course course : CourseRepository.getAllListCourses()){
            table.addCell(String.valueOf(course.getId()), new CellStyle(CellStyle.HorizontalAlign.CENTER));
            table.addCell(course.getTitle(), new CellStyle(CellStyle.HorizontalAlign.CENTER));
            table.addCell(Arrays.toString(course.getInstructorName()), new CellStyle(CellStyle.HorizontalAlign.CENTER));
            table.addCell(Arrays.toString(course.getRequirement()), new CellStyle(CellStyle.HorizontalAlign.CENTER));
            table.addCell(String.valueOf(course.getStartDate()), new CellStyle(CellStyle.HorizontalAlign.CENTER));
        }
        System.out.println(table.render());

    }

    @Override
    public void removeCourse() throws CourseNotFoundException {
        System.out.print("[+] Remove course by ID: ");
        Integer courseId = Integer.parseInt(scanner.nextLine());
        List<Course> courseList = CourseRepository.getAllListCourses();
        courseList.stream().filter(element -> {
            if (!(element.getId() == courseId)){
                try {
                    throw new CourseNotFoundException("[+] course ID founded " + courseId);
                } catch (CourseNotFoundException e) {
                    System.out.println(e.getMessage());;
                }
            }
            return element.getId().equals(courseId);
        }).forEach(element -> {
            courseList.remove(element);
            System.out.println("[-] Successful removed data");
        });
    }
}
