package Lab_02.hust.soict.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media{
    private List<String> authors = new ArrayList<String>();

    public Book(int id, String title, String category, float cost) {
        super(id, title, category, cost);
    }

    private List<String> getAuthors() {
        return authors;
    }

    private void setAuthors(List<String> authors) {
        this.authors = authors;
    }


    public void addAuthor(String authorName){
        boolean found = false;
        for(String author: authors){
            if(author.equals(authorName)){ //kiem tra ton tai author
                found = true;
            }
        }
        if(found){
            System.out.println("Author has already existed"); //In thong bao
        }
        else{
            authors.add(authorName); //Them author vao list
            System.out.println("Added new author");
        }
    }

    public void removeAuthor(String authorName){
        boolean found = false;
        for(String author: authors){
            if(author.equals(authorName)){ //kiem tra ton tai author
                found = true;
            }
        }
        if(!found){
            System.out.println("Author do not exist"); //In thong bao
        }
        else{
            authors.remove(authorName); //Xoa author trong list
            System.out.println("Removed new author");
        }
    }
}
