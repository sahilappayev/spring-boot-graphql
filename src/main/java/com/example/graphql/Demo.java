package com.example.graphql;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Demo {

    public static void main(String[] args) {

        System.out.println(rollTheString("abz", List.of(3, 1, 2)));

    }

    public static String rollTheString(String s, List<Integer> roll) {
        char[] chars = new char[s.length()];
        for (int i = 0; i < s.length(); i++) {
            chars[i] = s.charAt(i);
        }
        for (Integer r : roll) {
            for (int i = 0; i < r; i++) {
                int value = chars[i] + 1;
                chars[i] = value > 122 ? 'a' : (char) value;
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (char c : chars) {
            stringBuilder.append(c);
        }
        return stringBuilder.toString();
    }

    public static String rollTheStringMap(String s, List<Integer> roll) {
        char[] chars = new char[s.length()];
        for (int i = 0; i < s.length(); i++) {
            chars[i] = s.charAt(i);
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < roll.size(); i++) {
            map.put(i, roll.get(i));
        }
        int j = 0;
        for (int i = 0; i < map.get(j); i++) {
            int value = chars[i] + 1;
            chars[i] = value > 122 ? 'a' : (char) value;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (char c : chars) {
            stringBuilder.append(c);
        }
        return stringBuilder.toString();
    }

}
