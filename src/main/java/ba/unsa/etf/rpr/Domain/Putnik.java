package ba.unsa.etf.rpr.Domain;

import java.util.Objects;

public class Putnik implements Idable{
    private int id;
    private String ime, prezime, mail, username, password;

    public void setId(int id) {
        this.id = id;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public int getId() {
        return id;
    }

    public String getIme() {
        return ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public String getMail() {
        return mail;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
    public Putnik(int id, String ime, String prezime, String mail, String username, String password) {
        this.id = id;
        this.ime = ime;
        this.prezime = prezime;
        this.mail = mail;
        this.username = username;
        this.password = password;
    }
    public Putnik(){}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Putnik putnik = (Putnik) o;
        return id == putnik.id && Objects.equals(ime, putnik.ime) && Objects.equals(prezime, putnik.prezime) && Objects.equals(mail, putnik.mail) && Objects.equals(username, putnik.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, ime, prezime, mail, username);
    }

    @Override
    public String toString() {
        return "Putnik{" +
                "id=" + id +
                ", ime='" + ime + '\'' +
                ", prezime='" + prezime + '\'' +
                ", mail='" + mail + '\'' +
                ", username='"+ username + '\'' +
                '}';
    }

}
