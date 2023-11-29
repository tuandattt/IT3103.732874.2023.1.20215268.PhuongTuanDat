package Lab_02.hust.soict.aims.store;

import Lab_02.hust.soict.aims.media.DigitalVideoDisc;
import Lab_02.hust.soict.aims.media.Media;

import java.util.ArrayList;

public class Store {
    //Danh sach dia trong cua hang
    private ArrayList<Media> itemsInStore = new ArrayList<Media>();
    //So luong dia trong cua hang
    int numberItem;

    //Them dia vao danh sach cua cua hang
    public void addMedia(Media mediaName){
        boolean found = false;
        for(Media item: itemsInStore){
            if(item == mediaName){ //kiem tra ton tai
                found = true;
            }
        }
        if(found){
            System.out.println("Item has already existed"); //In thong bao
        }
        else{
            itemsInStore.add(mediaName); //Thêm item vào list
            System.out.println("Added new item");
        }
    }

    public void removeMedia(Media mediaName){
        boolean found = false;
        for(Media item: itemsInStore){
            if(item == mediaName){ //kiem tra ton tai
                found = true;
            }
        }
        if(!found){
            System.out.println("Item does not exist"); //In thong bao
        }
        else{
            itemsInStore.remove(mediaName); //Xoa item trong list
            System.out.println("Removed item");
        }
    }

    public void print(){
        System.out.println("***********************CART***********************");
        for(Media item: itemsInStore){
            //System.out.println("DVD " + "- " + item.getId() + " " + item.getTitle() + " - " + item.getCategory() +
              //      ": " + item.getCost() + " $");
            System.out.println(item);
        }
        System.out.println("***************************************************");
    }


    public Media findMedia(String title){
        for(Media item: itemsInStore){
            if(item.isMatch(title)){
                return item;
            }
        }
        return null;
    }
}
