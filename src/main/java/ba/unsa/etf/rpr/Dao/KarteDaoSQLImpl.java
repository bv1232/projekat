package ba.unsa.etf.rpr.Dao;

import ba.unsa.etf.rpr.Domain.Karta;
import ba.unsa.etf.rpr.Exception.KartaException;

import java.sql.*;
import java.util.*;

public class KarteDaoSQLImpl extends AbstractDao<Karta> implements KarteDao{

    public KarteDaoSQLImpl() {
        super("karta");
    }

    @Override
    public Karta row2object(ResultSet rs) throws KartaException {
        try {
            Karta karta = new Karta();
            karta.setId(rs.getInt("id"));
            karta.setLet(DaoFactory.letoviDao().getById(rs.getInt("idLeta")));
            karta.setKlasa(rs.getString("klasa"));
            karta.setPutnik(DaoFactory.putniciDao().getById(rs.getInt("idPutnika")));
            return karta;
        } catch (Exception e) {
            throw new KartaException(e.getMessage(), e);
        }
    }
    @Override
    public Map<String, Object> object2row(Karta object) {
        Map<String, Object> row = new TreeMap<>();
        row.put("id", object.getId());
        row.put("idLeta", object.getLet().getId());
        row.put("klasa", object.getKlasa());
        row.put("idPutnika", object.getPutnik().getId());
        return row;
    }

}
