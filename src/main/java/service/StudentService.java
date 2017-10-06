package service;

import entity.Student;

import java.sql.SQLException;
import java.util.List;

/**
 * Обьект service слоя для доступа
 * к public методам dao
 * @autor Александр
 * @version 1.0
 */
public interface StudentService {

    /**
     * Дает доступ к create методу дао слоя. Возвращает Student.
     */
    void createStudent (Student student) throws SQLException;

    /**
     * Дает доступ к getAll методу дао слоя. Возвращает список объектов соответствующих
     * всем записям в базе данных
     */
    List<Student> getAllStudent () throws SQLException;

    /**
     * Дает доступ к getById методу дао слоя. Возвращает объект Student соответствующий записи
     * с первичным ключом id или null
     */
    Student getById (Long id) throws SQLException;

    /**
     * Дает доступ к update методу дао слоя. Сохраняет состояние объекта student в базе данных
     */
    void updateStudent (Student student) throws SQLException;

    /**
     * Дает доступ к delete методу дао слоя. Удаляет запись об объекте student из базы данных
     */
    void deleteStudent (Student student) throws SQLException;
}
