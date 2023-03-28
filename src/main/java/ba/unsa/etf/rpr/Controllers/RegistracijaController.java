package ba.unsa.etf.rpr.Controllers;

import ba.unsa.etf.rpr.Domain.Putnik;
import ba.unsa.etf.rpr.Exception.KartaException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class RegistracijaController {

    public PasswordField lozinkaId;
    public TextField mailId;
    public TextField prezimeId;
    public TextField imeId;
    public Button okButtonId;
    public Button cancelButtonId;
    private  String username,password;


    public RegistracijaController(String username, String password) {
        this.username=username;
        this.password=password;
    }



    @FXML
    public void initialize(){

        lozinkaId.setText(username);
    }

    public void okButtonClick(ActionEvent actionEvent) throws KartaException{

    }
}
