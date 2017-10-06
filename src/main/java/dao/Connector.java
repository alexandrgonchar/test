package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Класс для предоставления доступа
 * к базе данных
 * @autor Александр
 * @version 1.0
 */
public final class Connector {

    /**
     * Данные пользователя для доступа к базе
     */
    private String username = "sa";//Логин пользователя
    private String password = "";//Пароль пользователя
    private String url = "jdbc:h2:~/test";//URL адрес базы данных
    private String driver = "org.h2.Driver";//Имя драйвера

    /**
     * Метод осуществляет доступ к базе данных с помощью данных пользователя.
     * Вовращает обьект Connection.
     */
    public Connection getConnection () {
        Connection connection = null;

        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("ok");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return connection;
    }
}
