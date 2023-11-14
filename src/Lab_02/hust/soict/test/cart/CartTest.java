package Lab_02.hust.soict.test.cart;

import Lab_02.hust.soict.aims.cart.Cart;
import Lab_02.hust.soict.aims.disc.DigitalVideoDisc;

public class CartTest {
    public static void main(String[] args){
        //Create new cart
        Cart cart = new Cart();

        //Create new dvd objects and add them to the cart
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation","Roger Allers", 87, 19.95f);
        cart.addDigitalVideoDisc(dvd1);

        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star War", "Science Fiction", "George Lucas", 87, 24.95f);
        cart.addDigitalVideoDisc(dvd2);

        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.95f);
        cart.addDigitalVideoDisc(dvd3);

        //test print method
        cart.print();
        //test search by id method
        System.out.println("Search by id:");
        cart.search(1);
        //test search by title method
        System.out.println("Search by title:");
        cart.search("Aladin");
    }
}
