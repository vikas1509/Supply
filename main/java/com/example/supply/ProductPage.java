package com.example.supply;

//import com.mysql.cj.protocol.Resultset;
//import javafx.beans.Observable;
//import javafx.collections.FXCollections;
//import javafx.collections.ObservableList;
//import javafx.event.ActionEvent;
//import javafx.event.EventHandler;
//import javafx.scene.control.*;
//import javafx.scene.layout.HBox;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.sql.ResultSet;
import java.sql.SQLException;


public class ProductPage {
    ListView<HBox> product;

    ListView<HBox>showproductbyName(String search) throws SQLException {
        ObservableList<HBox> productList = FXCollections.observableArrayList();
        ResultSet res = (ResultSet) HelloApplication.connection.executeQuery("select * from product");
        product = new ListView<>();

        Label Name = new Label();
        Label Price = new Label();
        Label Id = new Label();
        HBox Detail = new HBox();

        Name.setMinWidth(50);
        Id.setMinWidth(50);
        Price.setMinWidth(50);


        Name.setText("Name") ;
        Price.setText("price");
        Id.setText("productID");

        Detail.getChildren().addAll(Id,Name,Price);
        productList.add( Detail);

        while(res.next()){
            if(res.getString("productName").toLowerCase().contains( search.toLowerCase())) {
                Label productName = new Label();
                Label productPrice = new Label();
                Label productID = new Label();
                Button buy = new Button();
                HBox productDetail = new HBox();

                productName.setMinWidth(50);
                productID.setMinWidth(50);
                productPrice.setMinWidth(50);
                buy.setText("Buy");

                buy.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        if (HelloApplication.emailid.equals("")) {
                            Dialog<String> dialog = new Dialog<>();
                            dialog.setTitle("Login");
                            ButtonType type = new ButtonType("OK", ButtonBar.ButtonData.OK_DONE);
                            dialog.setContentText("Login First before placing the order");
                            dialog.getDialogPane().getButtonTypes().add(type);
                            dialog.showAndWait();
                        } else {
                            try {
                                Orders place = new Orders();
                                place.placeOrder(productID.getText());
                            } catch (SQLException e) {
                                e.printStackTrace();
                            }
                            System.out.println("You Clicked on Buy Button");
                        }

                    }
                });
                productName.setText(res.getString("productName"));
                productPrice.setText(res.getString("price"));
                productID.setText("" + res.getInt("productID"));

                productDetail.getChildren().addAll(productID, productName, productPrice, buy);
                productList.add(productDetail);

            }
        }
        System.out.println(productList.size() );
        if(productList.size()==1 ){
            Dialog<String> dialog = new Dialog<>();
            dialog.setTitle("Search Result");
            ButtonType type = new ButtonType("OK", ButtonBar.ButtonData.OK_DONE);
            dialog.setContentText("No product is Availble for your search || ");
            dialog.getDialogPane().getButtonTypes().add(type);
            dialog.showAndWait();
        }
        product.setItems(productList);
        return product;
    }
    ListView<HBox>showproduct() throws SQLException {
        ObservableList<HBox> productList = FXCollections.observableArrayList();
        ResultSet res = (ResultSet) HelloApplication.connection.executeQuery("select * from product");
        product = new ListView<>();

        Label Name = new Label();
        Label Price = new Label();
        Label Id = new Label();
        HBox Detail = new HBox();

        Name.setMinWidth(50);
        Id.setMinWidth(50);
        Price.setMinWidth(50);


        Name.setText("Name") ;
        Price.setText("price");
        Id.setText("productID");

        Detail.getChildren().addAll(Id,Name,Price);
        productList.add( Detail);

while(res.next()){
    Label productName = new Label();
    Label productPrice = new Label();
    Label productID = new Label();
    Button buy = new Button();
    HBox productDetail = new HBox();

    productName.setMinWidth(50);
    productID.setMinWidth(50);
    productPrice.setMinWidth(50);
    buy.setText("Buy");

    buy.setOnAction(new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent actionEvent) {
            if (HelloApplication.emailid.equals("")) {
                Dialog<String> dialog = new Dialog<>();
                dialog.setTitle("Login");
                ButtonType type = new ButtonType("OK", ButtonBar.ButtonData.OK_DONE);
                dialog.setContentText("Login First before placing the order");
                dialog.getDialogPane().getButtonTypes().add(type);
                dialog.showAndWait();
            } else {
                try {
                    Orders place = new Orders();
                    place.placeOrder(productID.getText());
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                System.out.println("You Clicked on Buy Button");
            }

        }
    });
    productName.setText(res.getString("productName") );
    productPrice.setText(res.getString("price"));
    productID.setText(""+res.getInt("productID"));

    productDetail.getChildren().addAll(productID,productName,productPrice,buy );
    productList.add(productDetail);


}
product.setItems(productList);
return product;
    }
}

//public class productPage {
//    ListView<HBox> products;
//
//    ListView<HBox> showProductsbyName(String search) throws SQLException {
//        ObservableList<HBox> productList = FXCollections.observableArrayList();
//        ResultSet res = HelloApplication.connection.executeQuery("Select * from product");
//        products = new ListView<>();
//
//        Label name = new Label();
//        Label price = new Label();
//        Label id = new Label();
//        HBox details = new HBox();
//
//        name.setMinWidth(50);
//        id.setMinWidth(50);
//        price.setMinWidth(50);
//        name.setText(" Name ");
//        price.setText(" price ");
//        id.setText(" productID ");
//
//        details.getChildren().addAll(id, name, price);
//        productList.add(details);
//
//        while (res.next()) {
//            if (res.getString("productName").toLowerCase().contains(search.toLowerCase())) {
//
//
//                Label productName = new Label();
//                Label productPrice = new Label();
//                Label productID = new Label();
//                Button buy = new Button();
//                HBox productDetails = new HBox();
//
//                productName.setMinWidth(50);
//                productID.setMinWidth(50);
//                productPrice.setMinWidth(50);
//                buy.setText("Buy");
//
//                buy.setOnAction(new EventHandler<ActionEvent>() {
//                    @Override
//                    public void handle(ActionEvent actionEvent) {
//                        if (HelloApplication.emailid.equals("")) {
//                            Dialog<String> dialog = new Dialog<>();
//                            dialog.setTitle("Login");
//                            ButtonType type = new ButtonType("OK", ButtonBar.ButtonData.OK_DONE);
//                            dialog.setContentText("Login First before placing the order");
//                            dialog.getDialogPane().getButtonTypes().add(type);
//                            dialog.showAndWait();
//                        } else {
//                            try {
//                                Orders place = new Orders();
//                                place.placeOrder(productID.getText());
//                            } catch (SQLException e) {
//                                e.printStackTrace();
//                            }
//                            System.out.println("You Clicked on Buy Button");
//                        }
//
//                    }
//                });
//
//                productName.setText(res.getString("productName"));
//                productPrice.setText(res.getString("price"));
//                productID.setText("" + res.getInt("productID"));
//
//
//                productDetails.getChildren().addAll(productID, productName, productPrice, buy);
//                productList.add(productDetails);
//            }
//        }
//        System.out.println(productList.size());
//        if (productList.size() == 1) {
//            Dialog<String> dialog = new Dialog<>();
//            dialog.setTitle("Search Result");
//            ButtonType type = new ButtonType("OK", ButtonBar.ButtonData.OK_DONE);
//            dialog.setContentText("No Product is Available for your search!!");
//            dialog.getDialogPane().getButtonTypes().add(type);
//            dialog.showAndWait();
//        }
//        products.setItems(productList);
//        return products;
//    }
//}
