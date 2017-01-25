package ua.training.model.dao.jdbc;

import ua.training.model.dao.DeveloperHasTaskDao;
import ua.training.model.entity.DeveloperHasTask;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

/**
 * Created by andrii on 20.01.17.
 */
public class JdbcDeveloperHasTaskDao extends AbstractJdbcDao<DeveloperHasTask>
        implements DeveloperHasTaskDao {
    private static final String INSERT_INTO_DEVELOPER_HAS_TASK = "INSERT INTO " +
            "developer_has_task (developer_id, task_id, project_id, elapsed_time)" +
            " VALUES ( ?, ?, ?, ? ) ";
    private static final String SELECT_FROM_DEVELOPER_HAS_TASK =
            "SELECT * FROM developer_has_task ";

    public static final String DEVELOPER_ID = "developer_id";
    public static final String TASK_ID = "task_id";
    public static final String PROJECT_ID = "project_id";
    public static final String ELAPSED_TIME = "elapsed_time";

    public JdbcDeveloperHasTaskDao(Connection connection) {
        super(connection);
    }

    @Override
    protected String getSelectAllQuery() {
        return SELECT_FROM_DEVELOPER_HAS_TASK;
    }

    @Override
    protected String getCreateQuery() {
        return INSERT_INTO_DEVELOPER_HAS_TASK;
    }

    @Override
    protected String getUpdateQuery() {
        throw new UnsupportedOperationException();
    }

    @Override
    protected String getDeleteQuery() {
        throw new UnsupportedOperationException();
    }

    @Override
    protected DeveloperHasTask getEntityFromResultSet(ResultSet resultSet) throws SQLException {
        return new DeveloperHasTask.Builder()
                .setDeveloperId(resultSet.getInt(DEVELOPER_ID))
                .setTaskId(resultSet.getInt(TASK_ID))
                .setProjectId(resultSet.getInt(PROJECT_ID))
                .setElapsedTime(resultSet.getInt(ELAPSED_TIME))
                .build();
    }

    @Override
    protected void setIdForEntity(DeveloperHasTask entity, int id) {
        throw new UnsupportedOperationException();
    }

    @Override
    protected void prepareStatementForInsert(PreparedStatement query, DeveloperHasTask entity)
            throws SQLException {
        query.setInt(1 , entity.getDeveloperId());
        query.setInt(2, entity.getTaskId());
        query.setInt(3, entity.getProjectId());
        query.setInt(4, entity.getElapsedTime());
    }

    @Override
    protected void prepareStatementForUpdate(PreparedStatement query, DeveloperHasTask entity) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Optional<DeveloperHasTask> find(Integer id) {
        throw new UnsupportedOperationException();
    }

    @Override
    protected String getSelectByIdQuery() {
        throw new UnsupportedOperationException();
    }

}
