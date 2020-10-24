package com.bladespear.demo.double11;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Arrays;
import java.util.List;

public class BonusStatus {
    private Boolean used = false;
    private Bonus bonus;
    void a() {
        Long[] array = {123L, 234L, 345L};
        List<Long> list = Arrays.asList(array);
        Bonus bonus = new Bonus(1, 6, 1, list);
        Long[] arra1y = {1123L, 1234L, 1345L};
        List<Long> list1 = Arrays.asList(array);
        Bonus bonus1 = new Bonus(2, 6, 2, list1);

        ObjectMapper mapper = new ObjectMapper();
        

    }
}
