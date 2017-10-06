package service.impl;

import dao.impl.H2SubjectsDao;
import dao.SubjectsDao;
import entity.Subjects;
import service.SubjectsService;

import java.sql.SQLException;
import java.util.List;

/**
 * Реализация интерфейса SubjectsService
 * @see SubjectsDao
 * @see H2SubjectsDao
 * @see SubjectsService
 * @autor Александр
 * @version 1.0
 */
public class SubjectsServiceImpl implements SubjectsService {

    /**
     * Обьект для доступа к Dao слою.
     */
    private SubjectsDao subjectsDao = new H2SubjectsDao();

    @Override
    public void createSubject(Subjects subjects) throws SQLException {
        subjectsDao.create(subjects);
    }

    @Override
    public List<Subjects> getAllSubjects() throws SQLException {
        return subjectsDao.getAll();
    }

    @Override
    public Subjects getById(Long id) throws SQLException {
        return subjectsDao.getById(id);
    }

    @Override
    public void updateSubject(Subjects subjects) throws SQLException {
        subjectsDao.update(subjects);
    }

    @Override
    public void deleteSubject(Subjects subjects) throws SQLException {
        subjectsDao.delete(subjects);
    }
}
