package com.nixsolutions.laba4;

import interfaces.task4.MapUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class MapUtilsImpl implements MapUtils {
    public MapUtilsImpl() {
    }

    @Override public Map<String, Integer> findThrees(String s) {
        if (s == null) {
            throw new NullPointerException("String is null");
        }
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length() - 2; i++) {
            String word = s.substring(i, i + 3);
            String reg = "[a-zA-Z0-9]{3}";
            boolean res = word.matches(reg);
            if (res) {
                if (map.containsKey(word)) {
                    int n = map.get(word);
                    n++;
                    map.put(word, n);
                } else {
                    map.put(word, 1);
                }
            }
        }
        map.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue()
                        .reversed()).forEach(System.out::println);
        return map;
    }

    public static void main(String[] args) {
        MapUtils m = new MapUtilsImpl();
        String s = "Because of their simplicity, text files are commonly used "
                + "for storage of information. They avoid some of the problems "
                + "encountered with other file formats, such as endianness, "
                + "padding bytes, or differences in the number of bytes in a "
                + "machine word. Further, when data corruption occurs in a text"
                + " file, it is often easier to recover and continue processing"
                + " the remaining contents.";
        m.findThrees(s);
    }
}
