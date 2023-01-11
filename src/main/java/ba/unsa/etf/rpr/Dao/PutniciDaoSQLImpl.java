package ba.unsa.etf.rpr.Dao;

import ba.unsa.etf.rpr.Domain.Putnik;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.TreeMap;

public class PutniciDaoSQLImpl extends AbstractDao<Putnik> implements PutniciDao{
    public PutniciDaoSQLImpl() {
        super("putnici");
    }

    @Override
    public Putnik row2object(ResultSet rs) throws Exception {
        try {
            Putnik putnik = new Putnik();
            putnik.setId(rs.getInt("id"));
            putnik.setIme(rs.getString("ime"));
            putnik.setPrezime(rs.getString("prezime"));
            putnik.setMail(rs.getString("mail"));
            return putnik;
        } catch (SQLException e) {
            throw new Exception(e.getMessage(), e);
        }
    }

    @Override
    public Map<String, Object> object2row(Putnik object) {
        Map<String, Object> row = new TreeMap<>();
        row.put("id", object.getId());
        row.put("ime", object.getIme());
        row.put("prezime", object.getPrezime());
        row.put("mail", object.getMail());
        return row;
    }

}
