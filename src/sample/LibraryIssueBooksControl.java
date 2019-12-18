package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LibraryIssueBooksControl {
    Alert a = new Alert(Alert.AlertType.NONE);
    @FXML
    private AnchorPane issuPane;
    @FXML
    private TextField stId;
    @FXML
    private TextField stName;
    @FXML
    private TextField email;
    @FXML
    private TextField stat;
    @FXML
    private TextField lbldate;
    @FXML
    private TextField datePicker;
    @FXML
    private TextField pdate;
    @FXML
    private TextField issueDate;
    @FXML
    private TextField qdatity;
    @FXML
    private TextField Id;
    Connection con;

    public LibraryIssueBooksControl() {
        createConnection();
    }

    void createConnection() {
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "rajabov99j");
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    public void changeSceneToLibrarian(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("LibrarianView.fxml"));
        issuPane.getChildren().setAll(pane);
    }

    public void mainSelection(ActionEvent event) throws IOException, SQLException, ParseException {
        if (stId.getText().equals("")) {
            a.setAlertType(Alert.AlertType.ERROR);
            a.setContentText("STUDENT ID NOT ENTERED!");
            a.show();
        } else if (Id.getText().equals("")) {
            a.setAlertType(Alert.AlertType.ERROR);
            a.setContentText("BOOK ID NOT ENTERED!");
            a.show();
        } else if (qdatity.getText().equals("0")) {
            a.setAlertType(Alert.AlertType.ERROR);
            a.setContentText("NOT AVAILABLE BOOK");
            a.show();
        } else {
            if (issueDate.getText().equals("")) {
                a.setAlertType(Alert.AlertType.ERROR);
                a.setContentText("ENTER THE ISSUE DATE!");
            } else {
                String IsDay = issueDate.getText();
                Statement stmt = con.createStatement();
                String bookId = Id.getText();
                String IdStud = stId.getText();
                int quantity = Integer.parseInt(qdatity.getText());
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                Date parsedDate = dateFormat.parse(IsDay);
                Timestamp timestamp1 = new Timestamp(parsedDate.getTime());
                System.out.println(timestamp1);
                Calendar cal = Calendar.getInstance();
                cal.setTimeInMillis(timestamp1.getTime());
                cal.setTimeInMillis(timestamp1.getTime());
                cal.add(Calendar.DAY_OF_MONTH, 16);
                Timestamp timestamp2 = new Timestamp(cal.getTime().getTime());
                System.out.println(timestamp2);
                String dmop = "INSERT INTO books_loaned (id_book,id_student,issue_date,due_date,quantity)" +
                        "VALUES ('" + bookId + "','" + IdStud + "','" + timestamp1 + "','" + timestamp2 + "','" + quantity + "')";
                stmt.execute(dmop);
                stmt.close();
                a.setAlertType(Alert.AlertType.CONFIRMATION);
                a.setContentText("SUCCESS!");

            }
            a.show();
        }
    }

    public void selectDate(ActionEvent event) throws SQLException {
        Statement stmt = con.createStatement();
        String dmop = "select *FROM books where id ='" + Id.getText() + "'";
        ResultSet rs = stmt.executeQuery(dmop);

        while (rs.next()) {
//            if(rs.getString("title").equals(""))
//            {
//                lbldate.setText("");
//                datePicker.setText("");
//                pdate.setText("");
//                qdatity.setText("");
//
//            }
            lbldate.setText(rs.getString("title"));
            datePicker.setText(rs.getString("subject"));
            pdate.setText(rs.getString("publishdate"));
        }
        stmt.close();
        Statement stmt1 = con.createStatement();
        String dmop1 = "select *FROM books_in_lib where book_id ='" + Id.getText() + "'";
        ResultSet rss = stmt1.executeQuery(dmop1);
        while (rss.next()) {
            qdatity.setText(String.valueOf(rss.getInt("quantity")));
        }
    }

    public void selectDate2(ActionEvent event) throws SQLException {
        Statement stmt = con.createStatement();
        String dmop = "select *FROM users where id ='" + stId.getText() + "'";
        ResultSet rs = stmt.executeQuery(dmop);
        while (rs.next()) {
            stName.setText(rs.getString("name_user"));
            email.setText(rs.getString("email"));
            if (rs.getInt("student_status") == 0) {
                stat.setText("ACTIVE");
            } else {
                stat.setText("BLOCKED");
            }

        }

    }

}
