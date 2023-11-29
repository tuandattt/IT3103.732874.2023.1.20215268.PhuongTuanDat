package Lab_02.hust.soict.test.store;

import Lab_02.hust.soict.aims.media.DigitalVideoDisc;
import Lab_02.hust.soict.aims.store.Store;

public class StoreTest {
    public static void main(String[] args){
        //Create new cart
        Store MyStore = new Store();

        //Create new dvd objects and add them to the cart
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation","Roger Allers", 87, 19.95f);
        MyStore.addMedia(dvd1);

        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star War", "Science Fiction", "George Lucas", 87, 24.95f);
        MyStore.addMedia(dvd2);

        DigitalVideoDisc dvd3;
        dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.95f);
        MyStore.addMedia(dvd3);


        MyStore.removeMedia(dvd1);
    }
}
