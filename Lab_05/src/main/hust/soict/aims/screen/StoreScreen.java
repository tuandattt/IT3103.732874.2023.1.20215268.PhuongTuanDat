package src.main.hust.soict.aims.screen;

import javax.swing.*;

import src.main.hust.soict.aims.media.Media;
import src.main.hust.soict.aims.store.Store;
import src.main.hust.soict.aims.cart.Cart;
import src.main.hust.soict.aims.media.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import src.main.hust.soict.aims.store.MediaStore;

public class StoreScreen extends JFrame {
    private Store store;
    private Cart cart;

    JPanel createNorth() {
        JPanel north = new JPanel();
        north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
        north.add(createMenuBar());
        north.add(createHeader());
        return north;
    }

    JMenuBar createMenuBar() {
        JMenu menu = new JMenu("Options");

        JMenu smUpdateStore = new JMenu("Update Store");
        MenuListener menuListener = new MenuListener(store, cart);
        JMenuItem addBook = new JMenuItem("Add Book");
        addBook.addActionListener(menuListener);
        smUpdateStore.add(addBook);
        JMenuItem addCD = new JMenuItem("Add CD");
        addCD.addActionListener(menuListener);
        smUpdateStore.add(addCD);
        JMenuItem addDVD = new JMenuItem("Add DVD");
        addDVD.addActionListener(menuListener);
        smUpdateStore.add(addDVD);

        menu.add(smUpdateStore);
        JMenuItem viewStore = new JMenuItem("View store");
        viewStore.addActionListener(menuListener);
        menu.add(viewStore);
        JMenuItem viewCart = new JMenuItem("View cart");
        viewCart.addActionListener(menuListener);
        menu.add(viewCart);

        JMenuBar menuBar = new JMenuBar();
        menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
        menuBar.add(menu);

        return menuBar;
    }

    JPanel createHeader() {
        JPanel header = new JPanel();
        header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));

        JLabel title = new JLabel("AIMS");
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
        title.setForeground(Color.CYAN);

        ButtonListener buttonListener = new ButtonListener(cart);
        JButton cart = new JButton("View cart");
        cart.setPreferredSize(new Dimension(100, 50));
        cart.setMaximumSize(new Dimension(100, 50));
        cart.addActionListener(buttonListener);

        header.add(Box.createRigidArea(new Dimension(10, 10)));
        header.add(title);
        header.add(Box.createHorizontalGlue());
        header.add(cart);
        header.add(Box.createRigidArea(new Dimension(10, 10)));

        return header;
    }

    JPanel createCenter() {
        JPanel center = new JPanel();
        center.setLayout(new GridLayout(3, 3, 2, 2));

        ArrayList<Media> mediaInStore = store.getItemsInStore();
        for (int i = 0; i < 9; i++) {
            MediaStore cell = new MediaStore(mediaInStore.get(i));
            center.add(cell);
        }

        return center;
    }

    public StoreScreen(Store store, Cart cart) {
        this.store = store;
        this.cart = cart;
        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());

        cp.add(createNorth(), BorderLayout.NORTH);
        cp.add(createCenter(), BorderLayout.CENTER);

        setVisible(true);
        setTitle("Store");
        setSize(1024, 768);
    }

    public static void main(String[] args) throws Exception {
        Store store = new Store();
        Cart cart = new Cart();
        // Create new media and add them to the store
        // Adding DVDs
        ArrayList<Track> track1 = new ArrayList<Track>();
        track1.add(new Track("Hello", 120));
        Media dvd1 = new DigitalVideoDisc("DVD Title 1", "Action", "Director 1", 120, 19.99f);
        store.addMedia(dvd1);

        // Adding CDs
        Media cd1 = new CompactDisc("CD Title 1", "Pop", "Jamie", 120, 15.99f, "Artist 1", track1);
        store.addMedia(cd1);

        // Adding Books
        Media book1 = new Book(5, "The Silent Patient",
                "Thriller", 14.95f);
        store.addMedia(book1);
        new StoreScreen(store, cart);
    }

    private class ButtonListener implements ActionListener {
        // Attribute
        private Cart cart;

        // Constructor
        public ButtonListener(Cart cart) {
            super();
            this.cart = cart;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            String button = e.getActionCommand();
            if (button.equals("View cart")) {
                new CartScreen(cart);
                setVisible(false);
                dispose();
            }
        }
    }

    private class MenuListener implements ActionListener {
        // Attribute
        private Store store;
        private Cart cart;

        // Constructor
        public MenuListener(Store store, Cart cart) {
            super();
            this.store = store;
            this.cart = cart;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            String menu = e.getActionCommand();
            if (menu.equals("Add Book")) {
                new AddBookToStoreScreen(store, cart);
                setVisible(false);
                dispose();
            } else if (menu.equals("Add CD")) {
                new AddCDToStore(store, cart);
                setVisible(false);
                dispose();
            } else if (menu.equals("Add DVD")) {
                new AddDVDToStoreScreen(store, cart);
                setVisible(false);
                dispose();
            } else if (menu.equals("View store")) {
                new StoreScreen(store, cart);
                setVisible(false);
                dispose();
            } else if (menu.equals("View cart")) {
                new CartScreen(cart);
                setVisible(false);
                dispose();
            }
        }
    }

}

