package dev.abdillah;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class Main {
    public static void main(String[] args) {
        Consumer<String> printTheParts = new Consumer<String>() {
            @Override
            public void accept(String sentence) {
                String[] parts = sentence.split(" ");

                for (String part : parts) {
                    System.out.println(part);
                }
            }
        };

        Consumer<String> printWordsLambda = (s) -> {
            String[] parts = s.split(" ");
            for (String part : parts) {
                System.out.println(part);
            }
        };

        Consumer<String> printWordsLambdaForEach = (s) -> {
            String[] parts = s.split(" ");
            Arrays.asList(parts).forEach((word) -> System.out.println(word));
        };



        Consumer<String> printWordsLambdaConcise = (s) -> Arrays.asList(s.split(" ")).forEach(word -> System.out.println(word));
//        printWordsLambdaConcise.accept("this is a test");
//        printWordsLambdaForEach.accept("this is a test");
//        printTheParts.accept("this is a test");
//        printWordsLambda.accept("this is a test");


//        System.out.println(everySecondChar("123456789"));

//        Arrays.asList("123456789".split("")).forEach(System.out::println);

        UnaryOperator<String> everySecondChar = source -> {
            StringBuilder res = new StringBuilder();
            for(int i = 0; i < source.length(); i++) {
                if(i%2 == 1) {
                    res.append(source.charAt(i));
                }
            }
            return res.toString();
        };

        String a = "1234567890";
        System.out.println(everySecondChar.apply(a));

        System.out.println(testing(a, everySecondChar));

        Supplier<String> write = () -> "I Love Java";

        String iLoveJava = write.get();

        System.out.println(iLoveJava);
    }

    public static String testing (String value, UnaryOperator<String> everySecondChar) {
        return everySecondChar.apply(value);
    }

    public static String everySecondChar(String source) {
        StringBuilder returnVal = new StringBuilder();
        for (int i = 0; i < source.length(); i++) {
            if(i%2 == 1) {
                returnVal.append(source.charAt(i));
            }
        }
        return returnVal.toString();
    }

}