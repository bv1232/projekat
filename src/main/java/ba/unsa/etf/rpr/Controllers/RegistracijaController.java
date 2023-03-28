package ba.unsa.etf.rpr.Controllers;

import ba.unsa.etf.rpr.Domain.Putnik;
import ba.unsa.etf.rpr.Exception.KartaException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

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
        if(lozinkaId.getText().isEmpty() || imeId.getText().isEmpty() || prezimeId.getText().isEmpty() || mailId.getText().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setContentText("All fields must be filled out!");
            alert.showAndWait();
            return;
        }
    }
    public void cancelButtonClick(ActionEvent actionEvent){
        Stage stage = (Stage) cancelButtonId.getScene().getWindow();
        stage.close();
    }
}
