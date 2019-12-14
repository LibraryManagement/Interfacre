package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class StudentMyDetailsController {
    @FXML
    private AnchorPane StudentMyDetailsPane;
    @FXML
    public void changeSceneToStudentView(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("StudentView.fxml"));
        StudentMyDetailsPane.getChildren().setAll(pane);
    }
}
