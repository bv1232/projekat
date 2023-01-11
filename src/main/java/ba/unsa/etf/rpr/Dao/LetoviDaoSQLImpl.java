package ba.unsa.etf.rpr.Dao;

import ba.unsa.etf.rpr.Domain.Let;

import java.sql.*;
import java.util.Map;
import java.util.TreeMap;

public class LetoviDaoSQLImpl extends AbstractDao<Let> implements LetoviDao{

    public LetoviDaoSQLImpl() {
        super("letovi");
    }

    @Override
    public Let row2object(ResultSet rs) throws Exception {
        try {
            Let let = new Let();
            let.setId(rs.getInt("id"));
            let.setDatum(rs.getDate("datum"));
            let.setVrijemePolaska(rs.getTime("polazak"));
            let.setPocetnaDestinacija(rs.getString("pocetna destinacija"));
            let.setKrajnjaDestinacija(rs.getString("krajnja destinacija"));
            let.setTerminal(rs.getString("terminal"));
            return let;
        } catch (SQLException e) {
            throw new Exception(e.getMessage(), e);
        }
    }

    @Override
    public Map<String, Object> object2row(Let object) {
        Map<String, Object> row = new TreeMap<>();
        row.put("id", object.getId());
        row.put("datum", object.getDatum());
        row.put("polazak", object.getVrijemePolaska());
        row.put("pocetna destinacija", object.getPocetnaDestinacija());
        row.put("krajnja destinacija", object.getKrajnjaDestinacija());
        row.put("terminal", object.getTerminal());
        return row;
    }
}
