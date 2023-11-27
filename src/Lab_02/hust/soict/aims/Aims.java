package Lab_02.hust.soict.aims;

import Lab_02.hust.soict.aims.cart.Cart;
import Lab_02.hust.soict.aims.media.DigitalVideoDisc;

public class Aims {
    public static void main(String[] args){
        //TODO Auto-generated method stub
        //tạo 1 giỏ hàng mới
        Cart anOrder = new Cart();
        //chọn dvd thêm vào giỏ hàng
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation","Roger Allers", 87, 19.95f);
        anOrder.addMedia(dvd1);

        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star War", "Science Fiction", "George Lucas", 87, 24.95f);
        anOrder.addMedia(dvd2);


        //in giá của giỏ hàng
        System.out.println("Total cost is: ");
        System.out.println(anOrder.totalCost());

        anOrder.removeMedia(dvd2);
    }
}
