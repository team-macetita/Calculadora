package Components;

public class ErrorL {
    public int line;
    public int column;
    public String character;

    public ErrorL(int line, int column, String character) {
        this.line = line;
        this.column = column;
        this.character = character;
    }
}
