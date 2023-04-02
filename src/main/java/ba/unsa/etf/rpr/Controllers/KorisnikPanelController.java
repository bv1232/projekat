package ba.unsa.etf.rpr.Controllers;

import ba.unsa.etf.rpr.Dao.DaoFactory;
import ba.unsa.etf.rpr.Domain.Let;
import ba.unsa.etf.rpr.Exception.KartaException;
import ba.unsa.etf.rpr.business.LetManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.awt.event.ActionEvent;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static java.sql.Date.valueOf;

public class KorisnikPanelController {

    public DatePicker datePickerId;
    public Label usernameLabelId;
    public TextField brKartiId;
    public RadioButton prvaKlasaId;
    public RadioButton biznisKlasaId;
    public RadioButton ekonomskaKlasaId;
    public TableView<Let> letoviTableId;
    public TableColumn<Let, String> polazakColId;
    public TableColumn<Let, String> krajnjaColId;
    public TableColumn<Let, Time> vrijemeColId;
    public TableColumn<Let, Integer> idColId;
    public Button cancelButtonId;
    public Button okButtonId;
    public TextField selectedKlasaId;
    private List<Integer> listaDatumi;
    private LocalDate date;
    private LetManager letManager = new LetManager();
    private String username;
    private Integer id;
    public KorisnikPanelController(String username){
        this.username = username;
    }
    @FXML
    public void initialize(){
        this.usernameLabelId.setText(username);
        idColId.setVisible(false);
        selectedKlasaId.setVisible(false);
    }

    public void datePickerSelection() throws KartaException {
        date = datePickerId.getValue();
        listaDatumi = letManager.getAllbyDatum(Date.valueOf(datePickerId.getValue()));
        List<Let> letovi = letManager.getAllById(listaDatumi);
        if(!letovi.isEmpty()) {
            polazakColId.setCellValueFactory(new PropertyValueFactory<Let, String>("pocetnaDestinacija"));
            krajnjaColId.setCellValueFactory(new PropertyValueFactory<Let, String>("krajnjaDestinacija"));
            vrijemeColId.setCellValueFactory(new PropertyValueFactory<Let, Time>("vrijemePolaska"));
            idColId.setCellValueFactory(new PropertyValueFactory<Let, Integer>("id"));
            ObservableList<Let> letoviObs = FXCollections.observableArrayList(letovi);
            letoviTableId.setItems(letoviObs);
            letoviTableId.refresh();
        }else{
            ObservableList<Let> l = letoviTableId.getItems();
            l.clear();
            letoviTableId.refresh();
        }
    }

    public void getLet(){
        int i = letoviTableId.getSelectionModel().getSelectedIndex();
        if (i <= -1) return;
        id = Integer.valueOf(idColId.getCellData(i).toString());
    }

    public void getKlasa1(){
        if(prvaKlasaId.isSelected()){
            selectedKlasaId.setText("Prva klasa");
            biznisKlasaId.setSelected(false);
            ekonomskaKlasaId.setSelected(false);
        }
    }
    public void getKlasa2(){
        if(biznisKlasaId.isSelected()) {
            selectedKlasaId.setText("Biznis klasa");
            prvaKlasaId.setSelected(false);
            ekonomskaKlasaId.setSelected(false);
        }
    }
    public void getKlasa3(){
        if(ekonomskaKlasaId.isSelected()){
            selectedKlasaId.setText("Ekonomska klasa");
            prvaKlasaId.setSelected(false);
            biznisKlasaId.setSelected(false);
        }
    }
}
