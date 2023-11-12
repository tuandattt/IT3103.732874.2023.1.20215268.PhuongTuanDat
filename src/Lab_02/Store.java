package Lab_02;

public class Store {
    //Danh sach dia trong cua hang
    private DigitalVideoDisc itemsInStore[] = new DigitalVideoDisc[100];
    //So luong dia trong cua hang
    int numberItem;

    //Them dia vao danh sach cua cua hang
    public void addDVD(DigitalVideoDisc disc){
        itemsInStore[numberItem] = disc;
        numberItem++;
        System.out.println("Added " + disc.getTitle() + " to the store");
    }

    public void removeDVD(DigitalVideoDisc disc){
        boolean found = false;
        for(int i = 0; i < numberItem; i++){
            if(itemsInStore[i] == disc){
                //lùi dvd tìm thấy xuống cuối danh sách
                for(int j = i; j < numberItem - 1; j++){
                    itemsInStore[j] = itemsInStore[j+1];
                }
                //xóa dvd tìm được
                itemsInStore[numberItem - 1] = null;
                //cập nhật số lượng dvd
                numberItem--;
                //cập nhật đã tìm thấy dvd muốn xóa
                found = true;
                System.out.println("Removed " + disc.getTitle() + " from the store");
                break;
            }
        }
        if(!found){
            System.out.println("Cannot find " + disc.getTitle());
        }
    }


}
