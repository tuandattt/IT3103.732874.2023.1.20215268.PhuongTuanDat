package src.main.hust.soict.aims.media;

import java.util.ArrayList;

public class CompactDisc extends Disc implements Playable{
    private String artist;
    private ArrayList<Track> tracks;

    public CompactDisc(String title, String category, String director, int length, float cost, String artist, ArrayList<Track> tracks) {
        super(length, director, title, category, cost);
        this.artist = artist;
        this.tracks = tracks;
    }

    public CompactDisc(int length, String director, String title, String category, float cost, String artist) {
        super(length, director, title, category, cost);
        this.artist = artist;
    }

    public void addTrack(Track trackName){
        boolean found = false;
        for(Track track: tracks){
            if(track == trackName){ //kiem tra ton tai author
                found = true;
            }
        }
        if(found){
            System.out.println("Track has already existed"); //In thong bao
        }
        else{
            tracks.add(trackName); //Them track vao list
            System.out.println("Added new track");
        }
    }

    public void removeTrack(Track trackName){
        boolean found = false;
        for(Track track: tracks){
            if(track == trackName){ //kiem tra ton tai track
                found = true;
            }
        }
        if(!found){
            System.out.println("Track does not exist"); //In thong bao
        }
        else{
            tracks.remove(trackName); //Xoa track trong list
            System.out.println("Removed new author");
        }
    }

    public int getLength(){
        int sum = 0;
        for(Track track: tracks){
            sum += track.getLength();
        }
        return sum;
    }

    //In ra thông tin của mỗi track trong list
    public void play(){
        for (Track track: tracks){
            track.play();
        }
    }

    public ArrayList<String> nameTrack(){
        ArrayList<String> name = new ArrayList<String>();
        for (Track track: tracks) {
            name.add(track.getTitle());
        }
        return name;
    }

    public String toString(){
        return "Compact Disc: "  + this.getTitle() + " - " + this.getCategory() + " - " + this.artist + this.nameTrack() + ": " + this.getCost() + " $";
    }
}
