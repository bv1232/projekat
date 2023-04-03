package ba.unsa.etf.rpr.business;

import ba.unsa.etf.rpr.Dao.DaoFactory;
import ba.unsa.etf.rpr.Domain.Let;
import ba.unsa.etf.rpr.Exception.KartaException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;
class LetManagerTest {
    private LetManager letManager;

    @Mock
    private DaoFactory daoFactory;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        letManager = new LetManager();
    }

    @Test
    void testAddMethod() throws KartaException {
        Let let = new Let();
        when(daoFactory.letoviDao().add(any(Let.class))).thenReturn(let);
        Let addedLet = letManager.add(let);
        assertEquals(let, addedLet);
    }

    @Test
    void testAddMethodWithException() throws KartaException {
        Let let = new Let();
        String message = "Error while adding let";
        doThrow(new KartaException(message)).when(daoFactory.letoviDao()).add(any(Let.class));
        assertThrows(KartaException.class, () -> letManager.add(let), message);
    }
}