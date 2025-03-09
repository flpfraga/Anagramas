package org.example;


public class Main {

    public static void main(String[] args) {

        Anagram anagram = new Anagram.Builder()
                .word("a,b,c,d")
                .separator(",")
                .build();
        anagram.make();
        anagram.getAnagrams().forEach(System.out::println);
    }
}
