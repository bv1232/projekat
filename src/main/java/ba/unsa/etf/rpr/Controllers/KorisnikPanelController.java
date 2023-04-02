package ba.unsa.etf.rpr.Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

public class KorisnikPanelController {

    public DatePicker datePickerId;
    public Label usernameLabelId;
    public TextField brKartiId;

    public RadioButton prvaKlasaId;
    public RadioButton biznisKlasaId;
    public RadioButton ekonomskaKlasaId;

    private String username;
    public KorisnikPanelController(String username){
        this.username = username;
    }
    @FXML
    public void initialize(){
        this.usernameLabelId.setText(username);
    }

}
