package ba.unsa.etf.rpr.Controllers;

import ba.unsa.etf.rpr.Domain.Putnik;
import ba.unsa.etf.rpr.Exception.KartaException;
import ba.unsa.etf.rpr.business.PutnikManager;
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
    public  TextField userNameId;
    private  String username,password;
    private PutnikManager putnikManager = new PutnikManager();

    public RegistracijaController(String username, String password) {
        this.username=username;
        this.password=password;
    }



    @FXML
    public void initialize(){
        userNameId.setText(username);
        lozinkaId.setText(password);
    }

    public void okButtonClick(ActionEvent actionEvent) throws KartaException{
        if(lozinkaId.getText().isEmpty() || imeId.getText().isEmpty() || prezimeId.getText().isEmpty() || mailId.getText().isEmpty() || userNameId.getText().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setContentText("Sva polja moraju biti popunjena!");
            alert.showAndWait();
            return;
        }
        Putnik putnik = new Putnik();
        putnik.setIme(imeId.getText());
        putnik.setPrezime(prezimeId.getText());
        putnik.setMail(mailId.getText());
        putnik.setUsername(userNameId.getText());
        putnikManager.add(putnik);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Registracija");
        alert.setContentText("Registracija je uspješna!");
        alert.showAndWait();
        Stage stage = (Stage) cancelButtonId.getScene().getWindow();
        stage.close();
    }
    public void cancelButtonClick(ActionEvent actionEvent){
        Stage stage = (Stage) cancelButtonId.getScene().getWindow();
        stage.close();
    }
}
