package src.main.hust.soict.aims.media;

import java.util.Objects;

public class Track implements Playable {
    private String title;
    private int length;

    public String getTitle() {
        return title;
    }

    public int getLength() {
        return length;
    }

    public Track(String title, int length) {
        this.title = title;
        this.length = length;
    }

    public void play(){
        System.out.println("Playing Track: " + this.getTitle());
        System.out.println("Track Length: " + this.getLength());
    }

    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Track track = (Track) obj;
        return Objects.equals(title, track.title) && length == track.length;
    }
}
