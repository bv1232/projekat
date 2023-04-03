package ba.unsa.etf.rpr.business;

import ba.unsa.etf.rpr.Domain.Karta;
import ba.unsa.etf.rpr.Domain.Let;
import ba.unsa.etf.rpr.Domain.Putnik;
import ba.unsa.etf.rpr.Exception.KartaException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.Time;
import java.sql.Time.*;
import java.time.LocalDate;
import java.sql.Date;

import static org.junit.jupiter.api.Assertions.*;

class KartaManagerTest {
    KartaManager kartaManager = new KartaManager();
    LetManager letManager = new LetManager();
    PutnikManager putnikManager = new PutnikManager();

    @Test
    void unexistingPutnikAndLetToKarta() {
        Putnik putnik = new Putnik();
        Let let = new Let();
        putnik.setUsername("putnik");
        let.setPocetnaDestinacija("sarajevo");
        Karta karta = new Karta();
        karta.setPutnik(putnik);
        karta.setLet(let);
        Assertions.assertThrows(KartaException.class, () ->{
            kartaManager.add(karta);
        });
    }
    @Test
    void deletingNonExistingKarta() {
        Assertions.assertThrows(KartaException.class, ()->{
            kartaManager.delete(10000);
        });
    }
    @Test
    void addingDuplicateKarta() throws KartaException {
        Putnik putnik = new Putnik();
        Let let = new Let();
        putnik.setUsername("putnik");
        putnik.setPassword("putnik");
        putnik.setIme("putnik");
        putnik.setPrezime("putnik");
        putnik.setMail("putnik");
        let.setPocetnaDestinacija("sarajevo");
        let.setKrajnjaDestinacija("sarajevo");
        let.setDatum(Date.valueOf(LocalDate.now()));
        let.setVrijemePolaska(Time.valueOf("04:30:00"));
        let.setTerminal("A");
        Karta karta1 = new Karta();
        karta1.setPutnik(putnik);
        karta1.setLet(let);
        Karta karta2 = new Karta();
        karta2.setPutnik(putnik);
        karta2.setLet(let);
        kartaManager.add(karta1);
        Assertions.assertThrows(KartaException.class, () ->{
            kartaManager.add(karta2);
        });
    }

    @Test
    void updatingKarta() throws KartaException {
        // Add a new Karta to the KartaManager
        Putnik putnik = new Putnik();
        Let let = new Let();
        putnik.setUsername("putnik");
        putnik.setPassword("putnik");
        putnik.setIme("putnik");
        putnik.setPrezime("putnik");
        putnik.setMail("putnik");
        let.setPocetnaDestinacija("sarajevo");
        let.setKrajnjaDestinacija("sarajevo");
        let.setDatum(Date.valueOf(LocalDate.now()));
        let.setVrijemePolaska(Time.valueOf("04:30:00"));
        let.setTerminal("A");
        Karta karta = new Karta();
        karta.setPutnik(putnik);
        karta.setLet(let);
        kartaManager.add(karta);

        Karta updatedKarta = new Karta();
        updatedKarta.setId(karta.getId());
        updatedKarta.setPutnik(putnik);
        updatedKarta.setLet(let);
        kartaManager.update(updatedKarta);

        Karta retrievedKarta = kartaManager.getById(karta.getId());
        assertEquals(updatedKarta, retrievedKarta);
    }
}