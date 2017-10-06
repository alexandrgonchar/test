package service.impl;

import dao.impl.H2MarksOfStudentsDao;
import dao.MarksOfStudentDao;
import entity.MarksOfStudent;
import service.MarksOfStudentsService;

import java.sql.SQLException;
import java.util.List;

/**
 * Реализация интерфейса MarksOfStudentsService
 * @see MarksOfStudentDao
 * @see H2MarksOfStudentsDao
 * @see MarksOfStudentsService
 * @autor Александр
 * @version 1.0
 */
public class MarksOfStudentsServiceImpl implements MarksOfStudentsService {

    /**
     * Обьект для доступа к Dao слою.
     */
    private MarksOfStudentDao marksOfStudentsDao = new H2MarksOfStudentsDao();

    @Override
    public MarksOfStudent createMark(MarksOfStudent mark) throws SQLException {
        return marksOfStudentsDao.create(mark);
    }

    @Override
    public List<MarksOfStudent> getAllMarks() throws SQLException {
        return marksOfStudentsDao.getAll();
    }

    @Override
    public MarksOfStudent getById(Long firstId, Long secondId) throws SQLException {
        return marksOfStudentsDao.getById(firstId, secondId);
    }

    @Override
    public void updateMark(MarksOfStudent mark) throws SQLException {
        marksOfStudentsDao.update(mark);
    }

    @Override
    public void deleteMark(MarksOfStudent mark) throws SQLException {
        marksOfStudentsDao.delete(mark);
    }
}
