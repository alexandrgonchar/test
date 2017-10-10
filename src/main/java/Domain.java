import entity.MarksOfStudent;
import entity.Student;
import entity.Subjects;
import service.impl.MarksOfStudentsServiceImpl;
import service.impl.StudentServiceImpl;
import service.impl.SubjectsServiceImpl;

import java.sql.SQLException;

/**
 * @autor Александр
 * @version 1.0
 */
public class Domain {

    public static void main(String[] args) {

        Student student = new Student();
        student.setId(30L);
        student.setFull_name("Alex");

        Subjects subjects = new Subjects();
        subjects.setId(30L);
        subjects.setSubjectName("Math");

        MarksOfStudent marksOfStudent = new MarksOfStudent();
        marksOfStudent.setStudentId(30L);
        marksOfStudent.setSubjectId(30L);
        marksOfStudent.setMark(5L);

        StudentServiceImpl studentService = new StudentServiceImpl();
        SubjectsServiceImpl subjectsService = new SubjectsServiceImpl();
        MarksOfStudentsServiceImpl marksOfStudentsService = new MarksOfStudentsServiceImpl();

        try {
            studentService.createStudent(student);
            subjectsService.createSubject(subjects);
            marksOfStudentsService.createMark(marksOfStudent);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
