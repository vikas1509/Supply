package com.example.supply;

import javafx.fxml.FXML;
import javafx.scene.control.*;

import javafx.scene.input.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SellerPageController {
    @FXML
    TextField name ;
    @FXML
    TextField price;
    @FXML
    TextField email;
    @FXML
    public void Add(MouseEvent event) throws SQLException {
        ResultSet res = HelloApplication.connection.executeQuery("select max(productID) from product");
        int productID =0;
        if(res.next())
            productID=res.getInt("max(productID)")+1 ;
        String query = String.format("Insert into product values(%s,'%s',%s,'%s')",productID,name.getText(),price.getText(),email.getText());
        int response = HelloApplication.connection.executeUpdate(query);
      //  System.out.println(response);
        Dialog<String> dialog= new Dialog<>();
        dialog.setTitle("product Add");
        ButtonType type =new ButtonType("ok", ButtonBar.ButtonData.OK_DONE);
        if(response>0){

            dialog.setContentText("A new Product is Added");


        }
        else{

            dialog.setContentText("The product is not Added");

        }
        dialog.getDialogPane().getButtonTypes().add(type);
        dialog.showAndWait();
    }

}
