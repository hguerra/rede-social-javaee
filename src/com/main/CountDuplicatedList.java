package com.main;

/**
 * Created by heitor on 05/10/15.
 */

import java.util.*;

public class CountDuplicatedList {

    public static void main(String[] args) {

        List<String> list = new ArrayList<String>();
        list.add("b");
        list.add("c");
        list.add("a");
        list.add("d");
        list.add("b");
        list.add("c");
        list.add("a");
        list.add("a");
        list.add("a");

        System.out.println("\nExample 1 - Count 'a' with frequency");
        System.out.println("a : "+ elementFrequency("a", list));

        System.out.println("\nExample 2 - Count all with frequency");
        System.out.println(allElementFrequency(list));

        System.out.println("\nExample 3 - Count all with Map");
        printMap(allElementFrequencyMap(list));

        System.out.println("\nSorted Map");
        printMap(allElementFrequencyMapSorted(list));

    }

    public static Map<String, Integer> allElementFrequencyMapSorted(List<String> list) {
        Map<String, Integer> map = new TreeMap<String, Integer>();
        for (String temp : list) {
            Integer count = map.get(temp);
            map.put(temp, (count == null) ? 1 : count + 1);
        }
        return map;
    }

    public static Map<String, Integer> allElementFrequencyMap(List<String> list) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        for (String temp : list) {
            Integer count = map.get(temp);
            map.put(temp, (count == null) ? 1 : count + 1);
        }
        return map;
    }

    public static String allElementFrequency(List<String> list) {
        StringBuffer stringBuffer = new StringBuffer();
        Set<String> uniqueSet = new HashSet<String>(list);
        for (String temp : uniqueSet) {
            stringBuffer.append(temp + ":" + Collections.frequency(list, temp));
            stringBuffer.append(";");
        }
        return stringBuffer.toString();
    }

    public static Integer elementFrequency(String element, List<String> list) {
        return Collections.frequency(list, element);
    }

    public static <T> Set<T> findDuplicatesGeneric(Collection<T> list) {
        Set<T> duplicates = new LinkedHashSet<T>();
        Set<T> uniques = new HashSet<T>();
        for(T t : list) {
            if(!uniques.add(t)) {
                duplicates.add(t);
            }
        }
        return duplicates;
    }

    public static void printMap(Map<String, Integer> map) {

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println("Key : " + entry.getKey() + " Value : "
                    + entry.getValue());
        }

    }

}