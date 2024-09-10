package dev.abdillah;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        String[] names = {"Anna", "Achmad", "Bob", "John"};
        System.out.println("Hello world!");

        Arrays.setAll(names, i -> names[i].toUpperCase());
        System.out.println("--> transform to uppercase");
        System.out.println(Arrays.toString(names));

        List<String> backedByArray = Arrays.asList(names);

        backedByArray.replaceAll(name -> name + " " + getRandomChar('A', 'D') + ".");
        System.out.println("--> middle name generated");
        System.out.println(Arrays.toString(names));

        System.out.println("--> add last name");
        Arrays.setAll(names, i -> backedByArray.get(i) + " " + getReversedName(names[i].split(" ")[0]));
        Arrays.asList(names).forEach(System.out::println);

        System.out.println("--> remove names where first = last");
        List<String> newList = new ArrayList<>(List.of(names));

//        Approach 1
        newList.removeIf(s -> s.substring(0, s.indexOf(" ")).equals(s.substring(s.lastIndexOf(" ") + 1)));
        newList.forEach(System.out::println);

//        Approach 2
        newList.removeIf(s -> {
            String first = s.substring(0, s.indexOf(" "));
            String last = s.substring(s.lastIndexOf(" ") + 1);
            return first.equals(last);
        });
        newList.forEach(System.out::println);


    }

    public static char getRandomChar(char startChar, char endChar) {
        Random random = new Random();
        return (char) random.nextInt((int) startChar, (int) endChar + 1);
    }

    public static String getReversedName(String firstName) {
        return new StringBuilder(firstName).reverse().toString();
    }

}