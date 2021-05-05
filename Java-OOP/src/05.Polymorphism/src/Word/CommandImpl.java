package Word;

public abstract class CommandImpl extends TextTransform implements CommandInterface {

    protected CommandImpl(String text) {
        super(text);
    }

    @Override
    public String uppercase(int startIndex, int endIndex) {

        validateInput(startIndex, endIndex);

       char[] chars = super.getText().toCharArray();
        for (int i = startIndex; i < endIndex ; i++) {
           chars[i] = Character.toUpperCase(chars[i]);
        }
        super.setText(String.valueOf(chars));
        return super.getText();
    }

    @Override
    public String cut(int startIndex, int endIndex) {

        validateInput(startIndex, endIndex);

        StringBuilder sb = new StringBuilder(super.getText());
        String removed = sb.substring(startIndex, endIndex);
        sb.replace(startIndex, endIndex, "");

        super.setLastChange(removed);
        super.setText(sb.toString());
        return super.getText();
    }

    @Override
    public String paste(int startIndex, int endIndex) {


        StringBuilder sb = new StringBuilder(super.getText());
        String replaced = "";

        if(startIndex == endIndex){
            sb.insert(startIndex, super.getLastChange());
        } else {
           replaced = sb.replace(startIndex, endIndex, super.getLastChange()).toString();
        }
        super.setText(replaced);
        super.setLastChange(replaced);
        return replaced;
    }

    public void validateInput(int startIndex, int endIndex){
        if (startIndex == endIndex){
            throw new IllegalArgumentException("StartIndex and endIndex cannot be equal");
        }
    }
}
