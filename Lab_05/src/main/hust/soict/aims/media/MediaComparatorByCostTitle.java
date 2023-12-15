package src.main.hust.soict.aims.media;

import java.util.Comparator;

public class MediaComparatorByCostTitle implements Comparator<Media> {
    public int compare(Media media1, Media media2) {
        // Compare by cost first
        int costComparison = Float.compare(media1.getCost(), media2.getCost());

        if (costComparison != 0) {
            return costComparison;
        }

        // If costs are the same, compare by title
        return media1.getTitle().compareTo(media2.getTitle());
    }
}