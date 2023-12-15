package src.main.hust.soict.aims.media;

public class Disc extends Media{
    private int length;
    private String director;

    public int getLength() {
        return length;
    }

    public String getDirector() {
        return director;
    }

    public Disc(int length, String director, String title, String category, float cost) {
        //lay tu lop cha
        super(title, category, cost);
        this.length = length;
        this.director = director;
    }

    public Disc(String title) {
        super(title);
    }

    public Disc(String title, String category, float cost) {
        super(title, category, cost);
    }

    public void play(){
        System.out.println("Playing Disc: " + this.getTitle());
        System.out.println("DVD Length: " + this.getLength());
    }
}