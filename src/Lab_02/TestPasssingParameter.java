package Lab_02;

public class TestPasssingParameter {
    public static void main(String[] args){
        //TODO Auto-generated methor stub
        DigitalVideoDisc jungleDVD = new DigitalVideoDisc("Jungle");
        DigitalVideoDisc cinderellaDVD = new DigitalVideoDisc("Cinderella");

        swap(jungleDVD, cinderellaDVD);
        System.out.println("jungle dvd title: " + jungleDVD.getTitle());
        System.out.println("cinderella dvd title: " + cinderellaDVD.getTitle());

        
        //test phuong thuc swap moi
        swap(jungleDVD, cinderellaDVD);
        System.out.println("Sau khi swap: ");
        System.out.println("ungle DVD title: " + jungleDVD.getTitle());
        System.out.println("cinderella DVD title: " + cinderellaDVD.getTitle());

        //doi title cua 2 dvd
        changeTitle(jungleDVD, cinderellaDVD.getTitle());
        System.out.println("jungle dvd title: " + jungleDVD.getTitle());
    }

    public static void swap(Object o1, Object o2){
        Object tmp = o1;
        o1 = o2;
        o2 = tmp;
    }

    public static void changeTitle(DigitalVideoDisc disc, String title){
        String oldTitle = disc.getTitle();
        disc.setTitle(title);
        disc = new DigitalVideoDisc(oldTitle);
    }

    // viet lai phuong thuc swap
    public static void swap(DigitalVideoDisc o1, DigitalVideoDisc o2){
        String title = o2.getTitle();
        o2.setTitle(o1.getTitle());
        o1.setTitle(title);
    }

}
