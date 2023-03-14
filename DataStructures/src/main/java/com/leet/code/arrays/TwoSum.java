package com.leet.code.arrays;

import jdk.jshell.execution.JdiInitiator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TwoSum {
    public static void main(String[] args) {

        int[] nums = {2, 7, 11, 15};
        System.out.println(Arrays.toString(twoSum(nums, 9)));
    }

    public static int[] twoSum(int[] nums, int target) {
        int[] diff = new int[nums.length];
        for (var i = 0; i < nums.length; i++) {
            diff[i] = target - nums[i];
        }
        var diffList = new ArrayList<Integer>();
        for(int d : diff){
            diffList.add(d);
        }
        var firstInd = -1;
        var secondInd = -1;
        for (var i = 0; i < nums.length; i++) {
            if (diffList.contains(nums[i]) && i != diffList.indexOf(nums[i])) {
                firstInd = i;
                secondInd = diffList.indexOf(nums[i]);
                break;
            }
        }
        return new int[]{firstInd, secondInd};
    }
}