package ba.unsa.etf.rpr.Dao;
import ba.unsa.etf.rpr.Exception.KartaException;

import java.sql.SQLException;
import java.util.List;
public interface Dao<T> {

    T getById(int id) throws KartaException;
    T add(T item) throws KartaException;
    T update(T item) throws KartaException;
    void delete(int id) throws KartaException;
    List<T> getAll() throws KartaException;
}
