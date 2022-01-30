package com.mawen.spock.test.chapter2;

import java.util.ArrayList;
import java.util.List;

/**
 * 比较
 *
 * @author mawen
 * @create 2022-01-30 9:30
 */
public class JavaEquality {

    public static void main(String[] args) {
        String first = "First";
        String second = "Second";

        List<String> sample = new ArrayList<>();
        sample.add(first);
        sample.add(second);

        List<String> sample2 = new ArrayList<>(sample);
        System.out.println("Result is " + (sample == sample2));
    }


}
