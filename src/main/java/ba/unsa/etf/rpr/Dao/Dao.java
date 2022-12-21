package ba.unsa.etf.rpr.Dao;
import java.sql.SQLException;
import java.util.List;
public interface Dao<T> {

    T getById(int id) throws SQLException;
    T add(T item);
    T update(T item);
    void delete(int id);
    List<T> getAll();
}
