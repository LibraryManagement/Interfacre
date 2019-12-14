package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class LibrarianController {
    @FXML
    private AnchorPane librarianControllerPane;
        //Function for 'X'
    @FXML
    public void changeSceneToSample(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("sample.fxml"));
        librarianControllerPane.getChildren().setAll(pane);
    }
    @FXML
    //Function for 'Students'
    public void changeSceneToLibrarianStudents(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("LibrarianStudents.fxml"));
        librarianControllerPane.getChildren().setAll(pane);
    }
    @FXML
    //Function for 'Books'
    public void changeSceneToLibrarianBooks(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("LibrarianBooks.fxml"));
        librarianControllerPane.getChildren().setAll(pane);
    }
    @FXML
    //Function for 'Students with Overdue'
    public void changeSceneToLibrarianStudentsWithOverdue(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("LibrarianStudentWithOverdue.fxml"));
        librarianControllerPane.getChildren().setAll(pane);
    }
    @FXML
    //Function for 'Montlhy Report'
    public void changeSceneToLibrarianMonthlyReport(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("LibrarianMonthlyReport.fxml"));
        librarianControllerPane.getChildren().setAll(pane);
    }
}
