package src.main.hust.soict.aims.store;

import src.main.hust.soict.aims.media.Media;
import src.main.hust.soict.aims.media.Playable;
import src.main.hust.soict.aims.Aims;
import src.main.hust.soict.aims.cart.Cart;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MediaStore extends JPanel {
    private Media media;
    static Cart cart = new Cart();
    public MediaStore(Media media){
        this.media = media;
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel title = new JLabel(media.getTitle());
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 20));
        title.setAlignmentX(CENTER_ALIGNMENT);

        JLabel cost = new JLabel("" + media.getCost() + " $");
        cost.setAlignmentX(CENTER_ALIGNMENT);

        JPanel container = new JPanel();
        container.setLayout(new FlowLayout(FlowLayout.CENTER));

        JButton addToCartButton = new JButton("Add to Cart");
        addToCartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addToCart();
            }
        });
        container.add(addToCartButton);

        if(media instanceof Playable){
            JButton playButton = new JButton("Play");
            playButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    playMedia();
                }
            });
        }

        this.add(Box.createVerticalGlue());
        this.add(title);
        this.add(cost);
        this.add(Box.createVerticalGlue());
        this.add(container);

        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }

    private void addToCart(){
        cart.addMedia(media);
        JOptionPane.showMessageDialog(this, "Added to Cart: " + media.getTitle(), "Add to Cart", JOptionPane.INFORMATION_MESSAGE);
    }

    private void playMedia(){
        Aims.playMedia(media);
        JOptionPane.showMessageDialog(this, "Playing: " + media.getTitle(), "Play Media", JOptionPane.INFORMATION_MESSAGE);
    }
}
