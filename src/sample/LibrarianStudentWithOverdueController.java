package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class LibrarianStudentWithOverdueController {
    @FXML
    private AnchorPane LibrarianStudentWithOverduePane;
    @FXML
    public void changeSceneToLibrarian(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("LibrarianView.fxml"));
        LibrarianStudentWithOverduePane.getChildren().setAll(pane);
    }
}
