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
    private final String username;
    private final String password;
    private final String url;
    private final String driver;
    private final Connection connection;

    /**
     * @param username Логин пользователя
     * @param password Пароль пользователя
     * @param url URL адрес базы данных
     * @param driver Имя драйвера
     */
    public Connector(String username, String password, String url, String driver) {
        this.username = username;
        this.password = password;
        this.url = url;
        this.driver = driver;
        this.connection = createConnection();
    }

    /**
     * @return соединение с базой данных
     */
    Connection getConnection () {
        return connection;
    }

    /**
     * Метод создает доступ к базе данных с помощью данных пользователя.
     * @return Connection
     */
    private Connection createConnection () {
        Connection createdConnection = null;

        try {
            Class.forName(driver);
            createdConnection = DriverManager.getConnection(url, username, password);
            System.out.println("ok");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return createdConnection;
    }
}
