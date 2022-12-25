package ba.unsa.etf.rpr.Dao;
import java.sql.SQLException;
import java.util.List;
public interface Dao<T> {

    T getById(int id) throws Exception;
    T add(T item) throws Exception;
    T update(T item) throws Exception;
    void delete(int id) throws Exception;
    List<T> getAll() throws Exception;
}
