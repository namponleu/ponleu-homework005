package service;

import exception.CourseNotFoundException;
import model.Course;

import java.util.List;

public interface CourseService {
    void addNewCourse();
    void listAllCourses();
    void findCourseByID() throws CourseNotFoundException;
    void findCourseByTitle() throws CourseNotFoundException;
    void removeCourse() throws CourseNotFoundException;
}
