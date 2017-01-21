package ua.training.model.dao.jdbc;

import ua.training.model.dao.StatementOfWorkDao;
import ua.training.model.entity.StatementOfWork;

import java.sql.Connection;
import java.util.List;

/**
 * Created by andrii on 20.01.17.
 */
public class JdbcStatementOfWorkDao implements StatementOfWorkDao {
    private static final String SELECT_FROM_STATEMENT_OF_WORK = "SELECT * FROM statement_of_work ";
    private static final String INSERT_INTO_STATEMENT_OF_WORK = "INSERT INTO " +
            "(name, filing_date, customer_id, is_approved)" +
            " VALUES ( ?, ?, ?, ? ) "; // insert task?
    /*
        private Integer id;
        private String name;
        private LocalDate filingDate;
        private List<Task> tasks;
        private User customer;
        private Boolean isApproved;
    */
    private static final String ID = "id";
    private static final String NAME = "name";
    private static final String FILLING_DATE = "filing_date";
    private static final String CUSTOMER_ID = "customer_id";
    // todo task
    private static final String IS_APPROVED = "is_approved";

    private Connection connection;

    public JdbcStatementOfWorkDao(Connection connection) {
        this.connection = connection;
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

    @Override
    public List<StatementOfWork> findAll() {
        return null;
    }

    @Override
    public void create(StatementOfWork statementOfWork) {

    }

    @Override
    public void update(StatementOfWork statementOfWork) {

    }

    @Override
    public void delete(Integer id) {

    }
}
