package Word;

public interface CommandInterface {

    String uppercase(int startIndex, int endIndex);
    String cut(int startIndex, int endIndex);
    String paste(int startIndex, int endIndex);
}
