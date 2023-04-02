package ba.unsa.etf.rpr.Controllers;

import ba.unsa.etf.rpr.Domain.Karta;
import ba.unsa.etf.rpr.Domain.Let;
import ba.unsa.etf.rpr.Exception.KartaException;
import ba.unsa.etf.rpr.business.KartaManager;
import ba.unsa.etf.rpr.business.LetManager;
import ba.unsa.etf.rpr.business.PutnikManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.util.List;

import static java.sql.Date.valueOf;
import static javafx.scene.control.PopupControl.USE_COMPUTED_SIZE;

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
    private PutnikManager putnikManager = new PutnikManager();
    private KartaManager kartaManager = new KartaManager();
    private String username,password;
    private Integer id;
    public KorisnikPanelController(String username, String password){
        this.username = username;
        this.password = password;
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

    public void okButtonIdClick() throws KartaException, IOException {
        Karta karta = new Karta();
        karta.setLet(letManager.getById(id));
        karta.setPutnik(putnikManager.getById(putnikManager.logInId(username,password)));
        karta.setKlasa(selectedKlasaId.getText());
        kartaManager.add(karta);
        KartaController controller = new KartaController(id, putnikManager.logInId(username, password), selectedKlasaId.getText());
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/karta.fxml"));
        Stage primaryStage = new Stage();
        loader.setController(controller);
        primaryStage.setScene(new Scene(loader.load(), USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
        primaryStage.setResizable(false);
        primaryStage.show();
    }
}
