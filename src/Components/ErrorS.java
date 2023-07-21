package Components;

public class ErrorS {
    int line;
    int column;
    Object token;
    String type;
    boolean unrecovered = false;

    public ErrorS(int line, int column, Object token, String type) {
        this.line = line;
        this.column = column;
        this.token = token;
        this.type = type;
    }

    public ErrorS(int line, int column, Object token, String type, boolean unrecovered) {
        this.line = line;
        this.column = column;
        this.token = token;
        this.type = type;
        this.unrecovered = unrecovered;
    }
}