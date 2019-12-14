package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class LibrarianMonthlyReportController {
    @FXML
    private AnchorPane LibrarianMonthlyReportPane;


    //Function for 'X'
    @FXML
    public void changeSceneToLibrarian(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("LibrarianView.fxml"));
        LibrarianMonthlyReportPane.getChildren().setAll(pane);
    }
}
