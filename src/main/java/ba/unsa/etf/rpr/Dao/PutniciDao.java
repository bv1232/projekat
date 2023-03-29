package ba.unsa.etf.rpr.Dao;

import ba.unsa.etf.rpr.Domain.Putnik;
import ba.unsa.etf.rpr.Exception.KartaException;

public interface PutniciDao extends Dao<Putnik> {
    int logInId(String username, String password)  throws KartaException;
    boolean doesUsernameExist(String username) throws KartaException;
}
