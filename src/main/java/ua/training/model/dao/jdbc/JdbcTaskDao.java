package ua.training.model.dao.jdbc;

import ua.training.model.dao.TaskDao;
import ua.training.model.entity.StatementOfWork;
import ua.training.model.entity.Task;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by andrii on 20.01.17.
 */
public class JdbcTaskDao implements TaskDao {
    private static final String SELECT_FROM_TASK = "SELECT * FROM task " +
            "JOIN task_requirements ON task.id = task_requirements.task_id ";

    private static final String ID = "id";
    private static final String NAME = "name";
    private static final String DESCRIPTION = "description";
    private static final String STATEMENT_OF_WORK = "statement_of_work";
    private static final String IS_FINISHED = "is_finished";

    private static final String QUALIFICATION = "qualification";
    private static final String DEVELOPERS_NUMBER = "developers_number";

    private Connection connection;

    public JdbcTaskDao(Connection connection) {
        this.connection = connection;
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Task find(Integer id) {
        return null;
    }

    @Override
    public List<Task> findAll() {
        List<Task> result = new ArrayList<>();
        try(Statement query =
                    connection.createStatement();
            ResultSet resultSet = query.executeQuery(SELECT_FROM_TASK)){
            while (resultSet.next()) {
                result.add( getTaskFromResultSet(resultSet));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    private Task getTaskFromResultSet(ResultSet rs) throws SQLException {
        return new Task.Builder()
                .setId(rs.getInt(ID))
                .setName(rs.getString(NAME))
                .setDescription(rs.getString(DESCRIPTION))
                //.setStatementOfWork()
                // todo: set requirements
                .build();

        /*
            private Integer id;
            private String name;
            private String description;
            private StatementOfWork statementOfWork;
            private HashMap<Qualification, Integer> taskRequirements; // qualification / developersNumber
            private Boolean isFinished;
        */
    }

    @Override
    public void create(Task task) {

    }

    @Override
    public void update(Task task) {

    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public List<Task> findByName(String name) {
        return null;
    }

    @Override
    public List<Task> findByStatementOfWork(StatementOfWork statementOfWork) {
        return null;
    }
}
