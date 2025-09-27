import java.util.Scanner;

public class TextEditor {

    private static class Node {
        String textState;
        Node prev;
        Node next;

        Node(String textState, Node prev, Node next) {
            this.textState = textState;
            this.prev = prev;
            this.next = next;
        }
    }

    private Node currentNode;

    public TextEditor() {
        currentNode = new Node("", null, null);
    }

    public void add(String newText) {
        String updatedText = currentNode.textState + newText;
        Node newNode = new Node(updatedText, currentNode, null);
        currentNode.next = newNode;
        currentNode = newNode;
    }

    public String undo() {
        if (currentNode.prev != null) {
            currentNode = currentNode.prev;
        } else {
            System.out.println("Cannot undo.");
        }
        return currentNode.textState;
    }

    public String redo() {
        if (currentNode.next != null) {
            currentNode = currentNode.next;
        } else {
            System.out.println("Cannot redo.");
        }
        return currentNode.textState;
    }

    public void printCurrent() {
        System.out.println("Current text: \"" + currentNode.textState + "\"");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TextEditor editor = new TextEditor();
        boolean running = true;

        while (running) {
            System.out.println("\n1 - Add text");
            System.out.println("2 - Undo");
            System.out.println("3 - Redo");
            System.out.println("4 - Print current text");
            System.out.println("5 - Exit");
            System.out.print("Choose an option: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter text to add: ");
                    editor.add(sc.nextLine());
                    break;
                case 2:
                    editor.undo();
                    break;
                case 3:
                    editor.redo();
                    break;
                case 4:
                    editor.printCurrent();
                    break;
                case 5:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option!");
            }
        }

        sc.close();
    }
}