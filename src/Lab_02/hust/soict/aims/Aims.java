package Lab_02.hust.soict.aims;
import Lab_02.hust.soict.aims.media.*;
import Lab_02.hust.soict.aims.store.Store;
import Lab_02.hust.soict.aims.cart.Cart;

import java.util.ArrayList;
import java.util.Scanner;

public class Aims {
    static Store store = new Store();
    static Cart cart = new Cart();
    public static void main(String[] args){
        ArrayList<Track> track1 = new ArrayList<Track>();
        track1.add(new Track("Hello", 120));
        track1.add(new Track("World", 120));
        CompactDisc cd1 = new CompactDisc("CD Title 1", "Pop", "Jamie", 120,15.99f, "Artist 1", track1);
        CompactDisc cd2 = new CompactDisc("CD Title 2", "Rock", "Jane", 90,12.99f,"Artist 2", track1);
        CompactDisc cd3 = new CompactDisc("CD Title 3", "Classical", "Harry", 150,20.99f, "Artist 3", track1);
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("DVD Title 1", "Action","Director 1", 120, 19.99f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("DVD Title 2", "Comedy","Director 2",130, 16.99f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("DVD Title 3", "Drama", "Director 3", 140, 22.99f);

        ArrayList<String> authorName = new ArrayList<String>();
        authorName.add("James");
        authorName.add("Jane");
        Book book1 = new Book("Book Title 1", "Fiction", 29.99f, authorName);
        Book book2 = new Book("Book Title 2", "Non-fiction", 24.99f, authorName);
        Book book3 = new Book("Book Title 3", "Mystery", 19.99f, authorName);

        store.addMedia(cd1);
        store.addMedia(cd2);
        store.addMedia(cd3);
        store.addMedia(dvd1);
        store.addMedia(dvd2);
        store.addMedia(dvd3);
        store.addMedia(book1);
        store.addMedia(book2);
        store.addMedia(book3);

        showMenu();
    }

    public static void viewStore(){
        store.print();
        storeMenu();
    }

    public static void showMenu(){
        System.out.println("AIMS: ");
        System.out.println("--------------------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3");

        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    viewStore();
                    break;
                case 2:
                    updateStore();
                    break;
                case 3:
                    currentCart();
                    break;
                case 0:
                    System.out.println("Exiting the application. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please choose again.");
            }

        } while (choice != 0);
    }

