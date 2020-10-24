package com.example.demo.lambda.string_to_char_list;

import java.util.List;
import java.util.stream.Collectors;
//https://www.techiedelight.com/convert-list-characters-string-java/
public class StringToCharList{
    public static void main(String[] args){
        String s = "abcd";
        List<Character> characterList = s.chars()//IntStream
                .mapToObj(e -> (char)e)//convert to char
                .collect(Collectors.toList());//collect in a list
        System.out.println(characterList);
    }
}
