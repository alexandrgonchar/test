package dao.impl;

import dao.AbstractH2Dao;
import dao.SubjectsDao;
import entity.Subjects;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

/**
 * Реализация интерфейса SubjectsDao
 * @see SubjectsDao
 * @see AbstractH2Dao
 * @autor Александр
 * @version 1.0
 */
public class H2SubjectsDao extends AbstractH2Dao<Subjects> implements SubjectsDao {

    @Override
    public String getCreateQuery() {
        return "INSERT INTO subjects (ID, SUBJECT_NAME) VALUES (?, ?)";
    }

    @Override
    public String getSelectQuery() {
        return "SELECT ID, SUBJECT_NAME FROM subjects";
    }

    @Override
    public String getUpdateQuery() {
        return "UPDATE subjects SET SUBJECT_NAME WHERE ID=?";
    }

    @Override
    public String getDeleteQuery() {
        return "DELETE FROM subjects WHERE ID=?";
    }

    @Override
    protected List<Subjects> parseResultSet(ResultSet resultSet) {
        LinkedList<Subjects> result = new LinkedList<>();
        try {
            while (resultSet.next()) {
                Subjects subjects = new Subjects();
                subjects.setId(resultSet.getLong("ID"));
                subjects.setSubjectName(resultSet.getString("SUBJECT_NAME"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    @Override
    protected void prepareStatementForInsertOrUpdate(PreparedStatement statement, Subjects subjects) {
        try {
            statement.setLong(1, subjects.getId());
            statement.setString(2, subjects.getSubjectName());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void prepareStatementForDelete(PreparedStatement statement, Subjects subjects) {
        try {
            statement.setLong(1, subjects.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Subjects create(Subjects subjects) throws SQLException {
        return createFromObject(subjects);
    }

    @Override
    public List<Subjects> getAll() throws SQLException {
        return getAllObjects();
    }

    @Override
    public Subjects getById(Long id) throws SQLException {
        return getObjectById(id);
    }

    @Override
    public void update(Subjects subjects) throws SQLException {
        updateObject(subjects);
    }

    @Override
    public void delete(Subjects subjects) throws SQLException {
        deleteObject(subjects);
    }
}
