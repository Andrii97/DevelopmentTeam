package ua.training.model.dao.jdbc;

import org.apache.log4j.Logger;
import ua.training.model.dao.TaskDao;
import ua.training.model.dao.exception.DaoException;
import ua.training.model.entity.*;

import java.sql.*;
import java.util.*;

/**
 * Created by andrii on 20.01.17.
 */
public class JdbcTaskDao extends AbstractJdbcDao<Task> implements TaskDao {
    private static final String DELETE_TASK_BY_ID =
            "DELETE FROM task WHERE id = ? ";
    private static final String INSERT_INTO_TASK = "INSERT INTO " +
            "task (name, description, statement_of_work_id)" +
            " VALUES ( ?, ?, ? ) ";
    private static final String SELECT_FROM_TASK = "SELECT * FROM task " +
            "JOIN task_requirements ON task.id = task_requirements.task_id ";
    private static final String ORDER_BY_ID = "ORDER BY task.id ";
    private static final String WHERE_ID = "WHERE id = ? ";
    private static final String INSERT_INTO_TASK_REQUIREMENTS = "INSERT INTO " +
            "task_requirements (task_id, qualification, developers_number)" +
            " VALUES ( ?, ?, ? ) ";

    private static final String ID = "id";
    private static final String NAME = "name";
    private static final String DESCRIPTION = "description";
    private static final String STATEMENT_OF_WORK_ID = "statement_of_work_id";
    private static final String IS_FINISHED = "is_finished";

    // TaskRequirements
    private static final String TASK_ID = "task_id";
    private static final String QUALIFICATION = "qualification";
    private static final String DEVELOPERS_NUMBER = "developers_number";

    private static Logger logger = Logger.getLogger(JdbcTaskDao.class);

    public JdbcTaskDao(Connection connection) {
        super(connection);
    }

    @Override
    protected String getSelectAllQuery() {
        return SELECT_FROM_TASK + ORDER_BY_ID;
    }

    @Override
    protected String getCreateQuery() {
        return INSERT_INTO_TASK;
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
        return parseResultSet(resultSet);
    }

    public static Task parseResultSet(ResultSet resultSet) throws SQLException {
        return new Task.Builder()
                .setId(resultSet.getInt(ID))
                .setName(resultSet.getString(NAME))
                .setDescription(resultSet.getString(DESCRIPTION))
                .setStatementOfWorkId(resultSet.getInt(STATEMENT_OF_WORK_ID))
                .setFinished(resultSet.getBoolean(IS_FINISHED))
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
        throw new UnsupportedOperationException();
    }

    @Override
    protected String getSelectByIdQuery() {
        return SELECT_FROM_TASK + WHERE_ID;
    }

    @Override
    public List<Task> findAll() {
        List<Task> result = new ArrayList<>();
        try(Statement query =
                    connection.createStatement();
            ResultSet resultSet = query.executeQuery(getSelectAllQuery())) {
            if(resultSet.next()) {
                Task currentTask = getEntityFromResultSet(resultSet);
                List<TaskRequirements> taskRequirementsList = new ArrayList<>();
                taskRequirementsList.add(getTaskRequirementsFromResultSet(resultSet));
                while(resultSet.next()) {
                    Task nextTask = getEntityFromResultSet(resultSet);
                    if(currentTask.getId().equals(nextTask.getId())) {
                        taskRequirementsList.add(getTaskRequirementsFromResultSet(resultSet));
                    } else {
                        currentTask.setTaskRequirements(taskRequirementsList);
                        result.add(currentTask);
                        currentTask = nextTask;
                        taskRequirementsList = new ArrayList<>();
                        taskRequirementsList.add(getTaskRequirementsFromResultSet(resultSet));
                    }
                }
                currentTask.setTaskRequirements(taskRequirementsList);
                result.add(currentTask);
            }
        } catch (SQLException e) {
            logger.error(e);
            throw new DaoException(e);
        }
        return result;
    }

    @Override
    public Optional<Task> find(Integer id) {
        Optional<Task> result = Optional.empty();
        try(PreparedStatement query =
                    connection.prepareStatement(getSelectByIdQuery())){
            query.setInt( 1 , id);
            ResultSet resultSet = query.executeQuery();
            if (resultSet.next()) {
                Task task = getEntityFromResultSet(resultSet);
                List<TaskRequirements> taskRequirementsList = new ArrayList<>();
                taskRequirementsList.add(getTaskRequirementsFromResultSet(resultSet));
                while (resultSet.next()) {
                    taskRequirementsList.add(getTaskRequirementsFromResultSet(resultSet));
                }
                task.setTaskRequirements(taskRequirementsList);
                result = Optional.of(task);
            }
        } catch (SQLException e) {
            logger.error(e);
            throw new DaoException(e);
        }
        return result;
    }

    private TaskRequirements getTaskRequirementsFromResultSet(ResultSet resultSet)
            throws SQLException {
        return new TaskRequirements.Builder()
                .setTaskId(resultSet.getInt(TASK_ID))
                .setQualification(Qualification.valueOf(resultSet.getString(QUALIFICATION)))
                .setDevelopersNumber(resultSet.getInt(DEVELOPERS_NUMBER))
                .build();
    }

    @Override
    public List<Task> findByName(String name) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<Task> findByStatementOfWork(StatementOfWork statementOfWork) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<Task> findByDeveloper(User developer) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void createTaskRequirements(TaskRequirements taskRequirements) {
        try( PreparedStatement query =
                     connection.prepareStatement(INSERT_INTO_TASK_REQUIREMENTS) ){
            prepareStatementForInsertTaskRequirements(query, taskRequirements);
            query.executeUpdate();
        } catch (SQLException e) {
            logger.error(e);
            throw new DaoException(e);
        }
    }

    private void prepareStatementForInsertTaskRequirements(PreparedStatement query,
            TaskRequirements taskRequirements) throws SQLException {
        query.setInt(1, taskRequirements.getTaskId());
        query.setString(2, taskRequirements.getQualification().name());
        query.setInt(3, taskRequirements.getDevelopersNumber());
    }

}
