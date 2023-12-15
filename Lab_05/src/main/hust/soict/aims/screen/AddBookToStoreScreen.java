package src.main.hust.soict.aims.screen;

import src.main.hust.soict.aims.cart.Cart;
import src.main.hust.soict.aims.media.Book;
import src.main.hust.soict.aims.media.Media;
import src.main.hust.soict.aims.store.Store;

import javax.swing.*;
import java.awt.*;

public class AddBookToStoreScreen extends AddMediaToStoreScreen {
    public AddBookToStoreScreen(Store store, Cart cart) {
        super(store, cart, "Add Book To Store", "ADD BOOK TO STORE");
    }

    JPanel createCenter() {
        JPanel center = new JPanel();
        center.setLayout (new GridLayout(4, 2, 2, 2));
        addInputRow(center, "Id", tfId);
        addInputRow(center, "Title", tfTitle);
        addInputRow(center, "Category", tfCategory);
        addInputRow(center, "Cost", tfCost);
        return center;
    }

    public Media createMedia() {
        return new Book(Integer.parseInt(tfId.getText()), tfTitle.getText(),
                tfCategory.getText(), Float.parseFloat(tfCost.getText()));
    }
}
