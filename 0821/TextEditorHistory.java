import java.util.ArrayDeque;
import java.util.Deque;

public class TextEditorHistory {

    private String text = "";
    private Deque<String> undoStack = new ArrayDeque<>();
    private Deque<String> redoStack = new ArrayDeque<>();

    public void edit(String newText) {
        undoStack.push(text);
        text = newText;
        redoStack.clear();
        printState("Edit");
    }

    public void undo() {
        if (undoStack.isEmpty()) {
            System.out.println("Nothing to undo.");
            return;
        }

        redoStack.push(text);
        text = undoStack.pop();
        printState("Undo");
    }

    public void redo() {
        if (redoStack.isEmpty()) {
            System.out.println("Nothing to redo.");
            return;
        }

        undoStack.push(text);
        text = redoStack.pop();
        printState("Redo");
    }

    public void printState(String action) {
        System.out.println(action);
        System.out.println("Current text: " + text);
        System.out.println("Undo stack: " + undoStack);
        System.out.println("Redo stack: " + redoStack);
        System.out.println();
    }

    public static void main(String[] args) {

        TextEditorHistory editor = new TextEditorHistory();

        editor.edit("Hello");
        editor.edit("Hello World");
        editor.edit("Hello World!");

        editor.undo();
        editor.undo();

        editor.redo();

        editor.edit("Hello Java");

        editor.undo();
        editor.redo();
    }
}