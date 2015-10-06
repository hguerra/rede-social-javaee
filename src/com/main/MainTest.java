package com.main;

import com.model.twitter.Tweet;
import com.model.util.SearchWord;

import java.util.*;

/**
 * Created by heitor on 30/09/15.
 */
public class MainTest {
    public static void main(String[] args) {
//        Tweet t = new Tweet();
//        t.tweet("Boa Noite");
        Collection<String> hash = Arrays.asList("#heitor", "#heitor", "#heitor", "#heitor", "#bacon",
                "#bacon", "#bacon", "#bacon", "#alone");

//        hash.forEach((s) -> {
//            System.out.println(s);
//
//        });

        findDuplicatesGeneric(hash).forEach((s) -> {
            System.out.println(s);

        });

    }

    public static Set<String> findDuplicates2(List<String> listContainingDuplicates) {

        final Set<String> setToReturn = new HashSet<String>();
        final Set<String> set1 = new HashSet<String>();

        final Map<String, Integer> result = new TreeMap<>();

        for (String yourInt : listContainingDuplicates) {
            if (!set1.add(yourInt)) {
                setToReturn.add(yourInt);
            }
        }
        return setToReturn;
    }

    public static <T> Set<T> findDuplicatesGeneric(Collection<T> list) {

        Set<T> duplicates = new LinkedHashSet<T>();
        Set<T> uniques = new HashSet<T>();

        for (T t : list) {
            if (!uniques.add(t)) {
                duplicates.add(t);
            }
        }

        return duplicates;
    }

    public static Set<String> findDuplicates(List<String> listContainingDuplicates) {

        final Set<String> setToReturn = new HashSet<String>();
        final Set<String> set1 = new HashSet<String>();

        for (String yourInt : listContainingDuplicates) {
            if (!set1.add(yourInt)) {
                setToReturn.add(yourInt);
            }
        }
        return setToReturn;
    }
}
