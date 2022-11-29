package com.example.supply;

import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Orders {
    void placeOrder(String productID) throws SQLException {
         ResultSet res = HelloApplication.connection.executeQuery("select max(OrderId) from orders");
int Orderid=0;
if(res.next())
Orderid = res.getInt("max(OrderId)")+1;
        String query = String.format("Insert Into Orders  values(%s,%s,'%s')",Orderid,productID,HelloApplication.emailid);
        System.out.println(query);
int response = HelloApplication.connection.executeUpdate(query);

if(response>0)
{
    Dialog<String> dialog = new Dialog<>();
    dialog.setTitle("Order");
    ButtonType type = new ButtonType("ok", ButtonBar.ButtonData.OK_DONE);
    dialog.setContentText("Your order is Placed");
    dialog.getDialogPane().getButtonTypes().add(type);
    dialog.showAndWait();
    System.out.println("order is Placed");

}
else{
    System.out.println("order is not Placed");
}
    }
}
