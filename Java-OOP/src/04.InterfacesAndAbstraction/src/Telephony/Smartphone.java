package Telephony;

import java.util.List;

public class Smartphone implements Browsable, Callable {
    private List<String> numbers;
    private List<String> urls;

    public Smartphone(List<String> numbers, List<String> urls){
        this.numbers = numbers;
        this.urls = urls;
    }

    @Override
    public String browse() {

        StringBuilder result = new StringBuilder();

        for (String url : urls) {
            if(isValid(url)){
                result.append(String.format("Browsing...%s", url));
                result.append(System.lineSeparator());
            }else {
                result.append("Invalid url!").append(System.lineSeparator());
            }
        }

        return result.toString().trim();
    }

    @Override
    public String call() {
        StringBuilder result = new StringBuilder();

        for (String number : numbers) {
            if(isValidNumber(number)){
                result.append(String.format("Calling...%s", number));
                result.append(System.lineSeparator());
            } else {
                result.append("Invalid number!").append(System.lineSeparator());
            }
        }

        return result.toString().trim();
    }

    private static boolean isValid(String browse) {
        for (int i = 0; i < browse.length(); i++) {
            if (Character.isDigit(browse.charAt(i))){
                return false;
            }
        }
        return true;
    }
    private static boolean isValidNumber(String number) {
        for (int i = 0; i < number.length(); i++) {
            if (Character.isLetter(number.charAt(i))){
                return false;
            }
        }
        return true;
    }

}
