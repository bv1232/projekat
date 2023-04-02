package ba.unsa.etf.rpr.Domain;

import java.util.Objects;

public class Karta implements Idable{
 private int id;
 private Let let;
 private Putnik putnik;
 private String klasa;

    public void setId(int id) {
        this.id = id;
    }

    public void setLet(Let let) {
        this.let = let;
    }

    public void setPutnik(Putnik putnik) {
        this.putnik = putnik;
    }

    public void setKlasa(String klasa) {
        this.klasa = klasa;
    }

    public int getId() {
        return id;
    }

    public Let getLet() {
        return let;
    }

    public Putnik getPutnik() {
        return putnik;
    }

    public String getKlasa() {
        return klasa;
    }

    public Karta(int id, Let let, Putnik putnik, String klasa) {
        this.id = id;
        this.let = let;
        this.putnik = putnik;
        this.klasa = klasa;
    }

    public Karta(){
        this.let = new Let();
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Karta karta = (Karta) o;
        return id == karta.id && Objects.equals(let, karta.let) && Objects.equals(putnik, karta.putnik) && Objects.equals(klasa, karta.klasa);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, let, putnik, klasa);
    }

    @Override
    public String toString() {
        return "Karta{" +
                "id=" + id +
                ", let=" + let +
                ", putnik=" + putnik +
                ", klasa='" + klasa + '\'' +
                '}';
    }
}
