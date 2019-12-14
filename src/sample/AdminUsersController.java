package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class AdminUsersController {
    @FXML
    private AnchorPane adminUsersControllerPane;
    @FXML
    public void changeFromAdminUsersToAdminView(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("AdminView.fxml"));
        adminUsersControllerPane.getChildren().setAll(pane);
    }
}
