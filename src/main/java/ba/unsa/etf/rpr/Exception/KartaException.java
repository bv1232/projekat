package ba.unsa.etf.rpr.Exception;

public class KartaException extends Exception{
    public KartaException(String text, Exception exception){
        super(text,exception);
    }
    public KartaException(Exception text){
        super(text);
    }
}
