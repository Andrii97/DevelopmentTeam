package ua.training.model.dao;

/**
 * Created by andrii on 20.01.17.
 */
public interface DaoConnection extends AutoCloseable {
    void begin();
    void commit();
    void rollback();
    void close();
}
