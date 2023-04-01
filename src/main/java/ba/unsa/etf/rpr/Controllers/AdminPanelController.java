package ba.unsa.etf.rpr.Controllers;

import ba.unsa.etf.rpr.Domain.Let;
import ba.unsa.etf.rpr.Exception.KartaException;
import ba.unsa.etf.rpr.business.LetManager;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.util.Callback;

import java.awt.event.ActionEvent;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.util.List;

public class AdminPanelController {
    public TableView letoviTableId;
    public TableColumn polazisteColId;
    public TableColumn krajnjaColId;
    public TableColumn datumColId;
    public TableColumn vrijemeColId;
    public TableColumn terminalColId;
    public TextField polazisteId;
    public TextField krajnjaId;
    public DatePicker datumId;
    public TextField vrijemeId;
    public TextField terminalId;
    public Button addButtonId;
    public Button updateButtonId;
    public Button deleteButtonId;
    public Button logOutButtonId;
    public Tab putniciTabId;
    public Tab letoviTabId;
    public TableColumn idColId;

    private LetManager letManager = new LetManager();
    private LocalDate localDate;

    @FXML
    public void initialize(){

    }

    public void addButtonClick() throws KartaException {
        if(polazisteId.getText().isEmpty() || krajnjaId.getText().isEmpty() || datumId.getValue() == null || vrijemeId.getText().isEmpty() || terminalId.getText().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Prazna polja");
            alert.setContentText("Molimo popunite prazna polja");
            alert.showAndWait();
        }
       try {
           Let let = new Let();
           let.setPocetnaDestinacija(polazisteId.getText());
           let.setKrajnjaDestinacija(krajnjaId.getText());
           let.setDatum(Date.valueOf(datumId.getValue()));
           let.setVrijemePolaska(Time.valueOf(vrijemeId.getText() +":00"));
           let.setTerminal(terminalId.getText());
           letManager.add(let);
       }catch(KartaException e){
           throw new KartaException(e.getMessage(), e);
       }catch(NumberFormatException e){
           Alert alert = new Alert(Alert.AlertType.ERROR);
           alert.setTitle("Error");
           alert.setHeaderText("Netačni podaci");
           alert.setContentText("Unesite tačne podatke");
           alert.showAndWait();
       }
    }

    public void updateButtonClick() throws KartaException {
        if(polazisteId.getText().isEmpty() || krajnjaId.getText().isEmpty() || datumId.getValue() == null || vrijemeId.getText().isEmpty() || terminalId.getText().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Prazna polja");
            alert.setContentText("Molimo izaberite let");
            alert.showAndWait();
        }
        Let let = new Let();
        let.setPocetnaDestinacija(polazisteId.getText());
        let.setKrajnjaDestinacija(krajnjaId.getText());
        let.setDatum(Date.valueOf(datumId.getValue()));
        let.setVrijemePolaska(Time.valueOf(vrijemeId.getText()));
        let.setTerminal(terminalId.getText());
        letManager.update(let);
    }

    public void getLet(){
       int i = letoviTableId.getSelectionModel().getSelectedIndex();
       if(i <= -1) return;
       polazisteId.setText(polazisteColId.getCellData(i).toString());
       krajnjaId.setText(krajnjaColId.getCellData(i).toString());
       datumId.setValue(LocalDate.parse(datumColId.getCellData(i).toString()));
       vrijemeId.setText(vrijemeColId.getCellData(i).toString());
       terminalId.setText(terminalColId.getCellData(i).toString());
    }

    public void deleteButtonClick() throws KartaException {
        letManager.delete(letManager.getByKrajnjaDestinacija(krajnjaId.getText()).getId());
    }

    public void datumIdClick() {
        localDate = datumId.getValue();
    }


}
