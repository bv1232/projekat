package ba.unsa.etf.rpr.Classes;

import java.util.Objects;

public class Karta {
 private int id;
 private Let let;
 private Putnik putnik;
 private String sjediste;
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

    public void setSjediste(String sjediste) {
        this.sjediste = sjediste;
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

    public String getSjediste() {
        return sjediste;
    }

    public String getKlasa() {
        return klasa;
    }

    public Karta(int id, Let let, Putnik putnik, String sjediste, String klasa) {
        this.id = id;
        this.let = let;
        this.putnik = putnik;
        this.sjediste = sjediste;
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
        return id == karta.id && Objects.equals(let, karta.let) && Objects.equals(putnik, karta.putnik) && Objects.equals(sjediste, karta.sjediste) && Objects.equals(klasa, karta.klasa);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, let, putnik, sjediste, klasa);
    }

    @Override
    public String toString() {
        return "Karta{" +
                "id=" + id +
                ", let=" + let +
                ", putnik=" + putnik +
                ", sjediste='" + sjediste + '\'' +
                ", klasa='" + klasa + '\'' +
                '}';
    }
}
