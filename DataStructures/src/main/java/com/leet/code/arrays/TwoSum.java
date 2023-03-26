package com.leet.code.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {

        int[] nums = {3, 3};
        System.out.println(Arrays.toString(twoSumV3(nums, 6)));
    }

    public static int[] twoSum(int[] nums, int target) {
        int[] diff = new int[nums.length];
        for (var i = 0; i < nums.length; i++) {
            diff[i] = target - nums[i];
        }
        var diffList = new ArrayList<Integer>();
        for (int d : diff) {
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

    public static int[] twoSumV2(int[] nums, int target) {
        Map<Integer, Integer> diffMap = new HashMap<>();
        for (var i = 0; i < nums.length; i++) {
            diffMap.put(target - nums[i], i);
        }
        int firstInd = -1;
        int secondInd = -1;
        for (var i = 0; i < nums.length; i++) {
            if (diffMap.containsKey(nums[i]) && i != diffMap.get(nums[i])) {
                firstInd = i;
                secondInd = diffMap.get(nums[i]);
                break;
            }
        }
        return new int[]{firstInd, secondInd};
    }

    public static int[] twoSumV3(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        // In case there is no solution, we'll just return null
        return null;
    }
}