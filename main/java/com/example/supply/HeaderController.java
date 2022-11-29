package com.example.supply;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;

   import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
//import jdk.javadoc.internal.doclets.formats.html.markup.Head;

import java.io.IOException;
import java.io.InvalidObjectException;
import java.sql.SQLException;

public class HeaderController {

    @FXML
    Button loginbutton;
@FXML
    Label email;
@FXML
    TextField searchtext;
@FXML
Button logoutButton;
        @FXML
        public  void initialize(){
           if(!HelloApplication.emailid.equals("")){
             loginbutton.setOpacity(0);
             email.setText(HelloApplication.emailid);
           }
        }
        public void login(MouseEvent event) throws IOException {
            AnchorPane loginpage = FXMLLoader.load((getClass().getResource("LoginPage.fxml")));
            HelloApplication.root.getChildren().add(loginpage);


        }
        @FXML
    public void search(MouseEvent event)throws IOException , SQLException {
            Header header = new Header();
ProductPage products = new ProductPage();
AnchorPane productpane= new AnchorPane();
productpane.getChildren().add(products.showproductbyName(searchtext.getText()));
            productpane.setLayoutX(150);
            productpane.setLayoutY(100);
HelloApplication.root.getChildren().clear();
HelloApplication.root.getChildren().addAll(header.root,productpane);

        }
        @FXML
        public void logout(MouseEvent event ) throws IOException,SQLException{
if(logoutButton.getOpacity()==0) {
    logoutButton.setOpacity(1);
    logoutButton.setOnAction(new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent actionEvent) {
            HelloApplication.emailid="";
            logoutButton.setOpacity(0);
            try {
                Header header = new Header();
                HelloApplication.root.getChildren().add(header.root);
            }catch(IOException e){
                e.printStackTrace();
            }

        }
    });
}
else{
    logoutButton.setOpacity(0);
}
        }
}
