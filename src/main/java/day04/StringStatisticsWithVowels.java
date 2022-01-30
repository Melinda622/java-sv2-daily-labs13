package day04;

import java.util.*;

public class StringStatisticsWithVowels {

    public Map<Character,Integer> countVowels(String word){

        Map<Character,Integer> result=new TreeMap<>();

        List<Character> vowels= Arrays.asList('a','e','i','o','u');

        word=word.toLowerCase();

        for (int i = 0; i < word.length(); i++) {
            if(result.containsKey(word.charAt(i))){
                for (int j = 0; j < vowels.size(); j++) {
                    if(word.charAt(i)==vowels.get(j)){
                        result.put(word.charAt(i), result.get(word.charAt(i))+1);
                    }
                }
            }else{
                for (int j = 0; j <vowels.size() ; j++) {
                    if(word.charAt(i)==vowels.get(j)){
                        result.put(word.charAt(i), 1);
                    }
                }
            }
        }
        return result;
    }
}
