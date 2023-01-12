package ba.unsa.etf.rpr.business;

import ba.unsa.etf.rpr.Dao.DaoFactory;
import ba.unsa.etf.rpr.Domain.Karta;
import ba.unsa.etf.rpr.Exception.KartaException;

import java.util.List;

public class KartaManager {
    public Karta add(Karta karta) throws KartaException{
        try{
            return DaoFactory.karteDao().add(karta);
        }catch (KartaException e){
            throw new KartaException(e.getMessage(),e);
        }
    }

    public void delete(int kartaId) throws KartaException{
        try {
            DaoFactory.karteDao().delete(kartaId);
        }catch (KartaException e){
            throw new KartaException(e.getMessage(),e);
        }
    }

    public Karta update(Karta karta) throws KartaException{
        return DaoFactory.karteDao().update(karta);
    }

    public Karta getById(int id) throws KartaException{
        return DaoFactory.karteDao().getById(id);
    }
    public List<Karta> getAll() throws KartaException{
        return DaoFactory.karteDao().getAll();
    }
}
