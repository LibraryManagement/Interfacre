package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
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

    public void changeFirstCellEvent(TableColumn.CellEditEvent edditedCell) throws SQLException {
        Students studentSelected = tableView.getSelectionModel().getSelectedItem();
        String idOfSelected = studentSelected.getId();
        Statement stmt = con.createStatement();
        String sds = edditedCell.getNewValue().toString();
        String dmop = "UPDATE users SET name_user='"+sds+"' WHERE id='"+idOfSelected+"'";
        stmt.execute(dmop);
        stmt.close();
        studentSelected.setFirstName(sds);
    }
    public void changeEmailCellEvent(TableColumn.CellEditEvent edditedCell) throws SQLException {
        Students studentSelected = tableView.getSelectionModel().getSelectedItem();
        String idOfSelected = studentSelected.getId();
        Statement stmt = con.createStatement();
        String sds = edditedCell.getNewValue().toString();
        String dmop = "UPDATE users SET email='"+sds+"' WHERE id='"+idOfSelected+"'";
        stmt.execute(dmop);
        stmt.close();
        studentSelected.setEmail(sds);
    }
    public void changeIDCellEvent(TableColumn.CellEditEvent edditedCell) throws SQLException {
        Students studentSelected = tableView.getSelectionModel().getSelectedItem();
        String idOfSelected = studentSelected.getEmail();
        Statement stmt = con.createStatement();
        String sds = edditedCell.getNewValue().toString();
        String dmop = "UPDATE users SET id='"+sds+"' WHERE email='"+idOfSelected+"'";
        stmt.execute(dmop);
        stmt.close();
        studentSelected.setId(sds);
    }
    public void changePhoneCellEvent(TableColumn.CellEditEvent edditedCell) throws SQLException {
        Students studentSelected = tableView.getSelectionModel().getSelectedItem();
        String idOfSelected = studentSelected.getId();
        Statement stmt = con.createStatement();
        String sds = edditedCell.getNewValue().toString();
        String dmop = "UPDATE users SET phonenum='"+sds+"' WHERE id='"+idOfSelected+"'";
        stmt.execute(dmop);
        stmt.close();
        studentSelected.setTnumber(sds);
    }


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
    public void changeSceneToModifyView(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("hahaha.fxml"));
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
//        tableView.setEditable(true);
//        firstName.setCellFactory(TextFieldTableCell.forTableColumn());
//        email.setCellFactory(TextFieldTableCell.forTableColumn());
//        id.setCellFactory(TextFieldTableCell.forTableColumn());
//        tnumber.setCellFactory(TextFieldTableCell.forTableColumn());

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
