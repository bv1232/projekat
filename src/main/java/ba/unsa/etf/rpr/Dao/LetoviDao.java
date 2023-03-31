package ba.unsa.etf.rpr.Dao;

import ba.unsa.etf.rpr.Domain.Let;
import ba.unsa.etf.rpr.Exception.KartaException;

public interface LetoviDao extends Dao<Let>{
    Let getByKrajnjaDestinacija(String krajnja) throws KartaException;
}
