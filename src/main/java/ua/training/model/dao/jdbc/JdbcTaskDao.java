package ua.training.model.dao.jdbc;

import ua.training.model.dao.TaskDao;
import ua.training.model.entity.StatementOfWork;
import ua.training.model.entity.Task;

import java.sql.*;
import java.util.List;

/**
 * Created by andrii on 20.01.17.
 */
public class JdbcTaskDao extends AbstractJdbcDao<Task> implements TaskDao {
    private static final String DELETE_TASK_BY_ID =
            "DELETE FROM task WHERE id = ? ";
    private static final String INSERT_INTO_STATEMENT_OF_WORK = "INSERT INTO " +
            "task (name, description, statement_of_work_id)" +
            " VALUES ( ?, ?, ? ) ";
    private static final String SELECT_FROM_TASK = "SELECT * FROM task " +
            "JOIN task_requirements ON task.id = task_requirements.task_id ";
    private static final String ID = "id";
    private static final String NAME = "name";
    private static final String DESCRIPTION = "description";
    private static final String STATEMENT_OF_WORK_ID = "statement_of_work_id";
    private static final String IS_FINISHED = "is_finished";

    private static final String QUALIFICATION = "qualification";
    private static final String DEVELOPERS_NUMBER = "developers_number";

    private Connection connection;

    public JdbcTaskDao(Connection connection) {
        super(connection);
    }

    @Override
    protected String getSelectAllQuery() {
        return SELECT_FROM_TASK;
    }

    @Override
    protected String getCreateQuery() {
        return INSERT_INTO_STATEMENT_OF_WORK;
    }

    @Override
    protected String getUpdateQuery() {
        throw new UnsupportedOperationException();
    }

    @Override
    protected String getDeleteQuery() {
        return DELETE_TASK_BY_ID;
    }

    @Override
    protected Task getEntityFromResultSet(ResultSet resultSet) throws SQLException {
        return new Task.Builder()
                .setId(resultSet.getInt(ID))
                .setName(resultSet.getString(NAME))
                .setDescription(resultSet.getString(DESCRIPTION))
                .setStatementOfWorkId(resultSet.getInt(STATEMENT_OF_WORK_ID))
                .setFinished(resultSet.getBoolean(IS_FINISHED))
                // todo: set requirements
                .build();
    }

    @Override
    protected void setIdForEntity(Task entity, int id) {
        entity.setId(id);
    }

    @Override
    protected void prepareStatementForInsert(PreparedStatement query, Task entity)
            throws SQLException {
        query.setString(1 , entity.getName());
        query.setString(2, entity.getDescription());
        query.setInt(3 , entity.getStatementOfWorkId());
    }

    @Override
    protected void prepareStatementForUpdate(PreparedStatement query, Task entity) {

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
    public List<Task> findByName(String name) {
        return null;
    }

    @Override
    public List<Task> findByStatementOfWork(StatementOfWork statementOfWork) {
        return null;
    }
}
