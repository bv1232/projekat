package ba.unsa.etf.rpr.Controllers;

import ba.unsa.etf.rpr.Domain.Let;
import ba.unsa.etf.rpr.Exception.KartaException;
import ba.unsa.etf.rpr.business.LetManager;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.util.List;

import static java.sql.Date.valueOf;

public class KorisnikPanelController {

    public DatePicker datePickerId;
    public Label usernameLabelId;
    public TextField brKartiId;

    public RadioButton prvaKlasaId;
    public RadioButton biznisKlasaId;
    public RadioButton ekonomskaKlasaId;
    public TableView<Let> letoviTableId;
    public TableColumn<Let, String> polazakColId;
    public TableColumn<Let, String> krajnjaColId;
    public TableColumn<Let, Time> vrijemeColId;
    public Button cancelButtonId;
    public Button okButtonId;

    private List<Integer> listaDatumi;
    private LocalDate date;
    private LetManager letManager = new LetManager();
    private String username;
    public KorisnikPanelController(String username){
        this.username = username;
    }
    @FXML
    public void initialize(){
        this.usernameLabelId.setText(username);
    }

    public void datePickerSelection() throws KartaException {
        date = datePickerId.getValue();
        listaDatumi = letManager.getAllbyDatum(Date.valueOf(datePickerId.getValue()));

    }
}
