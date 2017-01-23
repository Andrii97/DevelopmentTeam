package ua.training.model.dao.jdbc;

import ua.training.model.dao.StatementOfWorkDao;
import ua.training.model.entity.StatementOfWork;
import ua.training.utils.date.ConvertDate;

import java.sql.*;

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
            "SELECT * FROM statement_of_work ";

    private static final String ID = "id";
    private static final String NAME = "name";
    private static final String FILLING_DATE = "filing_date";
    private static final String CUSTOMER_ID = "customer_id";
    // todo task
    private static final String IS_APPROVED = "is_approved";

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
        throw new UnsupportedOperationException();
    }

    @Override
    protected String getDeleteQuery() {
        return DELETE_STATEMENT_OF_WORK_BY_ID;
    }

    @Override
    protected StatementOfWork getEntityFromResultSet(ResultSet resultSet) throws SQLException {
        return new StatementOfWork.Builder()
                .setId(resultSet.getInt(ID))
                .setName(resultSet.getString(NAME))
                .setFilingDate(ConvertDate.convertDateToLocalDate(resultSet.getDate(FILLING_DATE)))
                .setCustomerId(resultSet.getInt(CUSTOMER_ID))
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
        query.setInt(3 , entity.getCustomerId());
//        query.setBoolean(4, entity.getApproved());
    }

    @Override
    protected void prepareStatementForUpdate(PreparedStatement query, StatementOfWork entity) {
        throw new UnsupportedOperationException();
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    @Override
    public StatementOfWork find(Integer id) {
        return null;
    }

}
