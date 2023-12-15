package src.main.hust.soict.aims.screen;

import src.main.hust.soict.aims.cart.Cart;
import src.main.hust.soict.aims.media.DigitalVideoDisc;
import src.main.hust.soict.aims.media.Media;
import src.main.hust.soict.aims.store.Store;

import javax.swing.*;
import java.awt.*;

public class AddDVDToStoreScreen extends AddMediaToStoreScreen{
    // Attribute
    protected JTextField tfDirector;
    protected JTextField tfLength;

    // Constructor


    public AddDVDToStoreScreen(Store store, Cart cart ){
        super(store, cart, "Add DVD To Store", "ADD DVD TO STORE");
    }

    JPanel createCenter() {
        JPanel center = new JPanel();
        tfDirector = new JTextField(10);
        tfLength = new JTextField(10);
        center.setLayout (new GridLayout(6, 2, 2, 2));
        addInputRow(center, "Id", tfId);
        addInputRow(center, "Title", tfTitle);
        addInputRow(center, "Category", tfCategory);
        addInputRow(center, "Cost", tfCost);
        addInputRow(center, "Director", tfDirector);
        addInputRow(center, "Length", tfLength);
        return center;
    }

    public Media createMedia() {
        return new DigitalVideoDisc(tfTitle.getText(), tfCategory.getText(), tfDirector.getText(),
                Integer.parseInt(tfLength.getText()), Float.parseFloat(tfCost.getText()));
    }

}
