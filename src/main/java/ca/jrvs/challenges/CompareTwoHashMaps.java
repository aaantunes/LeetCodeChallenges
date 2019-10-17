package main.java.ca.jrvs.challenges;

import java.util.HashMap;
import java.util.Map;

public class CompareTwoHashMaps {

    public static <K,V> boolean compareMaps(Map<K, V> m1, Map<K, V> m2) {
        if (m1.size() != m2.size()){
            return false;
        }
        for (K key : m1.keySet()){
            if (!(m2.containsKey(key) && m1.get(key).equals(m2.get(key)))){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Map<String, Integer> m1 = new HashMap<>();
        m1.put("A", 1);
        m1.put("B", 1);
        m1.put("C", 1);
        m1.put("D", 1);
        m1.put("E", 1);

        Map<String, Integer> m2 = new HashMap<>();
        m2.put("C", 1);
        m2.put("D", 1);
        m2.put("A", 1);
        m2.put("B", 1);


        if (compareMaps(m1, m2)){
            System.out.println("They are the same");
        } else
            System.out.println("Not same");
    }
}
