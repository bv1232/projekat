package ba.unsa.etf.rpr.Controllers;

import ba.unsa.etf.rpr.Domain.Let;
import ba.unsa.etf.rpr.Exception.KartaException;
import ba.unsa.etf.rpr.business.LetManager;
import javafx.scene.control.*;

import java.sql.Date;

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

    private LetManager letManager = new LetManager();

    public void addButtonClick() throws KartaException {
       try {
           Let let = new Let();
           let.setPocetnaDestinacija(polazisteId.getText());
           let.setKrajnjaDestinacija(krajnjaId.getText());
           let.setDatum(Date.valueOf(datumId.getValue()));
           let.setVrijemePolaska(Date.valueOf(vrijemeId.getText()));
           let.setTerminal(terminalId.getText());
           letManager.add(let);
       }catch(KartaException e){
           throw new KartaException(e.getMessage(), e);
       }
    }
}
