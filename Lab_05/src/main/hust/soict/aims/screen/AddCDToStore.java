package src.main.hust.soict.aims.screen;

import src.main.hust.soict.aims.cart.Cart;
import src.main.hust.soict.aims.media.CompactDisc;
import src.main.hust.soict.aims.media.Media;
import src.main.hust.soict.aims.screen.AddMediaToStoreScreen;
import src.main.hust.soict.aims.store.Store;

import javax.swing.*;
import java.awt.*;

public class AddCDToStore extends AddMediaToStoreScreen {
    protected JTextField tfDirector;
    protected JTextField tfLength;
    protected JTextField tfArtist;

    protected JTextField tfTrack;

    public AddCDToStore(Store store, Cart cart) {
        super(store, cart, "Add CD to store", "ADD CD TO STORE");
    }

    JPanel createCenter() {
        JPanel center = new JPanel();
        tfDirector = new JTextField(10);
        tfLength = new JTextField(10);
        tfArtist = new JTextField(10);
        center.setLayout (new GridLayout(7, 2, 2, 2));
        addInputRow(center, "Id", tfId);
        addInputRow(center, "Title", tfTitle);
        addInputRow(center, "Category", tfCategory);
        addInputRow(center, "Cost", tfCost);
        addInputRow(center, "Director", tfDirector);
        addInputRow(center, "Length", tfLength);
        addInputRow(center, "Artist", tfArtist);
        return center;
    }

    public Media createMedia() {
        return new CompactDisc(Integer.parseInt(tfLength.getText()),tfTitle.getText(), tfCategory.getText(),tfDirector.getText(),  Float.parseFloat(tfCost.getText()),  tfArtist.getText());
    }
}
