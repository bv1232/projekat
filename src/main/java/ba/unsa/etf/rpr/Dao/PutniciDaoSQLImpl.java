package ba.unsa.etf.rpr.Dao;

import ba.unsa.etf.rpr.Domain.Putnik;
import ba.unsa.etf.rpr.Exception.KartaException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class PutniciDaoSQLImpl extends AbstractDao<Putnik> implements PutniciDao{
    public PutniciDaoSQLImpl() {
        super("putnici");
    }

    @Override
    public Putnik row2object(ResultSet rs) throws KartaException {
        try {
            Putnik putnik = new Putnik();
            putnik.setId(rs.getInt("id"));
            putnik.setIme(rs.getString("ime"));
            putnik.setPrezime(rs.getString("prezime"));
            putnik.setMail(rs.getString("mail"));
            putnik.setUsername(rs.getString("username"));
            return putnik;
        } catch (SQLException e) {
            throw new KartaException(e.getMessage(), e);
        }
    }

    @Override
    public Map<String, Object> object2row(Putnik object) {
        Map<String, Object> row = new TreeMap<>();
        row.put("id", object.getId());
        row.put("ime", object.getIme());
        row.put("prezime", object.getPrezime());
        row.put("mail", object.getMail());
        row.put("username", object.getUsername());
        return row;
    }

    @Override
    public int logInId(String username, String password) throws KartaException {
        try {
            List<Putnik> list = executeQuery("SELECT * FROM users WHERE user = ? AND password = ?", new Object[]{username, password});
            if (list.isEmpty()) return 0;
            return list.get(0).getId();
        }catch (KartaException e){
            throw new KartaException(e.getMessage(),e);
        }
        }

    @Override
    public boolean doesUsernameExist(String username) throws KartaException {
        return false;
    }
}
