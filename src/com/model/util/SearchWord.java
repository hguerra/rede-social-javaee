package com.model.util;

import java.util.*;

/**
 * Created by heitor on 05/10/15.
 */
public class SearchWord {

    public static void hashTags(){

    }

    /**
     *
     * @param text
     * @return  SearchWord.searchAtSignAndNumberSign(text).get(0) -> @
     * @return  SearchWord.searchAtSignAndNumberSign(text).get(1) -> #
     */
    public static List<Set<String>> searchAtSignAndNumberSign(String text) {
        List<Set<String>> result = null;
        if (text.contains("@") || text.contains("#")) {
            result = new LinkedList<>();
            Set<String> resultAtSign = new HashSet<>();
            Set<String> resultNumberSign = new HashSet<>();
            List<String> words = words = Arrays.asList(text.split(" "));
            for (int i = 0; i < words.size(); i++) {
                if (words.get(i).startsWith("@")) {
                    resultAtSign.add(words.get(i));
                }
                if (words.get(i).startsWith("#")) {
                    resultNumberSign.add(words.get(i));
                }
            }
            result.add(resultAtSign);
            result.add(resultNumberSign);
        }
        return result;
    }

    public static Set<String> searchAtSign(String text) {
        Set<String> result = null;
        if (text.contains("@")) {
            result = new HashSet<>();
            List<String> words = words = Arrays.asList(text.split(" "));
            for (int i = 0; i < words.size(); i++) {
                if (words.get(i).startsWith("@")) {
                    result.add(words.get(i));
                }
            }
        }
        return result;
    }

    public static Set<String> searchNumberSign(String text) {
        Set<String> result = null;
        if (text.contains("#")) {
            result = new HashSet<>();
            List<String> words = words = Arrays.asList(text.split(" "));
            for (int i = 0; i < words.size(); i++) {
                if (words.get(i).startsWith("#")) {
                    result.add(words.get(i));
                }
            }
        }
        return result;
    }


}
