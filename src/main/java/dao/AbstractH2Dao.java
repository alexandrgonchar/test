package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @autor Александр
 * @version 1.0
 */
public abstract class AbstractH2Dao<T extends Object> {

    private Connection connection =
            new Connector("sa", "", "jdbc:h2:~/test", "org.h2.Driver")
                    .getConnection();

    /**
     * Возвращает sql запрос для вставки новой записи в базу данных.
     * <p/>
     * INSERT INTO [Table] ([column, column, ...]) VALUES (?, ?, ...);
     */
    public abstract String getCreateQuery();

    /**
     * Возвращает sql запрос для получения всех записей.
     * <p/>
     * SELECT * FROM [Table]
     */
    public abstract String getSelectQuery();

    /**
     * Возвращает sql запрос для обновления записи.
     * <p/>
     * UPDATE [Table] SET [column = ?, column = ?, ...] WHERE id = ?;
     */
    public abstract String getUpdateQuery();

    /**
     * Возвращает sql запрос для удаления записи из базы данных.
     * <p/>
     * DELETE FROM [Table] WHERE id= ?;
     */
    public abstract String getDeleteQuery();

    /**
     * Разбирает ResultSet и возвращает список объектов соответствующих содержимому ResultSet.
     */
    protected abstract List<T> parseResultSet(ResultSet resultSet);

    /**
     * Устанавливает аргументы insert или update запроса в соответствии со значением полей объекта object.
     */
    protected abstract void prepareStatementForInsertOrUpdate(PreparedStatement statement, T object);

    /**
     * Устанавливает аргументы delete запроса в соответствии со значением полей объекта object.
     */
    protected abstract void prepareStatementForDelete(PreparedStatement statement, T object);

    /**
     * В качестве аргумента принимает обьект entity слоя.
     * @return обьект созданый с помощью операции create используя переопределенные
     * методи getCreateQuery и prepareStatementForInsertOrUpdate.
     */
    public T createFromObject (T object) throws SQLException{

        String sql = getCreateQuery();

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){

            prepareStatementForInsertOrUpdate(preparedStatement, object);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return object;
    }

    /**
     * @return List обьектов entity слоя с помощью операции getAll используя
     * переопределенные методы getCreateQuery и parseResultSet.
     */
    public List<T> getAllObjects () throws SQLException{
        List<T> list = new ArrayList<>();

        String sql = getSelectQuery();

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            ResultSet resultSet = statement.executeQuery();
            list = parseResultSet(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    /**
     * @return обект entity слоя по id с помощью операции getById используя
     * переопределенные методы getCreateQuery и parseResultSet.
     */
    public T getObjectById (Long id) throws SQLException {

        List<T> list = new ArrayList<>();
        String sql = getSelectQuery();
        sql += " WHERE ID = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            list = parseResultSet(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (list == null || list.size() == 0) {
            return null;
        }
        if (list.size() > 1) {
            throw new SQLException();
        }

        return list.iterator().next();
    }

    /**
     * @return обект entity слоя по firstId и secondId с помощью операции getById используя
     * переопределенные методы getCreateQuery и parseResultSet.
     */
    public T getObjectByIds (Long firstId, Long secondId) throws SQLException {

        List<T> list = new ArrayList<>();
        String sql = getSelectQuery();
        sql += " WHERE STUDENT_ID = ? AND SUBJECT_ID = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setLong(1, firstId);
            statement.setLong(2, secondId);

            ResultSet resultSet = statement.executeQuery();

            list = parseResultSet(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (list == null || list.size() == 0) {
            return null;
        }
        if (list.size() > 1) {
            throw new SQLException();
        }

        return list.iterator().next();
    }

    /**
     * Реализация операции update с использованием переопределенного
     * метода getCreateQuery и prepareStatementForInsertOrUpdate. В качестве аргумента
     * принимает обьект entity слоя.
     */
    public void updateObject (T object) throws SQLException {

        String sql = getUpdateQuery();

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            prepareStatementForInsertOrUpdate(statement, object);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Реализация операции delete с использованием переопределенного
     * метода getCreateQuery и prepareStatementForDelete. В качестве аргумента
     * принимает обьект entity слоя.
     */
    public void deleteObject (T object) throws SQLException {

        String sql = getDeleteQuery();

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            prepareStatementForDelete(statement, object);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
