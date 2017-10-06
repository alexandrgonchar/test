package dao;

import entity.Subjects;

import java.sql.SQLException;
import java.util.List;

/**
 * Обьект для управления персистентным
 * состоянием обьекта Subjects
 * @autor Александр
 * @version 1.0
 */
public interface SubjectsDao {

    /** Создает новую запись и соответствующий ей объект */
    Subjects create (Subjects subjects) throws SQLException;

    /** Возвращает список объектов соответствующих всем записям в базе данных */
    List<Subjects> getAll () throws SQLException;

    /** Возвращает объект соответствующий записи с первичным ключом id или null */
    Subjects getById (Long id) throws SQLException;

    /** Сохраняет состояние объекта subjects в базе данных */
    void update (Subjects subjects) throws SQLException;

    /** Удаляет запись об объекте из базы данных */
    void delete (Subjects subjects) throws SQLException;
}
