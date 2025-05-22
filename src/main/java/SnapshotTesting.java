public class SnapshotTesting {
    private StringBuilder text;
    private StringBuilder savedText;

    public SnapshotTesting() {
        this.text = new StringBuilder();
        this.savedText = new StringBuilder();
    }

    public static void main(String[] args) {
        SnapshotTesting example = new SnapshotTesting();
        example.append("Hello ");
        example.append("World");
        example.append(" Java");
        System.out.println(example.getText());
        example.undo();
        System.out.println(example.getText());
    }

    public void append(String newText) {
        savedText = new StringBuilder(text);
        text.append(newText);
    }

    public void undo() {
        text = new StringBuilder(savedText);
    }

    public String getText() {
        return text.toString();
    }
}
