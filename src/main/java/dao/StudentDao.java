package dao;

import entity.Student;

import java.sql.SQLException;
import java.util.List;

/**
 * Обьект для управления персистентным
 * состоянием обьекта Student
 * @autor Александр
 * @version 1.0
 */
public interface StudentDao {

    /** Создает новую запись и соответствующий ей объект */
    Student create (Student student) throws SQLException;

    /** Возвращает список объектов соответствующих всем записям в базе данных */
    List<Student> getAll () throws SQLException;

    /** Возвращает объект соответствующий записи с первичным ключом id или null */
    Student getById (Long id) throws SQLException;

    /** Сохраняет состояние объекта student в базе данных */
    void update (Student student) throws SQLException;

    /** Удаляет запись об объекте из базы данных */
    void delete (Student student) throws SQLException;
}
