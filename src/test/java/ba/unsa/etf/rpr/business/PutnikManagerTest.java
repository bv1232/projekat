package ba.unsa.etf.rpr.business;

import static org.junit.jupiter.api.Assertions.*;

import ba.unsa.etf.rpr.Domain.Putnik;
import ba.unsa.etf.rpr.Exception.KartaException;
import org.junit.jupiter.api.*;
class PutnikManagerTest {
    PutnikManager putnikManager = new PutnikManager();
    @Test
    void uniqueUsernameTest() throws KartaException {
        Putnik putnik = new Putnik();
        putnik.setUsername("new");
        putnikManager.add(putnik);
        Assertions.assertThrows(KartaException.class, () -> {
            putnikManager.add(putnik);
        });
        putnikManager.delete(putnik.getId());
    }

    @Test
    void addPutnikTest() throws KartaException {
        Putnik putnik = new Putnik();
        putnik.setUsername("putnik");
        putnikManager.add(putnik);
        boolean doesExist = false;
        if(putnikManager.doesUsernameExist(putnik.getId())) doesExist = true;
        Assertions.assertTrue(doesExist);
        putnikManager.delete(putnik.getId());
    }

    @Test
    void deletePutnikTest() throws KartaException {
        Putnik putnik = new Putnik();
        putnik.setUsername("putnik");
        putnikManager.add(putnik);
        putnikManager.delete(putnik.getId());
        boolean doesExist = true;
        if(putnikManager.doesUsernameExist(putnik.getId())) doesExist = false;
        Assertions.assertTrue(doesExist);
    }

    @Test
    void logInTest() throws KartaException {
        Putnik putnik = new Putnik();
        putnik.setUsername("putnik");
        putnik.setPassword("putnik");
        putnikManager.add(putnik);
        Putnik temp = putnikManager.getById(putnikManager.logInId(putnik.getUsername(), putnik.getPassword()));
        Assertions.assertEquals(putnik,temp);
        putnikManager.delete(putnik.getId());
    }
}