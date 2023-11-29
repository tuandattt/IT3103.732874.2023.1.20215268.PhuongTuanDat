package Lab_02.hust.soict.aims.cart;

import Lab_02.hust.soict.aims.media.DigitalVideoDisc;
import Lab_02.hust.soict.aims.media.Media;
import Lab_02.hust.soict.aims.media.Track;

import java.util.ArrayList;

public class Cart {
    //Số lượng đĩa nhiều nhất có thể mua
    public static final int MAX_NUMBERS_ORDERED = 20;
    //tạo biến lưu thông tin đĩa cho vào giỏ hàng
    private ArrayList<Media> itemsOrdered = new ArrayList<Media>();

    public ArrayList<Media> getItemsOrdered() {
        return itemsOrdered;
    }

    //Thêm hàng vào giỏ
    public void addMedia(Media mediaName){
        boolean found = false;
        for(Media item: itemsOrdered){
            if(item == mediaName){ //kiem tra ton tai
                found = true;
            }
        }
        if(found){
            System.out.println("Item has already existed"); //In thong bao
        }
        else{
            itemsOrdered.add(mediaName); //Thêm item vào list
            System.out.println("Added new item");
        }
    }

    //Xoá hàng trong giỏ
    public void removeMedia(Media mediaName){
        boolean found = false;
        for(Media item: itemsOrdered){
            if(item == mediaName){ //kiem tra ton tai
                found = true;
            }
        }
        if(!found){
            System.out.println("Item does not exist"); //In thong bao
        }
        else{
            itemsOrdered.remove(mediaName); //Xoa item trong list
            System.out.println("Removed new author");
        }
    }

    //Phuong thuc print
    public void print(){
        System.out.println("***********************CART***********************");
        for(Media item: itemsOrdered){
            System.out.println("DVD " + "- " + item.getId() + " " + item.getTitle() + " - " + item.getCategory() +
                    ": " + item.getCost() + " $");

        }
        System.out.println("Total Cost: " + totalCost());
        System.out.println("***************************************************");
    }

    public void search(int id){
        boolean found = false;
        for(Media item: itemsOrdered){
            if(item.getId() == id) {
                System.out.println(item);
                found = true;
            }
        }
        if(!found){
            System.out.println("No match is found");
        }
    }

    public void search(String title){
        boolean found = false;
        for(Media item: itemsOrdered){
            if(item.isMatch(title)){
                System.out.println(item);
                found = true;
            }
        }
        if(!found){
            System.out.println("No match is found");
        }
    }

    public Media findMedia(String title){
        for(Media item: itemsOrdered){
            if(item.isMatch(title)){
                return item;
            }
        }
        return null;
    }

    public float totalCost(){
        float sum = 0;
        for(Media item: itemsOrdered){
            sum = sum + item.getCost();
        }
        return sum;
    }

    public void removeAll(){
        for (Media media: itemsOrdered){
            itemsOrdered.remove(media);
        }
    }

}
