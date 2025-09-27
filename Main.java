import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Playlist playlist = new Playlist();
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("1. Add Song");
            System.out.println("2. Remove Song");
            System.out.println("3. Play Next");
            System.out.println("4. Display Playlist");
            System.out.println("5. Exit");
            choice = sc.nextInt();
            sc.nextLine();
            if (choice == 1) {
                System.out.print("Title: ");
                String t = sc.nextLine();
                System.out.print("Artist: ");
                String a = sc.nextLine();
                playlist.addSong(new Song(t, a));
            } else if (choice == 2) {
                System.out.print("Remove title: ");
                String t = sc.nextLine();
                playlist.removeSong(t);
            } else if (choice == 3) {
                playlist.playNext();
            } else if (choice == 4) {
                playlist.displayPlaylist();
            }
        } while (choice != 5);
        sc.close();
    }
}