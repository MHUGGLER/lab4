public class Playlist {
    private static class Node {
        Song song;
        Node next;
        Node(Song song) {
            this.song = song;
        }
    }

    private Node head;
    private Node tail;
    private Node current;
    private int size;

    public void addSong(Song song) {
        Node n = new Node(song);
        if (head == null) {
            head = n;
            tail = n;
        } else {
            tail.next = n;
            tail = n;
        }
        size++;
    }

    public void removeSong(String title) {
        if (head == null) return;
        if (head.song.getTitle().equalsIgnoreCase(title)) {
            head = head.next;
            if (head == null) tail = null;
            size--;
            return;
        }
        Node prev = head;
        Node cur = head.next;
        while (cur != null) {
            if (cur.song.getTitle().equalsIgnoreCase(title)) {
                prev.next = cur.next;
                if (cur == tail) tail = prev;
                size--;
                return;
            }
            prev = cur;
            cur = cur.next;
        }
    }

    public void playNext() {
        if (head == null) {
            System.out.println("Playlist is empty.");
            return;
        }
        if (current == null) current = head;
        else {
            current = current.next;
            if (current == null) current = head;
        }
        System.out.println("Now playing: " + current.song);
    }

    public void displayPlaylist() {
        Node cur = head;
        while (cur != null) {
            System.out.println(cur.song);
            cur = cur.next;
        }
    }
}