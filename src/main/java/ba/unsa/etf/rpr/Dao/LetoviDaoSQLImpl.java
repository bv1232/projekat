package ba.unsa.etf.rpr.Dao;

import ba.unsa.etf.rpr.Domain.Karta;
import ba.unsa.etf.rpr.Domain.Let;
import ba.unsa.etf.rpr.Exception.KartaException;

import java.sql.*;
import java.util.*;
import java.util.Date;

public class LetoviDaoSQLImpl extends AbstractDao<Let> implements LetoviDao{

    public LetoviDaoSQLImpl() {
        super("letovi");
    }

    @Override
    public Let row2object(ResultSet rs) throws KartaException {
        try {
            Let let = new Let();
            let.setId(rs.getInt("id"));
            let.setDatum(rs.getDate("datum"));
            let.setVrijemePolaska(rs.getTime("polazak"));
            let.setPocetnaDestinacija(rs.getString("pocetnaDestinacija"));
            let.setKrajnjaDestinacija(rs.getString("krajnjaDestinacija"));
            let.setTerminal(rs.getString("terminal"));
            return let;
        } catch (SQLException e) {
            throw new KartaException(e.getMessage(), e);
        }
    }

    @Override
    public Map<String, Object> object2row(Let object) {
        Map<String, Object> row = new TreeMap<>();
        row.put("id", object.getId());
        row.put("pocetnaDestinacija", object.getPocetnaDestinacija());
        row.put("krajnjaDestinacija", object.getKrajnjaDestinacija());
        row.put("datum", object.getDatum());
        row.put("polazak", object.getVrijemePolaska());
        row.put("terminal", object.getTerminal());
        return row;
    }

    @Override
    public Let getByKrajnjaDestinacija(String krajnja) throws KartaException {
        try {
            List<Let> letovi = executeQuery("SELECT * FROM letovi WHERE krajnja destinacija = ?", new Object[]{krajnja});
            return letovi.get(0);
        }catch (KartaException e){
            throw new KartaException(e.getMessage(),e);
        }
    }

    @Override
    public List<Integer> getAllByDatum(Date date) throws KartaException {
        String query = "SELECT * FROM letovi WHERE datum = ?";
        List<Integer> letovi = new ArrayList<Integer>();
        try {
            PreparedStatement stmt = this.getConnection().prepareStatement(query);
            stmt.setDate(1, (java.sql.Date) date);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                letovi.add(rs.getInt("id"));
            }
            rs.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return letovi;
    }

    @Override
    public List<Let> getAllById(List<Integer> ids) throws KartaException {
        if(ids.isEmpty()) return new ArrayList<Let>();
        String query = "SELECT * FROM letovi WHERE id IN (" + String.join(",", Collections.nCopies(ids.size(), "?")) + ")";
        List<Let> letovi = new ArrayList<>();
        try {
            PreparedStatement stmt = this.getConnection().prepareStatement(query);
            for (int i = 0; i < ids.size(); i++) {
                stmt.setInt(i+1, ids.get(i));
            }
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                Let let = new Let();
                let.setId(rs.getInt("id"));
                let.setDatum(rs.getDate("datum"));
                let.setVrijemePolaska(rs.getTime("polazak"));
                let.setPocetnaDestinacija(rs.getString("pocetnaDestinacija"));
                let.setKrajnjaDestinacija(rs.getString("krajnjaDestinacija"));
                let.setTerminal(rs.getString("terminal"));
                letovi.add(let);
            }
            rs.close();
            return letovi;
        } catch (SQLException e) {
            throw new KartaException(e.getMessage(), e);
        }
    }
}
