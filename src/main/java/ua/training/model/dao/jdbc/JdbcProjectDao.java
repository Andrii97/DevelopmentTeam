package ua.training.model.dao.jdbc;

import org.apache.log4j.Logger;
import ua.training.model.dao.ProjectDao;
import ua.training.model.dao.exception.DaoException;
import ua.training.model.entity.Project;
import ua.training.utils.date.ConvertDate;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

/**
 * Created by andrii on 20.01.17.
 */
public class JdbcProjectDao extends AbstractJdbcDao<Project> implements ProjectDao {
    private static final String DELETE_PROJECT_BY_ID =
            "DELETE FROM project WHERE id = ? ";
    private static final String INSERT_INTO_PROJECT = "INSERT INTO " +
            "project (name, statement_of_work_id, start_date, end_date, manager_id, bill)" +
            " VALUES ( ?, ?, ?, ?, ?, ? ) ";
    private static final String SELECT_FROM_PROJECT = "SELECT * FROM project " +
            "JOIN user ON project.manager_id = user.id " +
            "JOIN statement_of_work ON statement_of_work.id = project.statement_of_work_id ";
    private static final String WHERE_ID = "WHERE project.id = ? ";

    private static final String ID = "project.id";
    private static final String NAME = "project.name";
    private static final String STATEMENT_OF_WORK_ID = "project.statement_of_work_id";
    private static final String START_DATE = "project.start_date";
    private static final String END_DATE = "project.end_date";
    private static final String MANAGER_ID = "project.manager_id";
    private static final String BILL = "project.bill";

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
                .setStatementOfWork(JdbcStatementOfWorkDao.getStatementOfWorkFromResultSet(resultSet))
                .setManager(JdbcUserDao.getUserFromResultSet(resultSet))
                .setBill(resultSet.getLong(BILL))
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
        query.setInt(2, entity.getStatementOfWork().getId());
        query.setDate(3, ConvertDate.convertLocalDateToDate(entity.getStartDate()));
        query.setDate(4 , ConvertDate.convertLocalDateToDate(entity.getEndDate()));
        query.setInt(5 , entity.getManager().getId());
        query.setLong(6, entity.getBill());
    }

    @Override
    protected void prepareStatementForUpdate(PreparedStatement query, Project entity) {
        throw new UnsupportedOperationException();
    }

    @Override
    protected String getSelectByIdQuery() {
        return SELECT_FROM_PROJECT + WHERE_ID;
    }

}
