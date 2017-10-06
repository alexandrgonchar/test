package service;

import entity.Subjects;

import java.sql.SQLException;
import java.util.List;

/**
 * Обьект service слоя для доступа
 * к public методам dao
 * @autor Александр
 * @version 1.0
 */
public interface SubjectsService {

    /**
     * Дает доступ к create методу дао слоя. Возвращает Subjects.
     */
    void createSubject (Subjects subjects) throws SQLException;

    /**
     * Дает доступ к getAll методу дао слоя. Возвращает список объектов соответствующих
     * всем записям в базе данных
     */
    List<Subjects> getAllSubjects () throws SQLException;

    /**
     * Дает доступ к getById методу дао слоя. Возвращает объект Subjects
     * соответствующий записи с первичным ключом id или null
     */
    Subjects getById (Long id) throws SQLException;

    /**
     * Дает доступ к update методу дао слоя. Сохраняет состояние объекта student в базе данных
     */
    void updateSubject (Subjects subjects) throws SQLException;

    /**
     * Дает доступ к delete методу дао слоя. Удаляет запись об объекте из базы данных
     */
    void deleteSubject (Subjects subjects) throws SQLException;
}
