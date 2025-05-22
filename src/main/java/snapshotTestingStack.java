import java.util.Stack;

public class snapshotTestingStack {
    private StringBuilder text;
    private Stack<String> history;

    public snapshotTestingStack() {
        this.text = new StringBuilder();
        this.history = new Stack<String>();
    }

    public static void main(String[] args) {
        snapshotTestingStack example = new snapshotTestingStack();
        example.append("Hello ");
        example.append("World");
        example.append(" Java");
        System.out.println(example.getText());
        example.undo();
        System.out.println(example.getText());
        example.undo();
        System.out.println(example.getText());
        example.append("World Earth");
        example.delete(6, 12);
        System.out.println(example.getText());
    }

    public void append(String newText) {
        history.push(text.toString());
        text.append(newText);
    }

    public void delete(int a, int b) {
        history.push(text.toString());
        text.delete(a, b);
    }

    public void undo() {
        if (!history.isEmpty()) {
            text = new StringBuilder(history.pop());
        }
    }

    public String getText() {
        return text.toString();
    }
}