    public static void updateStore(){
        Scanner scanner = new Scanner(System.in);
        int option;
        do {
            System.out.println("Options: ");
            System.out.println("--------------------------------");
            System.out.println("1. Add a media to the store");
            System.out.println("2. Remove a media from the store");
            System.out.println("0. Back");
            System.out.println("--------------------------------");
            System.out.println("Please choose a number: 0-1-2");
            System.out.print("Enter option: ");
            option = scanner.nextInt();
            scanner.nextLine(); // consume newline character

            switch (option) {
                case 1:
                    addMediaToStore();
                    break;
                case 2:
                    removeMediaFromStore();
                    break;
                case 0:
                    System.out.println("Going back to the main menu...");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        } while (option != 0);
    }

    public static void removeMediaFromStore(){
        System.out.print("Enter Name of the media: ");
        Scanner scanner = new Scanner(System.in);
        String title = scanner.nextLine();
        Media item = store.findMedia(title);
        store.removeMedia(item);
    }

    public static void addMediaToStore(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("--------------------------------------");
        System.out.println("Enter media type (CD/DVD/Book): ");
        String mediaType = scanner.nextLine();

        System.out.println("Enter media title: ");
        String title = scanner.nextLine();

        System.out.println("Enter media category: ");
        String category = scanner.nextLine();

        System.out.println("Enter media cost: ");
        float cost = scanner.nextFloat();
        scanner.nextLine();

        switch (mediaType.toUpperCase()) {
            case "CD":
                System.out.println("Enter media director: ");
                String directorCD = scanner.nextLine();

                System.out.println("Enter media length: ");
                int lengthCD = scanner.nextInt();

                System.out.println("Enter media artist: ");
                String artist = scanner.nextLine();

                System.out.println("Enter number of tracks: ");
                ArrayList<Track> trackName = new ArrayList<Track>();
                int numTrack = scanner.nextInt();
                for(int i = 0; i < numTrack; i++){
                    String nameOfTrack = scanner.nextLine();
                    int length = scanner.nextInt();
                    Track track = new Track(nameOfTrack, length);
                    trackName.add(track);
                }

                CompactDisc cd = new CompactDisc(title,category,directorCD,lengthCD,cost,artist,trackName);
                store.addMedia(cd);
                break;

            case "DVD":
                System.out.println("Enter media director: ");
                String directorDVD = scanner.nextLine();

                System.out.println("Enter media length: ");
                int lengthDVD = scanner.nextInt();

                DigitalVideoDisc dvd = new DigitalVideoDisc(title,category,directorDVD,lengthDVD,cost);
                store.addMedia(dvd);
                break;

            case "BOOK":
                System.out.println("Enter number of authors: ");
                ArrayList<String> name = new ArrayList<String>();
                int numAuthor = scanner.nextInt();
                for(int i = 0; i < numAuthor; i++){
                    String author = scanner.nextLine();
                    name.add(author);
                }
                Book book = new Book(title,category,cost, name);
                store.addMedia(book);
                break;
            default:
                System.out.println("Invalid media type.");
        }
    }

    public static void storeMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. See a media’s details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See current cart");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4");

        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            showMenu();
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    seeMediaDetail();
                    break;
                case 2:
                    addMedia();
                    break;
                case 3:
                    playAnotherMedia();
                    break;
                case 4:
                    currentCart();
                    break;
                case 0:
                    System.out.println("Return to main menu");
                    break;
                default:
                    System.out.println("Invalid choice. Please choose again.");
            }

        } while (choice != 0);
    }

    public static void seeMediaDetail(){
        System.out.print("Enter Name of the media: ");
        Scanner scanner = new Scanner(System.in);
        String title = scanner.nextLine();
        Media item = store.findMedia(title);
        if(item == null){
            System.out.println("Cannot find");
        }
        else {
            System.out.println(item);
            mediaDetailsMenu(item);
        }
    }

    public static void addMedia(){
        System.out.print("Enter Name of the media: ");
        Scanner scanner = new Scanner(System.in);
        String title = scanner.nextLine();
        Media item = store.findMedia(title);
        if(item == null){
            System.out.println("Cannot find");
        }
        else {
            cart.addMedia(item);
        }
    }

    public static void playAnotherMedia(){
        System.out.print("Enter Name of the media: ");
        Scanner scanner = new Scanner(System.in);
        String title = scanner.nextLine();
        Media item = store.findMedia(title);
        if(item == null){
            System.out.println("Cannot find");
        }
        else {
            playMedia(item);
        }
    }

    public static void currentCart(){
        cart.print();
        cartMenu();
    }

    public static void mediaDetailsMenu(Media item) {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Add to cart");
        System.out.println("2. Play");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2");

        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            showMenu();
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    cart.addMedia(item);
                    break;
                case 2:
                    playMedia(item);
                    break;
                case 0:
                    System.out.println("Return to Store Menu");
                    break;
                default:
                    System.out.println("Invalid choice. Please choose again.");
            }

        } while (choice != 0);
    }

    public static void playMedia(Media item){
        if(item instanceof CompactDisc){
            ((CompactDisc) item).play();
        } else if (item instanceof  DigitalVideoDisc) {
            ((DigitalVideoDisc) item).play();
        } else {
            System.out.println("Cannot play media");
        }
    }

    public static void cartMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Filter medias in cart");
        System.out.println("2. Sort medias in cart");
        System.out.println("3. Remove media from cart");
        System.out.println("4. Play a media");
        System.out.println("5. Place order");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4-5");
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            showMenu();
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    filterMedia();
                    break;
                case 2:
                    sortMedia();
                    break;
                case 3:
                    removeMediaFromCart();
                    break;
                case 4:
                    playMediaFromCart();
                    break;
                case 5:
                    removeAllCart();
                    break;
                case 0:
                    System.out.println("Return to Store Menu");
                    break;
                default:
                    System.out.println("Invalid choice. Please choose again.");
            }

        } while (choice != 0);
    }

    public static void removeAllCart(){
        System.out.println("An order is created");
        cart.removeAll();
    }

    public static void filterMedia(){
        Scanner scanner = new Scanner(System.in);
        int option;
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Filter medias in cart by id");
        System.out.println("2. Filter medias in cart by title");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 1-2");
        option = scanner.nextInt();
        scanner.nextLine();
        if (option == 1){
            System.out.println("Enter the id:");
            int inputId = scanner.nextInt();
            cart.search(inputId);
        } else if (option == 2) {
            System.out.println("Enter the title:");
            String inputTitle = scanner.nextLine();
            cart.search(inputTitle);
        } else {
            System.out.println("Invalid choice, back to Cart menu");
        }
    }

    public static void sortMedia(){
        Scanner scanner = new Scanner(System.in);
        int option;
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Sort medias in cart by cost");
        System.out.println("2. Sort medias in cart by title");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 1-2");
        option = scanner.nextInt();
        scanner.nextLine();
        if (option == 1){
            cart.getItemsOrdered().sort(Media.COMPARE_BY_COST_TITLE);
        } else if (option == 2) {
            cart.getItemsOrdered().sort(Media.COMPARE_BY_TITLE_COST);
        } else {
            System.out.println("Invalid choice");
        }
    }

    public static void removeMediaFromCart(){
        System.out.print("Enter Name of the media: ");
        Scanner scanner = new Scanner(System.in);
        String title = scanner.nextLine();
        Media item = store.findMedia(title);
        cart.removeMedia(item);
    }

    public static void playMediaFromCart(){
        System.out.print("Enter Name of the media: ");
        Scanner scanner = new Scanner(System.in);
        String title = scanner.nextLine();
        Media item = cart.findMedia(title);
        if(item == null){
            System.out.println("Cannot find");
        }
        else {
            playMedia(item);
        }
    }

}
