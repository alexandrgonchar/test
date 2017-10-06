package dao;

import entity.MarksOfStudent;

import java.sql.SQLException;
import java.util.List;

/**
 * Обьект для управления персистентным
 * состоянием обьекта MarksOfStudent
 * @autor Александр
 * @version 1.0
 */
public interface MarksOfStudentDao {

    /** Создает новую запись и соответствующий ей объект */
    MarksOfStudent create (MarksOfStudent mark) throws SQLException;

    /** Возвращает список объектов соответствующих всем записям в базе данных */
    List<MarksOfStudent> getAll () throws SQLException;

    /** Возвращает объект соответствующий записи с первичным ключом firstId и внешним secondId или null */
    MarksOfStudent getById (Long firstId, Long secondId) throws SQLException;

    /** Сохраняет состояние объекта marksOfStudents в базе данных */
    void update (MarksOfStudent mark) throws SQLException;

    /** Удаляет запись об объекте из базы данных */
    void delete (MarksOfStudent mark) throws SQLException;
}
