package ba.unsa.etf.rpr.business;

import ba.unsa.etf.rpr.Dao.DaoFactory;
import ba.unsa.etf.rpr.Domain.Let;
import ba.unsa.etf.rpr.Exception.KartaException;

import java.util.Date;
import java.util.List;

public class LetManager {
    public Let add(Let let) throws KartaException{
        try {
            return DaoFactory.letoviDao().add(let);
        }catch (KartaException e){
            throw new KartaException(e.getMessage(),e);
        }
    }
    public void delete(int letId) throws KartaException{
        try {
            DaoFactory.letoviDao().delete(letId);
        }catch (KartaException e){
            throw new KartaException(e.getMessage(),e);
        }
    }
    public Let update(Let let) throws KartaException{
        return DaoFactory.letoviDao().update(let);
    }

    public Let getById(int id) throws KartaException{
        return DaoFactory.letoviDao().getById(id);
    }
    public List<Let> getAll() throws KartaException{
        return DaoFactory.letoviDao().getAll();
    }
    public Let getByKrajnjaDestinacija(String krajnja) throws KartaException{
        return DaoFactory.letoviDao().getByKrajnjaDestinacija(krajnja);
    }
    public List<Integer> getAllbyDatum(Date date) throws KartaException{
        return DaoFactory.letoviDao().getAllByDatum(date);
    }
    public List<Let> getAllById(List<Integer> ids) throws KartaException{
        return DaoFactory.letoviDao().getAllById(ids);
    }
}
