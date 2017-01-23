package ua.training.model.dao.jdbc;

import ua.training.model.dao.ProjectDao;
import ua.training.model.entity.Project;
import ua.training.utils.date.ConvertDate;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by andrii on 20.01.17.
 */
public class JdbcProjectDao extends AbstractJdbcDao<Project> implements ProjectDao {
    private static final String DELETE_PROJECT_BY_ID =
            "DELETE FROM project WHERE id = ? ";
    private static final String INSERT_INTO_PROJECT = "INSERT INTO " +
            "project (name, statement_of_work_id, start_date, end_date, manager_id, bill)" +
            " VALUES ( ?, ?, ?, ?, ?, ? ) ";
    private static final String SELECT_FROM_PROJECT = "SELECT * FROM project ";

    public static final String ID = "id";
    public static final String NAME = "name";
    public static final String STATEMENT_OF_WORK_ID = "statement_of_work_id";
    public static final String START_DATE = "start_date";
    public static final String END_DATE = "end_date";
    public static final String MANAGER_ID = "manager_id";
    public static final String BILL = "bill";

    public JdbcProjectDao(Connection connection) {
        super(connection);
    }

    @Override
    protected String getSelectAllQuery() {
        return SELECT_FROM_PROJECT;
    }

    @Override
    protected String getCreateQuery() {
        return INSERT_INTO_PROJECT;
    }

    @Override
    protected String getUpdateQuery() {
        throw new UnsupportedOperationException();
    }

    @Override
    protected String getDeleteQuery() {
        return DELETE_PROJECT_BY_ID;
    }

    @Override
    protected Project getEntityFromResultSet(ResultSet resultSet) throws SQLException {
        return new Project.Builder()
                .setId(resultSet.getInt(ID))
                .setName(resultSet.getString(NAME))
                .setStartDate(ConvertDate.convertDateToLocalDate(resultSet.getDate(START_DATE)))
                .setEndDate(ConvertDate.convertDateToLocalDate(resultSet.getDate(END_DATE)))
                .setStatementOfWorkId(resultSet.getInt(STATEMENT_OF_WORK_ID))
                .setManagerId(resultSet.getInt(MANAGER_ID))
                .setBill(resultSet.getInt(BILL))
                .build();
    }

    @Override
    protected void setIdForEntity(Project entity, int id) {
        entity.setId(id);
    }

    @Override
    protected void prepareStatementForInsert(PreparedStatement query, Project entity)
            throws SQLException {
        query.setString(1 , entity.getName());
        query.setInt(2, entity.getStatementOfWorkId());
        query.setDate(3, ConvertDate.convertLocalDateToDate(entity.getStartDate()));
        query.setDate(4 , ConvertDate.convertLocalDateToDate(entity.getEndDate()));
        query.setInt(5 , entity.getManagerId());
        query.setInt(6, entity.getBill());
    }

    @Override
    protected void prepareStatementForUpdate(PreparedStatement query, Project entity) {
        throw new UnsupportedOperationException();
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Project find(Integer id) {
        return null;
    }

}
