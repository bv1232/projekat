package ba.unsa.etf.rpr.Dao;

import ba.unsa.etf.rpr.Classes.Karta;

import java.sql.*;
import java.util.*;

public class KarteDaoSQLImpl extends AbstractDao<Karta> implements KarteDao{

    public KarteDaoSQLImpl() {
        super("karta");
    }

    @Override
    public Karta row2object(ResultSet rs) throws Exception {
        try {
            Karta karta = new Karta();
            karta.setId(rs.getInt("id"));
            karta.setLet(DaoFactory.letoviDao().getById(rs.getInt("idLeta")));
            karta.setKlasa(rs.getString("klasa"));
            karta.setPutnik(DaoFactory.putniciDao().getById(rs.getInt("idPutnika")));
            karta.setSjediste(rs.getString("sjediste"));
            return karta;
        } catch (SQLException e) {
            throw new Exception(e.getMessage(), e);
        }
    }
    @Override
    public Map<String, Object> object2row(Karta object) {
        Map<String, Object> row = new TreeMap<>();
        row.put("id", object.getId());
        row.put("idLeta", object.getLet().getId());
        row.put("klasa", object.getKlasa());
        row.put("idPutnika", object.getPutnik().getId());
        row.put("sjediste", object.getSjediste());
        return row;
    }

}
