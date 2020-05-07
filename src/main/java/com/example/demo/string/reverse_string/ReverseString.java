package com.example.demo.string.reverse_string;

import java.util.*;
import java.util.stream.Collectors;

public class ReverseString{

    public static void main(String[] args){
//        char a = '0';
//        char b = '9';
//        char c = 'a';
//        char d = 'A';
//        char e = 'Z';
//        char f = 'z';
//        System.out.println(a + 0);
//        System.out.println(b + 0);
//        System.out.println(c + 0);
//        System.out.println(d + 0);
//        System.out.println(e + 0);
//        System.out.println(f + 0);
//        System.out.println('(' + 0);
//        System.out.println(')' + 0);
//        System.out.println('[' + 0);
//        System.out.println('[' + 1);
//        System.out.println(']' + 0);
//        System.out.println('{' + 0);
//        //System.out.println(Character.valueOf('{'+1));
//        System.out.println('}' + 0);
        Scanner in = new Scanner(System.in);


        while(in.hasNextLine()){// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            String inputStr = in.nextLine();
            printBracket(inputStr);
            List<Character> expanded = printBracket(inputStr).chars().mapToObj(
                    c -> (char) c
            ).collect(Collectors.toList());
            Collections.reverse(expanded);
            String reversedString = expanded.stream().map(String::valueOf).collect(Collectors.joining());
            System.out.println(reversedString);
        }
    }

    private static String printBracket(String string){
        char[] charArray = string.toCharArray();
        int sequencePrintTimes = 1;
        String currentLoopString = "";
        for(Integer index = 0; index < string.length(); index++){
            if(charIsInt(charArray[index])){
                Map<String, Object> result = getNextInteger(charArray, index);
                index = (Integer)result.get("currentIndex");
                sequencePrintTimes = (int)result.get("integer");
            }else if(charIsLetter(charArray[index])){
                Map<String, Object> result = getNextCharSequ(charArray, index);
                index = (Integer)result.get("currentIndex");
                String charSequ = (String)result.get("charSequ");
                currentLoopString += charSequ;
            }else if(charIsOpeningBracket(charArray[index])){
                Integer closingBracketIndex = findIndexOfClosingBracket(charArray, index);
                String bracketString = printBracket(string.substring(index + 1, closingBracketIndex));
                for(int j = 0; j < sequencePrintTimes; j++){
                    currentLoopString += bracketString;
                }
                index = closingBracketIndex + 1;
            }
        }
        return currentLoopString;
    }

    private static Integer findIndexOfClosingBracket(char[] charArray, Integer openingBracketIndex){
        String string = String.valueOf(charArray);
        Integer closingBracketIndex = null;
        char openingBracket = charArray[openingBracketIndex];
        switch(openingBracket){
            case '(':
                closingBracketIndex = string.indexOf(")");
                break;
            case '[':
                closingBracketIndex = string.indexOf("]");
                break;
            case '{':
                closingBracketIndex = string.indexOf("}");
                break;
        }
        return closingBracketIndex;
    }

    private static boolean charIsInt(char a){
        if(a >= 48 && a <= 57){
            return true;
        }else{
            return false;
        }
    }

    private static boolean charIsLetter(char a){
        int b = a + 0;
        if(b >= 65 && b <= 122){
            return true;
        }else{
            return false;
        }
    }

    private static boolean charIsOpeningBracket(char a){
        if(a == '{' || a == '(' || a == '['){
            return true;
        }else{
            return false;
        }
    }

    private static boolean charIsClosingBracket(char a){
        if(a == '}' || a == ')' || a == ']'){
            return true;
        }else{
            return false;
        }
    }

    private static Map<String, Object> getNextInteger(char[] charArray, Integer currentIndex){
        String integerString = "";
        for(int i = currentIndex; i < charArray.length; i++){
            if(charIsInt(charArray[i])){
                integerString += charArray[i];
                currentIndex = i;
            }else{
                break;
            }
        }

        //System.out.println("integer is " + integerString);
        Map<String, Object> result = new HashMap<>();
        result.put("currentIndex", currentIndex);
        result.put("integer", Integer.valueOf(integerString));
        return result;
    }

    private static Map<String, Object> getNextCharSequ(char[] charArray, Integer currentIndex){
        String charSequ = "";
        for(int i = currentIndex; i < charArray.length; i++){
            if(charIsLetter(charArray[i])){
                charSequ += charArray[i];
                currentIndex = i;
            }else{
                break;
            }
        }

        //System.out.println("charSequ is " + charSequ);
        Map<String, Object> result = new HashMap<>();
        result.put("currentIndex", currentIndex);
        result.put("charSequ", charSequ);
        return result;
    }

}
