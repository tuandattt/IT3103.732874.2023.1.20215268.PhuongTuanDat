package src.main.hust.soict.aims.media;

import java.util.Comparator;

public class MediaComparatorByTitleCost implements Comparator<Media> {
    public int compare(Media media1, Media media2) {
        // Compare by title first
        int titleComparison = media1.getTitle().compareTo(media2.getTitle());

        if (titleComparison != 0) {
            return titleComparison;
        }

        // If titles are the same, compare by cost
        return Float.compare(media1.getCost(), media2.getCost());
    }
}
