package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LibrarianStudentsController implements Initializable {
    @FXML private TableView<Students>tableView;
    @FXML private TableColumn<Students, String> firstName;
    @FXML private TableColumn<Students, String> id;
    @FXML private TableColumn<Students, String> email;
    @FXML private TableColumn<Students, String> tnumber;


    @FXML
    private AnchorPane librarianStudentsPane;
    Connection con;
    public LibrarianStudentsController() {
        createConnection();
    }
    void createConnection(){
        try{
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "rajabov99j");
        }catch (SQLException ex){
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    public void changeSceneToLibrarianView(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("LibrarianView.fxml"));
        librarianStudentsPane.getChildren().setAll(pane);
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        email.setCellValueFactory(new PropertyValueFactory<Students, String>("email"));
        id.setCellValueFactory(new PropertyValueFactory<Students, String>("id"));
        tnumber.setCellValueFactory(new PropertyValueFactory<Students, String>("tnumber"));
        firstName.setCellValueFactory(new PropertyValueFactory<Students, String>("firstName"));

        try {
            tableView.setItems(getStudent());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public ObservableList<Students>getStudent() throws SQLException {

        Statement stm = con.createStatement();
        ResultSet rs = stm.executeQuery("SELECT * FROM USERS");
        ObservableList<Students> students = FXCollections.observableArrayList();
        while (rs.next())
        {
            students.add(new Students(rs.getString("name_user"),rs.getString("id"), rs.getString("email"),rs.getString("phonenum")));
        }
        return students;
    }
}
