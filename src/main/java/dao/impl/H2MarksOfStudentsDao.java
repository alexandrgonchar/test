package dao.impl;

import dao.AbstractH2Dao;
import dao.MarksOfStudentDao;
import entity.MarksOfStudent;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

/**
 * Реализация интерфейса MarksOfStudentDao
 * @see MarksOfStudentDao
 * @see AbstractH2Dao
 * @autor Александр
 * @version 1.0
 */
public class H2MarksOfStudentsDao extends AbstractH2Dao<MarksOfStudent>  implements MarksOfStudentDao {

    @Override
    public String getCreateQuery() {
        return "INSERT INTO \"marks_of_student\" (STUDENT_ID, SUBJECT_ID, MARK) VALUES (?, ?, ?)";
    }

    @Override
    public String getSelectQuery() {
        return "SELECT STUDENT_ID, SUBJECT_ID, MARK FROM \"marks_of_student\"";
    }

    @Override
    public String getUpdateQuery() {
        return "UPDATE \"marks_of_student\" SET STUDENT_ID, SUBJECT_ID, MARK";
    }

    @Override
    public String getDeleteQuery() {
        return "DELETE FROM \"marks_of_student\" WHERE STUDENT_ID=? AND SUBJECT_ID=?";
    }

    @Override
    protected List<MarksOfStudent> parseResultSet(ResultSet resultSet) {
        LinkedList<MarksOfStudent> result = new LinkedList<>();
        try {
            while (resultSet.next()) {
                MarksOfStudent marksOfStudent = new MarksOfStudent();
                marksOfStudent.setStudentId(resultSet.getLong("STUDENT_ID"));
                marksOfStudent.setSubjectId(resultSet.getLong("SUBJECT_ID"));
                marksOfStudent.setMark(resultSet.getLong("MARK"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    @Override
    protected void prepareStatementForInsertOrUpdate(PreparedStatement statement, MarksOfStudent marksOfStudent) {
        try {
            statement.setLong(1, marksOfStudent.getStudentId());
            statement.setLong(2, marksOfStudent.getSubjectId());
            statement.setLong(3, marksOfStudent.getMark());
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void prepareStatementForDelete(PreparedStatement statement, MarksOfStudent marksOfStudent) {
        try {
            statement.setLong(1, marksOfStudent.getStudentId());
            statement.setLong(2, marksOfStudent.getSubjectId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public MarksOfStudent create(MarksOfStudent mark) throws SQLException {
        return createFromObject(mark);
    }

    @Override
    public List<MarksOfStudent> getAll() throws SQLException {
        return getAllObjects();
    }

    @Override
    public MarksOfStudent getById(Long firstId, Long secondId) throws SQLException {
       return getObjectByIds(firstId, secondId);
    }

    @Override
    public void update(MarksOfStudent mark) throws SQLException {
        updateObject(mark);
    }

    @Override
    public void delete(MarksOfStudent mark) throws SQLException {
        deleteObject(mark);
    }
}
