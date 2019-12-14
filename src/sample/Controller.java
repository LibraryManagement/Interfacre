package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class Controller {
    @FXML
    private AnchorPane rootPane;
    //Function for AdminView
    @FXML
    public void changeScene(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("AdminView.fxml"));
        rootPane.getChildren().setAll(pane);
    }
    //Function for LibrarianView
    @FXML
    public void changeSceneToLibrarian(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("LibrarianView.fxml"));
        rootPane.getChildren().setAll(pane);
    }
    //Function for StudentView
    @FXML
    public void changeSceneToStudent(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("StudentView.fxml"));
        rootPane.getChildren().setAll(pane);
    }

    public void login(ActionEvent actionEvent) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("StudentView.fxml"));
        rootPane.getChildren().setAll(pane);
    }
}
