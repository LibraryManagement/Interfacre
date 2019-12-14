package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class AdminController {
    @FXML
    private AnchorPane adminPane;
    @FXML
    public void changeSceneToUsers(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("AdminUsers.fxml"));
        adminPane.getChildren().setAll(pane);
    }
    @FXML
    public void changeSceneToSample(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("sample.fxml"));
        adminPane.getChildren().setAll(pane);
    }

}
