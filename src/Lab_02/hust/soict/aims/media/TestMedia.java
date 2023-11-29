package Lab_02.hust.soict.aims.media;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestMedia {
    public static void main(String[] args){
        List <Media> mediae = new ArrayList<Media>();
        List<String> authors = new ArrayList<>();
        authors.add("Author1");
        authors.add("Author2");
        authors.add("Author3");
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation","Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star War", "Science Fiction", "George Lucas", 87, 24.95f);
        Book book1 = new Book("Hello World", "Animation", 19.5f, authors);
        mediae.add(dvd1);
        mediae.add(dvd2);
        mediae.add(book1);

        for (Media m: mediae){
            System.out.println(m.toString());
        }

        Collections.sort(mediae, Media.COMPARE_BY_COST_TITLE);
        System.out.println("Sort by Cost");
        for (Media m: mediae){
            System.out.println(m.toString());
        }

        // OR Sorting by title then cost
        Collections.sort(mediae, Media.COMPARE_BY_TITLE_COST);
        System.out.println("Sort by Title");
        for (Media m: mediae){
            System.out.println(m.toString());
        }
    }
}
