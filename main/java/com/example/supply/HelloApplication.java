package com.example.supply;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class HelloApplication extends Application {
    public static DatabaseConnection connection;
    public static Group root;
    public static String emailid;


    @Override
    public void start(Stage stage) throws IOException, SQLException {
        emailid="";
         connection=new DatabaseConnection();
     root=new Group();
    Header header= new Header();
    ProductPage product = new ProductPage();
        ListView<HBox> productList = product.showproduct();

        AnchorPane productpane = new AnchorPane();
        productpane.setLayoutX(50);
        productpane.setLayoutY(100);

        productpane.getChildren().add(productList);
     root.getChildren().addAll(header.root,productpane);

       // FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));

       // Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("suppy chain");
        stage.setScene(new Scene(root, 500, 500));

        stage.show();
        stage.setOnCloseRequest(e ->{
            try{
                connection.con.close();
                System.out.println("connection is closed");
            }
            catch (SQLException ex){
                ex.printStackTrace();
            }
        });
    }

    public static void main(String[] args) {
        launch();
    }
}