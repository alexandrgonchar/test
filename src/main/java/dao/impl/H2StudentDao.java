package dao.impl;

import dao.AbstractH2Dao;
import dao.StudentDao;
import dao.Connector;
import entity.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Реализация интерфейса StudentDao
 * @see StudentDao
 * @see AbstractH2Dao
 * @autor Александр
 * @version 1.0
 */
public class H2StudentDao extends AbstractH2Dao<Student> implements StudentDao {

    @Override
    public String getSelectQuery() {
        return "SELECT ID, FULL_NAME FROM \"student\"";
    }

    @Override
    public String getCreateQuery() {
        return "INSERT INTO \"student\" (ID, FULL_NAME) VALUES (?, ?)";
    }

    @Override
    public String getUpdateQuery() {
        return "UPDATE \"student\" SET FULL_NAME WHERE ID = ?";
    }

    @Override
    public String getDeleteQuery() {
        return "DELETE FROM \"student\" WHERE ID = ?";
    }

    @Override
    protected List<Student> parseResultSet(ResultSet resultSet) {
        LinkedList<Student> result = new LinkedList<>();
        try {
            while (resultSet.next()) {
                Student student = new Student();
                student.setId(resultSet.getLong("ID"));
                student.setFull_name(resultSet.getString("FULL_NAME"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    @Override
    protected void prepareStatementForInsertOrUpdate(PreparedStatement statement, Student student) {
        try {
            statement.setLong(1,student.getId());
            statement.setString(2,student.getFull_name());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void prepareStatementForDelete(PreparedStatement statement, Student student) {
        try {
            statement.setLong(1,student.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Student create(Student student) throws SQLException {
        return createFromObject(student);
    }

    @Override
    public List<Student> getAll() throws SQLException {
        return getAllObjects();
    }

    @Override
    public Student getById(Long id) throws SQLException {
        return getObjectById(id);
    }

    @Override
    public void update(Student student) throws SQLException {
       updateObject(student);
    }

    @Override
    public void delete(Student student) throws SQLException {
        deleteObject(student);
    }
}
