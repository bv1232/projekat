package ba.unsa.etf.rpr.Controllers;

import ba.unsa.etf.rpr.Domain.Putnik;
import ba.unsa.etf.rpr.Exception.KartaException;
import ba.unsa.etf.rpr.business.PutnikManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Optional;

import static javafx.scene.control.PopupControl.USE_COMPUTED_SIZE;

public class LoginController {
    public Hyperlink registarId;
    public PasswordField passwordId;
    public TextField usernameId;
    public Button cancelButtonId;
    public Button okButtonId;
    private PutnikManager putnikManager = new PutnikManager();

    public void cancelButtonClick (ActionEvent actionEvent){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Upozorenje!");
        alert.setHeaderText("Da li ste sigurni da želite napustiti aplikaciju?");
        alert.setContentText("Pritisnite OK za potvrdu.");

        Optional<ButtonType> result = alert.showAndWait();
        ButtonType button = result.orElse(ButtonType.CANCEL);

        if (button == ButtonType.OK) {
            Stage stage = (Stage) cancelButtonId.getScene().getWindow();
            stage.close();
        } else
            return;
    }

    public void okButtonClick(ActionEvent actionEvent) throws KartaException, IOException {
        int logInId = putnikManager.logInId(usernameId.getText(), passwordId.getText());
        if(logInId == 0){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Pogrešni podaci");
            alert.setContentText("Pogrešno korisničko ime ili lozinka");
            alert.showAndWait();
        }else {
            if(logInId == 5){
               // AdminPanelController controller = new AdminPanelController();
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/adminPanel.fxml"));
                Stage primaryStage = new Stage();
               // loader.setController(controller);
                primaryStage.setScene(new Scene(loader.load(),USE_COMPUTED_SIZE,USE_COMPUTED_SIZE));
                primaryStage.setResizable(false);
                primaryStage.show();
                Stage stage = (Stage) okButtonId.getScene().getWindow();
                stage.close();
            }else {
                Putnik putnik = putnikManager.getById(logInId);
                KorisnikPanelController controller = new KorisnikPanelController(usernameId.getText());
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/korisnikPanel.fxml"));
                Stage primaryStage = new Stage();
                loader.setController(controller);
                primaryStage.setScene(new Scene(loader.load(), USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
                primaryStage.setResizable(false);
                primaryStage.show();
                Stage stage = (Stage) okButtonId.getScene().getWindow();
                stage.close();
            }
        }
    }

    public void otvoriProzorZaRegistraciju(ActionEvent actionEvent) throws IOException {
        RegistracijaController controller = new RegistracijaController(usernameId.getText(), passwordId.getText());
        //Parent root = FXMLLoader.load(getClass().getResource("/fxml/registracija.fxml"));
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/registracija.fxml"));
        Stage primaryStage = new Stage();
        primaryStage.setTitle("Registracija");
        loader.setController(controller);
        primaryStage.setScene(new Scene(loader.load(), USE_COMPUTED_SIZE,USE_COMPUTED_SIZE));
        primaryStage.setResizable(false);
        primaryStage.show();
    }
}
