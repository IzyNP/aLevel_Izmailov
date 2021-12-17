package com.izmaylov.hw16.utilForCollectionFraemwork;

import java.util.*;

public class Dictionary {
    private final DictionaryComparator dictionaryComparator = new DictionaryComparator();
    private final Map<String, Integer> dictionary = new HashMap<>();

    public  List frequencyDictionary(String string){
        String[] splitString = string.split(" ");
        Integer count;
        for (String s : splitString) {
            if(!dictionary.containsKey(s)){
                count = 1;
                dictionary.put(s, count);
            }else{
                count = dictionary.get(s);
                count++;
                dictionary.replace(s,count);
            }
        }
        List<Map.Entry<String, Integer>> list = new ArrayList(dictionary.entrySet());
        list.sort(dictionaryComparator);
        return list;
        //dictionary.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue().reversed()).forEach(System.out::println);
    }


}
