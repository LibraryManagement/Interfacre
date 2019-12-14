package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class LibrarianBooksController {
    @FXML
    private AnchorPane LibrarianBooksPane;
    @FXML
    public void changeSceneToLibrarianView(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("LibrarianView.fxml"));
        LibrarianBooksPane.getChildren().setAll(pane);
    }
}
