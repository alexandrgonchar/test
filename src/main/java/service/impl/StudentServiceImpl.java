package service.impl;

import dao.impl.H2StudentDao;
import dao.StudentDao;
import entity.Student;
import service.StudentService;

import java.sql.SQLException;
import java.util.List;

/**
 * Реализация интерфейса StudentService
 * @see StudentDao
 * @see H2StudentDao
 * @see StudentService
 * @autor Александр
 * @version 1.0
 */
public class StudentServiceImpl implements StudentService {

    /**
     * Обьект для доступа к Dao слою.
     */
    private StudentDao studentDao = new H2StudentDao();

    @Override
    public void createStudent(Student student) throws SQLException {
        studentDao.create(student);

    }

    @Override
    public List<Student> getAllStudent() throws SQLException {
        return studentDao.getAll();
    }

    @Override
    public Student getById(Long id) throws SQLException {
        return studentDao.getById(id);
    }

    @Override
    public void updateStudent(Student student) throws SQLException {
        studentDao.update(student);
    }

    @Override
    public void deleteStudent(Student student) throws SQLException {
        studentDao.delete(student);
    }
}
