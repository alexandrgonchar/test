package service;

import entity.MarksOfStudent;

import java.sql.SQLException;
import java.util.List;

/**
 * Обьект service слоя для доступа
 * к public методам dao
 * @autor Александр
 * @version 1.0
 */
public interface MarksOfStudentsService {

    /**
     * Дает доступ к create методу дао слоя. Возвращает MarksOfStudent.
     */
    MarksOfStudent createMark (MarksOfStudent mark) throws SQLException;

    /**
     * Дает доступ к getAll методу дао слоя. Возвращает список объектов соответствующих
     * всем записям в базе данных
     */
    List<MarksOfStudent> getAllMarks () throws SQLException;

    /**
     * Дает доступ к getById методу дао слоя. Возвращает объект MarksOfStudent
     * соответствующий записи с первичным ключом firstId и внешним secondId или null
     */
    MarksOfStudent getById (Long firstId, Long secondId) throws SQLException;

    /**
     * Дает доступ к update методу дао слоя. Сохраняет состояние объекта marksOfStudents в базе данных
     */
    void updateMark (MarksOfStudent mark) throws SQLException;

    /**
     * Дает доступ к delete методу дао слоя. Удаляет запись об объекте из базы данных
     */
    void deleteMark (MarksOfStudent mark) throws SQLException;
}
