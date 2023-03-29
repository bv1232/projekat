package ba.unsa.etf.rpr.Controllers;

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

    public void okButtonClick(ActionEvent actionEvent) {
    }

    public void otvoriProzorZaRegistraciju(ActionEvent actionEvent) throws IOException {
        RegistracijaController controller = new RegistracijaController(usernameId.getText(), passwordId.getText());
        //Parent root = FXMLLoader.load(getClass().getResource("/fxml/registracija.fxml"));
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/registracija.fxml"));
        Stage primaryStage=new Stage();
        primaryStage.setTitle("Registracija");
        loader.setController(controller);
        primaryStage.setScene(new Scene(loader.load(), USE_COMPUTED_SIZE,USE_COMPUTED_SIZE));
        primaryStage.setResizable(false);
        primaryStage.show();
    }
}
