package com.example.supply;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginpageController {
    @FXML
    TextField email;
    @FXML
    PasswordField password;

    @FXML
    public void login(MouseEvent event) throws SQLException, IOException, java.io.IOException {
        String query = String.format("select * from user where emailId  ='%s' AND pass='%s'", email.getText(), password.getText());
        ResultSet res = HelloApplication.connection.executeQuery(query);

        if (res.next()) {

                    String userType = res.getString("userType");
            HelloApplication.emailid =res.getString("emailid");
            if (userType.equals("Buyer")) {
                System.out.println("Logged in as a sBuyer");


                ProductPage product = new ProductPage();
                Header header = new Header();

                ListView<HBox> productList = product.showproduct();

                AnchorPane productpane = new AnchorPane();


                productpane.getChildren().add(productList);

                HelloApplication.root.getChildren().clear();
                HelloApplication.root.getChildren().addAll(header.root,productpane);

            } else {
                System.out.println("Logged in as Seller");
                AnchorPane SellerPage = FXMLLoader.load((getClass().getResource("SellerPage.fxml")));
                HelloApplication.root.getChildren().add(SellerPage);
            }


        }

        else
        {
            Dialog<String> dialog = new Dialog<>();
            dialog.setTitle("Login");
            ButtonType type = new ButtonType("ok",ButtonBar.ButtonData.OK_DONE);
            dialog.setContentText("Login Failed || please Try Again");
            dialog.getDialogPane().getButtonTypes().add(type);
            dialog.showAndWait();

        }
    }


    }
