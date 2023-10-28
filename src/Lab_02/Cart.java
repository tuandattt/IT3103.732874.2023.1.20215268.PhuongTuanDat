package Lab_02;

public class Cart {
    //Số lượng đĩa nhiều nhất có thể mua
    public static final int MAX_NUMBERS_ORDERED = 20;
    //tạo biến lưu thông tin đĩa cho vào giỏ hàng
    private DigitalVideoDisc itemsOrdered[] =
            new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
    int qtyOrdered; //số lượng đĩa đã có trong giỏ hàng

    //Chọn đĩa vào giỏ hàng
    public void addDigitalVideoDisc(DigitalVideoDisc disc){
        if(qtyOrdered >= MAX_NUMBERS_ORDERED){ //kiểm tra số lượng đĩa đã có trong giỏ
            System.out.println("Your cart is full");
        } else {
            itemsOrdered[qtyOrdered] = disc; //thêm đĩa vào giỏ hàng
            qtyOrdered++; //tăng số lượng đĩa đã có
            System.out.println("Added " + disc.getTitle() + " to the cart");
        }
    }

    public void removeDigitalVideoDisc(DigitalVideoDisc disc){
        boolean found = false;
        for(int i = 0; i < qtyOrdered; i++){
            if(itemsOrdered[i] == disc){
                //lùi dvd tìm thấy xuống cuối danh sách
                for(int j = i; j < qtyOrdered - 1; j++){
                    itemsOrdered[j] = itemsOrdered[j+1];
                }
                //xóa dvd tìm được
                itemsOrdered[qtyOrdered - 1] = null;
                //cập nhật số lượng dvd
                qtyOrdered--;
                //cập nhật đã tìm thấy dvd muốn xóa
                found = true;
                System.out.println("Removed " + disc.getTitle() + " from your cart");
                break;
            }
        }
        if(!found){
            System.out.println("Cannot find " + disc.getTitle());
        }
    }

    public float totalCost(){
        float sum = 0;
        for(int i = 0; i < qtyOrdered; i++){
            sum = sum + itemsOrdered[i].getCost();
        }
        return sum;
    }

}


