package ba.unsa.etf.rpr.Controllers;

import ba.unsa.etf.rpr.Domain.Putnik;
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
    public Button okButttonId;
    public Button cancelButtonId;
    private  String username,password;


    public RegistracijaController(String username, String password) {
        this.username=username;
        this.password=password;
    }

    public void createUser(ActionEvent actionEvent) {
        Putnik putnik = new Putnik();

    }

    @FXML
    public void initialize(){
        lozinkaId.setText(username);
    }
}
