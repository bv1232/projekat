package ba.unsa.etf.rpr.Dao;

import ba.unsa.etf.rpr.Classes.Karta;
import ba.unsa.etf.rpr.Classes.Let;
import sun.security.x509.OtherName;

import java.io.IOException;
import java.sql.*;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.TreeMap;

public class LetoviDaoSQLImpl implements LetoviDao{

    private Connection connection;
    private String tableName;
    public LetoviDaoSQLImpl(String tableName) throws IOException {
        try {
            this.tableName = tableName;
            Properties p = new Properties();
            p.load(ClassLoader.getSystemResource("app.properties").openStream());
            String url = p.getProperty("db.connection_string");
            String username = p.getProperty("db.username");
            String password = p.getProperty("db.password");
            this.connection = DriverManager.getConnection(url, username, password);
        }catch (Exception e){
            System.out.println("Nemoguce uspostaviti konekciju sa bazom");
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return this.connection;
    }
    public Object row2objects(ResultSet rs) throws SQLException {
        try {
            Let let = new Let();
            let.setId(rs.getInt("id"));
            let.setPocetnaDestinacija(rs.getString("pocetna destinacija"));
            let.setKrajnjaDestinacija(rs.getString("krajnja destinacija"));
            let.setDatum(rs.getDate("datum"));
            let.setVrijemePolaska(rs.getTime("polazak"));
            let.setPaviljon(rs.getString("paviljon"));
            return let;
        }catch (SQLException e){
            throw new SQLException(e.getMessage(),e);
        }
    }
    public Map<String,Object> object2row(Let object){
        Map<String,Object> item = new TreeMap<String,Object>();
        item.put("id",object.getId());
        item.put("pocetna destinacija", object.getPocetnaDestinacija());
        item.put("krajnja destinacija", object.getKrajnjaDestinacija());
        item.put("datum", object.getDatum());
        item.put("polazak", object.getVrijemePolaska());
        item.put("paviljon", object.getPaviljon());
        return item;
    }
    @Override
    public Object getById(int id) throws SQLException {
        String query = "SELECT * FROM " + this.tableName + " WHERE id = ?";
        try {
            PreparedStatement stmt = this.connection.prepareStatement(query);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                Object result = row2objects(rs);
                rs.close();
                return result;
            }else{
                throw new SQLException("Objekat nije pronadjen");
            }
        }catch (SQLException e){
            throw new SQLException(e.getMessage(),e);
        }
    }

    @Override
    public Object add(Object item) {
        return null;
    }

    @Override
    public Object update(Object item) {
        return null;
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public List getAll() {
        return null;
    }
}
