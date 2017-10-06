package entity;

import java.io.Serializable;

/**
 * Представление таблицы MarksOfStudent
 * @autor Александр
 * @version 1.0
 */
public class MarksOfStudent implements Serializable {

    /**
     * Ненулевое поле studentId
     * таблицы MarksOfStudent
     * @see entity.Student#id
     * */
    private Long studentId;

    /**
     * Ненулевое поле subjectId
     * таблицы MarksOfStudent
     * @see entity.Subjects#id
     * */
    private Long subjectId;

    /** Ненулевое поле mark таблицы MarksOfStudent */
    private Long mark;

    /** Возвращает поле studentId таблицы MarksOfStudent */
    public Long getStudentId() {
        return studentId;
    }

    /** Инициализирует поле studentId таблицы MarksOfStudent */
    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    /** Возвращает поле subjectId таблицы MarksOfStudent */
    public Long getSubjectId() {
        return subjectId;
    }

    /** Инициализирует поле subjectId таблицы MarksOfStudent */
    public void setSubjectId(Long subjectId) {
        this.subjectId = subjectId;
    }

    /** Возвращает поле mark таблицы MarksOfStudent */
    public Long getMark() {
        return mark;
    }

    /** Инициализирует поле mark таблицы MarksOfStudent */
    public void setMark(Long mark) {
        this.mark = mark;
    }
}
