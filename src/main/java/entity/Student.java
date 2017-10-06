package entity;


import java.io.Serializable;

/**
 * Представление таблицы Student
 * @autor Александр
 * @version 1.0
 */
public class Student implements Serializable {

    /** Ненулевое поле id таблицы Student */
    private Long id;

    /** Поле name таблицы Student */
    private String full_name;

    /** Возвращает поле id таблицы Student */
    public Long getId() {
        return id;
    }

    /** Инициализирует поле id таблицы Student */
    public void setId(Long id) {
        this.id = id;
    }

    /** Возвращает поле name таблицы Student */
    public String getFull_name() {
        return full_name;
    }

    /** Инициализирует поле name таблицы Subjects */
    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }
}
