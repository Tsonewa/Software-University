package Word;

public class TextTransform {

    private String text;
    private String lastChange;

    public TextTransform(String text) {
        this.text = text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setLastChange(String lastChange) {
        this.lastChange = lastChange;
    }

    public String getLastChange() {
        return lastChange;
    }
}
