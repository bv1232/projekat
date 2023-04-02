package ba.unsa.etf.rpr.Dao;

import ba.unsa.etf.rpr.Domain.Let;
import ba.unsa.etf.rpr.Exception.KartaException;

import java.util.Date;
import java.util.List;

public interface LetoviDao extends Dao<Let>{
    Let getByKrajnjaDestinacija(String krajnja) throws KartaException;
    List<Integer> getAllByDatum(Date date) throws KartaException;
    List<Let> getAllById(List<Integer> ids) throws KartaException;
}
