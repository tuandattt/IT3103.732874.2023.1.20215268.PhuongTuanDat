package src.main.hust.soict.aims.screen;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import src.main.hust.soict.aims.cart.Cart;
import src.main.hust.soict.aims.media.Media;
import src.main.hust.soict.aims.media.Playable;

import java.awt.event.ActionEvent;
import src.main.hust.soict.aims.Aims;

import static src.main.hust.soict.aims.Aims.playMedia;

public class CartScreenController {
    private Cart cart;
    private TableView<Media> tblMedia;
    private TableColumn<Media, String > colMediaTitle;
    private TableColumn<Media, String> colMediaCategory;
    private TableColumn<Media, Float> colMediaCost;
    private Button btnPlay;
    private Button btnRemove;
    private Button btnPlaceOrder;
    private Label labelTotal;
    public CartScreenController(Cart cart){
        super();
        this.cart = cart;
    }

    private void initialize(){
        colMediaTitle.setCellValueFactory(new PropertyValueFactory<Media, String>("title"));
        colMediaCategory.setCellValueFactory(new PropertyValueFactory<Media, String>("category"));
        colMediaCost.setCellValueFactory(new PropertyValueFactory<Media, Float>("cost"));
        tblMedia.setItems(this.cart.getItemsOrdered());
        labelTotal.setText(Double.toString(cart.totalCost()) + " $");
        btnPlay.setVisible(false);
        btnRemove.setVisible(false);

        tblMedia.getSelectionModel().selectedItemProperty().addListener(
                new ChangeListener<Media>() {
                    @Override
                    public void changed(ObservableValue<? extends Media> observable, Media oldValue, Media newValue) {
                        if(newValue != null){
                            updateButtonBar(newValue);
                        }
                    }
                }
        );
    }

    void updateButtonBar(Media media){
        btnRemove.setVisible(true);
        if(media instanceof Playable){
            btnPlay.setVisible(true);
        }
        else {
            btnPlay.setVisible(false);
        }
    }

    void btnRemovePressed(ActionEvent event){
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        cart.removeMedia(media);
    }

    void btnPlayPressed(ActionEvent event){

    }

    void btnPlaceOrderPressed(ActionEvent event){

    }

}
