package com.example.demo.clazz;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class CustomGenderComparatorDemo {
    @Test
    public void test2() {
        String[] genders = {"lesbian", null, "other", "female", "gay", "male"};
        List<String> genderList = Arrays.asList(genders);
        //genderList will be shuffled
        int shuffleCount = 100;
        // I need the list sorted to `[male, female, gay, lesbian, other, null]`
        //
        // the rule is based on:
        //
        // 1. male is before everything else
        // 2. null is after everything else
        // 3. female is before everything else but after male
        // 4. other is after everything else but before null
        // 5. all other strings sort by the rule of String class's compareTo method
        for (int i = 0; i < shuffleCount; i++) {
            Collections.shuffle(genderList);
            System.out.println("sorting" + genderList);
            List<String> result = sortGender(genderList, false);
            if(!"[male, female, gay, lesbian, other, null]".equals(result.toString())) {
                System.out.println("sort failed");
                System.out.println(result);
            }
            System.out.println();
        }
    }


    private List<String> sortGender(List<String> genderList, boolean showDetail) {
        AtomicInteger result = new AtomicInteger();
        genderList.sort((a, b) -> {
            if(showDetail) {
                System.out.println("a: " + a + " b: " + b);
            }
            if(a == null) {
                result.set(1);
            }else if(b == null) {
                result.set(-1);
            }else{
                if("male".equals(a)) {
                    result.set(-1);
                }else if("male".equals(b)) {
                    result.set(1);
                }else if("female".equals(a)) {
                    result.set(-1);
                }else if("female".equals(b)) {
                    result.set(1);
                }else if("other".equals(a)) {
                    result.set(1);
                }else if("other".equals(b)) {
                    result.set(-1);
                }else{
                    result.set(a.compareTo(b));
                }
            }
            if(showDetail) {
                System.out.println("result: " + result);
                System.out.println();
            }
            return result.get();
        });
        return genderList;
    }

}
