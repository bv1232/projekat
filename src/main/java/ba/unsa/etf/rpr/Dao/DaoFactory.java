package ba.unsa.etf.rpr.Dao;

public class DaoFactory {
    private static final KarteDao karteDao = new KarteDaoSQLImpl();
    private static final LetoviDao letoviDao = new LetoviDaoSQLImpl();
    private static final PutniciDao putniciDao = new PutniciDaoSQLImpl();

    private DaoFactory(){
    }

    public static KarteDao karteDao(){
        return karteDao;
    }

    public static LetoviDao letoviDao(){
        return letoviDao;
    }

    public static PutniciDao putniciDao(){
        return putniciDao;
    }

}
