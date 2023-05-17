package com.leet.code.arrays;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AverageSalary {

    public double average(int[] salary) {
        List<Integer> salaryList = Arrays.stream(salary).boxed().sorted().collect(Collectors.toList());
        AtomicInteger sum = new AtomicInteger();
        IntStream.range(1, salaryList.size() - 1).forEach(i -> sum.addAndGet(salaryList.get(i)));
        return (double) sum.get() / (salaryList.size() - 2);
    }

    public double average2(int[] salary) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int sum = 0;
        for (int i = 0; i < salary.length; i++) {
            if(salary[i] > max){
                max = salary[i];
            }
            if(salary[i] < min){
                min = salary[i];
            }
            sum+=salary[i];
        }
        return (double) (sum - max - min) /(salary.length-2);
    }
}
