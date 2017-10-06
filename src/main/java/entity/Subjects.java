package entity;

import java.io.Serializable;

/**
 * Представление таблицы Subjects
 * @autor Александр
 * @version 1.0
 */
public class Subjects implements Serializable {

    /** Ненулевое поле id таблицы Subjects */
    private Long id;

    /** Поле name таблицы Subjects */
    private String subjectName;

    /** Возвращает поле id таблицы Subjects */
    public Long getId() {
        return id;
    }

    /** Инициализирует поле id таблицы Subjects */
    public void setId(Long id) {
        this.id = id;
    }

    /** Возвращает поле name таблицы Subjects */
    public String getSubjectName() {
        return subjectName;
    }

    /** Инициализирует поле id таблицы Subjects */
    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

}
