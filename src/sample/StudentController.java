package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class StudentController {

    @FXML
    private AnchorPane StudentPane;

    //Function for 'X'
    @FXML
    public void changeSceneToSample(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("sample.fxml"));
        StudentPane.getChildren().setAll(pane);
    }
    //Function for 'MyDetails'
    @FXML
    public void changeSceneToMyDetails(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("StudentMyDetails.fxml"));
        StudentPane.getChildren().setAll(pane);
    }
    //Function for 'StudentBooks'
    @FXML
    public void changeSceneToStudentBooks(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("StudentBooks.fxml"));
        StudentPane.getChildren().setAll(pane);
    }
}
