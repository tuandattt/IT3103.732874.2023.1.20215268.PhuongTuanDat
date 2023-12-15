package src.main.hust.soict.aims.screen;

import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import src.main.hust.soict.aims.cart.Cart;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import javafx.application.Platform;
public class CartScreen extends JFrame {
    private Cart cart;
    public CartScreen(Cart cart){
        super();

        this.cart= cart;

        JFXPanel fxPanel = new JFXPanel();
        this.add(fxPanel);

        this.setTitle("Cart");
        this.setVisible(true);
        Platform.runLater(new Runnable(){
            public void run(){
                try{
                    FXMLLoader loader = new FXMLLoader(new URL("file:" + "G:\\OOP_Lab\\IT3103.732874.2023.1.20215268.PhuongTuanDat\\Lab_05\\src\\main\\hust\\soict\\aims\\screen\\Cart.fxml"));
                    CartScreenController controller = new CartScreenController(cart);
                    loader.setController(controller);
                    Parent root = loader.load();
                    fxPanel.setScene(new Scene(root));
                } catch (IOException e){
                    e.printStackTrace();
                }
            }
        });
    }
}
