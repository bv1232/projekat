package ba.unsa.etf.rpr.Controllers;

import ba.unsa.etf.rpr.Domain.Let;
import ba.unsa.etf.rpr.Exception.KartaException;
import ba.unsa.etf.rpr.business.LetManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;

import java.awt.event.ActionEvent;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.util.List;

public class AdminPanelController {
    public TableView<Let> letoviTableId;
    public TableColumn<Let, String> polazisteColId;
    public TableColumn<Let, String> krajnjaColId;
    public TableColumn<Let, Date> datumColId;
    public TableColumn<Let, Time> vrijemeColId;
    public TableColumn<Let, String> terminalColId;
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
    public TableColumn<Let, Integer> idColId;

    private LetManager letManager = new LetManager();
    private LocalDate localDate;

    @FXML
    public void initialize() throws KartaException {
        updateTableLetovi();
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
           updateTableLetovi();
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
        updateTableLetovi();
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

    public void updateTableLetovi() throws KartaException {
        idColId.setCellValueFactory(new PropertyValueFactory<Let, Integer>("id"));
        polazisteColId.setCellValueFactory(new PropertyValueFactory<Let, String>("pocetnaDestinacija"));
        krajnjaColId.setCellValueFactory(new PropertyValueFactory<Let, String>("krajnjaDestinacija"));
        datumColId.setCellValueFactory(new PropertyValueFactory<Let, Date>("datum"));
        vrijemeColId.setCellValueFactory(new PropertyValueFactory<Let, Time>("vrijemePolaska"));
        terminalColId.setCellValueFactory(new PropertyValueFactory<Let, String>("terminal"));
        List<Let> letovi = letManager.getAll();
        ObservableList<Let> letoviObs = FXCollections.observableArrayList(letovi);
        letoviTableId.setItems(letoviObs);
        letoviTableId.refresh();
    }
}
