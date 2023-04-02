package ba.unsa.etf.rpr.Controllers;

import ba.unsa.etf.rpr.Exception.KartaException;
import ba.unsa.etf.rpr.business.LetManager;
import ba.unsa.etf.rpr.business.PutnikManager;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class KartaController {
    public Label imePrezimeId;
    public Label letId;
    public Label datumId;
    public Label vrijemeId;
    public Label klasaId;
    public Label paviljonId;
    private Integer idLeta;
    private Integer idPutnika;
    private String klasa;
    private LetManager letManager = new LetManager();
    private PutnikManager putnikManager = new PutnikManager();
    public KartaController(Integer idLeta, Integer idPutnika, String klasa){
        this.idLeta = idLeta;
        this.idPutnika = idPutnika;
        this.klasa = klasa;
    }

    @FXML
    public void initialize() throws KartaException {
        imePrezimeId.setText(putnikManager.getById(idPutnika).getIme() + " " + putnikManager.getById(idPutnika).getPrezime());
        letId.setText(letManager.getById(idLeta).getPocetnaDestinacija() + "-" + letManager.getById(idLeta).getKrajnjaDestinacija());
        datumId.setText(letManager.getById(idLeta).getDatum().toString());
        vrijemeId.setText(letManager.getById(idLeta).getVrijemePolaska().toString());
        klasaId.setText(klasa);
        paviljonId.setText(letManager.getById(idLeta).getTerminal());
    }
}
