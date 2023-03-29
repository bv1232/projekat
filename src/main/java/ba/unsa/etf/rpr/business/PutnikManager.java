package ba.unsa.etf.rpr.business;

import ba.unsa.etf.rpr.Dao.DaoFactory;
import ba.unsa.etf.rpr.Domain.Putnik;
import ba.unsa.etf.rpr.Exception.KartaException;

import java.util.List;

public class PutnikManager {
    public Putnik add(Putnik putnik) throws KartaException {
        try {
            return DaoFactory.putniciDao().add(putnik);
        } catch (KartaException e) {
            throw new KartaException(e.getMessage(),e);
        }
    }
    public void delete(int putnikId) throws KartaException{
        try {
            DaoFactory.putniciDao().delete(putnikId);
        } catch (KartaException e) {
            throw new KartaException(e.getMessage(),e);
        }
    }

    public Putnik update(Putnik putnik) throws KartaException {
       return DaoFactory.putniciDao().update(putnik);
    }
    public Putnik getById(int id) throws KartaException{
        return DaoFactory.putniciDao().getById(id);
    }

    public List<Putnik> getAll() throws KartaException{
        return DaoFactory.putniciDao().getAll();
    }

    public int logInId(String username, String password) throws KartaException{
        return DaoFactory.putniciDao().logInId(username, password);
    }
}
