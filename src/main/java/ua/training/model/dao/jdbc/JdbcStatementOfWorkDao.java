package ua.training.model.dao.jdbc;

import org.apache.log4j.Logger;
import ua.training.model.dao.StatementOfWorkDao;
import ua.training.model.dao.exception.DaoException;
import ua.training.model.entity.StatementOfWork;
import ua.training.model.entity.User;
import ua.training.utils.date.ConvertDate;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by andrii on 20.01.17.
 */
public class JdbcStatementOfWorkDao extends AbstractJdbcDao<StatementOfWork>
        implements StatementOfWorkDao {
    private static final String DELETE_STATEMENT_OF_WORK_BY_ID =
            "DELETE FROM statement_of_work WHERE id = ? ";
    private static final String INSERT_INTO_STATEMENT_OF_WORK = "INSERT INTO " +
            "statement_of_work (name, filing_date, customer_id)" +
            " VALUES ( ?, ?, ? ) "; // insert task? is_approved?
    private static final String SELECT_FROM_STATEMENT_OF_WORK =
            "SELECT * FROM statement_of_work JOIN user ON user.id = statement_of_work.customer_id ";
    public static final String JOIN_ON_TASK =
            "JOIN task ON task.id =  JOIN task_requirements ON task.id = task_requirements.task_id ";
    private static final String UPDATE_STATEMENT_OF_WORK_BY_ID =
            "UPDATE statement_of_work SET name = ?,  filing_date = ?, " +
                    "is_approved = ? WHERE id = ? ";
    private static final String WHERE_ID = "WHERE statement_of_work.id = ? ";
    private static final String WHERE_CUSTOMER_ID = "WHERE statement_of_work.customer_id = ? ";

    private static final String ID = "statement_of_work.id";
    private static final String NAME = "statement_of_work.name";
    private static final String FILLING_DATE = "statement_of_work.filing_date";
    private static final String CUSTOMER_ID = "statement_of_work.customer_id";
    // todo task
    private static final String IS_APPROVED = "statement_of_work.is_approved";

    private static Logger logger = Logger.getLogger(JdbcStatementOfWorkDao.class);

    public JdbcStatementOfWorkDao(Connection connection) {
        super(connection);
    }

    @Override
    protected String getSelectAllQuery() {
        return SELECT_FROM_STATEMENT_OF_WORK;
    }

    @Override
    protected String getCreateQuery() {
        return INSERT_INTO_STATEMENT_OF_WORK;
    }

    @Override
    protected String getUpdateQuery() {
        return UPDATE_STATEMENT_OF_WORK_BY_ID;
    }

    @Override
    protected String getDeleteQuery() {
        return DELETE_STATEMENT_OF_WORK_BY_ID;
    }

    @Override
    protected StatementOfWork getEntityFromResultSet(ResultSet resultSet) throws SQLException {
        return getStatementOfWorkFromResultSet(resultSet);
    }

    static StatementOfWork getStatementOfWorkFromResultSet(ResultSet resultSet) throws SQLException {
        return new StatementOfWork.Builder()
                .setId(resultSet.getInt(ID))
                .setName(resultSet.getString(NAME))
                .setFilingDate(ConvertDate.convertDateToLocalDate(resultSet.getDate(FILLING_DATE)))
                .setCustomer(JdbcUserDao.getUserFromResultSet(resultSet))
                .setApproved(resultSet.getBoolean(IS_APPROVED))
                .build();
    }

    @Override
    protected void setIdForEntity(StatementOfWork entity, int id) {
        entity.setId(id);
    }

    @Override
    protected void prepareStatementForInsert(PreparedStatement query, StatementOfWork entity)
            throws SQLException {
        query.setString(1 , entity.getName());
        query.setDate(2 , ConvertDate.convertLocalDateToDate(entity.getFilingDate()));
        query.setInt(3 , entity.getCustomer().getId());
//        query.setBoolean(4, entity.getApproved());
    }

    @Override
    protected void prepareStatementForUpdate(PreparedStatement query, StatementOfWork entity)
            throws SQLException {
        query.setString(1, entity.getName());
        query.setDate(2, ConvertDate.convertLocalDateToDate(entity.getFilingDate()));
        query.setBoolean(3, entity.getApproved());
        query.setInt(4, entity.getId());
    }

    @Override
    protected String getSelectByIdQuery() {
        return SELECT_FROM_STATEMENT_OF_WORK + WHERE_ID;
    }

    @Override
    public List<StatementOfWork> findByCustomer(User customer) {
        List<StatementOfWork> result = new ArrayList<>();
        try(PreparedStatement query =
                    connection.prepareStatement(SELECT_FROM_STATEMENT_OF_WORK
                            + WHERE_CUSTOMER_ID)){
            query.setInt( 1 , customer.getId());
            ResultSet resultSet = query.executeQuery();
            while (resultSet.next()) {
                result.add( getEntityFromResultSet(resultSet));
            }
        } catch (SQLException e) {
            logger.error(e);
            throw new DaoException(e);
        }
        return result;
    }
}
