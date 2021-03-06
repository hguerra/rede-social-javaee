package com.model.util;

/**
 * Created by heitor on 05/10/15.
 */
import java.util.*;
public class CountDuplicatedList {

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