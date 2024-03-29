package ba.unsa.etf.rpr.Domain;
import java.sql.Time;
import java.util.Date;
import java.util.Objects;

public class Let implements Idable{
    private int id;
    private String pocetnaDestinacija, krajnjaDestinacija;
    private Date datum;
    private Time vrijemePolaska;
    private String terminal;

    public void setId(int id) {
        this.id = id;
    }

    public void setPocetnaDestinacija(String pocetnaDestinacija) {
        this.pocetnaDestinacija = pocetnaDestinacija;
    }

    public void setKrajnjaDestinacija(String krajnjaDestinacija) {
        this.krajnjaDestinacija = krajnjaDestinacija;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public void setVrijemePolaska(Time vrijemePolaska) {
        this.vrijemePolaska = vrijemePolaska;
    }

    public void setTerminal(String terminal) {
        this.terminal = terminal;
    }

    public int getId() {
        return id;
    }

    public String getPocetnaDestinacija() {
        return pocetnaDestinacija;
    }

    public String getKrajnjaDestinacija() {
        return krajnjaDestinacija;
    }

    public Date getDatum() {
        return datum;
    }

    public Time getVrijemePolaska() {
        return  vrijemePolaska;
    }

    public String getTerminal() {
        return terminal;
    }

    public Let(int id, String pocetnaDestinacija, String krajnjaDestinacija, Date datum, Time vrijemePolaska, String terminal) {
        this.id = id;
        this.pocetnaDestinacija = pocetnaDestinacija;
        this.krajnjaDestinacija = krajnjaDestinacija;
        this.datum = datum;
        this.vrijemePolaska = vrijemePolaska;
        this.terminal = terminal;
    }
    public Let(){

    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Let let = (Let) o;
        return id == let.id && Objects.equals(pocetnaDestinacija, let.pocetnaDestinacija) && Objects.equals(krajnjaDestinacija, let.krajnjaDestinacija) && Objects.equals(datum, let.datum) && Objects.equals(vrijemePolaska, let.vrijemePolaska) && Objects.equals(terminal, let.terminal);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, pocetnaDestinacija, krajnjaDestinacija, datum, vrijemePolaska, terminal);
    }

    @Override
    public String toString() {
        return "Let{" +
                "id=" + id +
                ", pocetnaDestinacija='" + pocetnaDestinacija + '\'' +
                ", krajnjaDestinacija='" + krajnjaDestinacija + '\'' +
                ", datum=" + datum +
                ", vrijemePolaska=" + vrijemePolaska +
                ", paviljon='" + terminal + '\'' +
                '}';
    }
}
