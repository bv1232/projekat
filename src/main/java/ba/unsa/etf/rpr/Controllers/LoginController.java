package ba.unsa.etf.rpr.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

import static javafx.scene.control.PopupControl.USE_COMPUTED_SIZE;

public class LoginController {
    public Hyperlink registarId;
    public PasswordField passwordId;
    public TextField usernameId;

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
