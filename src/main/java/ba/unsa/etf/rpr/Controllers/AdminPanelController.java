package ba.unsa.etf.rpr.Controllers;

import ba.unsa.etf.rpr.Domain.Let;
import ba.unsa.etf.rpr.Exception.KartaException;
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

    public void addButtonClick() throws KartaException {


    }
}
