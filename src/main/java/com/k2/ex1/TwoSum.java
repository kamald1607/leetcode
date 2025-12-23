package com.k2.ex1;


import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;

public class TwoSum {
    public static void main(String[] args) {
        // demo usage: prints indices for input [2,7,11,15] target 9 -> [0, 1]
        TwoSum solver = new TwoSum();
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] result = solver.twoSum(nums, target);
        System.out.println("twoSum(" + Arrays.toString(nums) + ", " + target + ") -> " + Arrays.toString(result));
    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        int[] output = {-1,-1};
        for(int i=0;i<nums.length;i++){
            int complement = target - nums[i];
            if(!map.containsKey(complement)){
                map.put(nums[i],i);
            }
            else{
                output[0]=map.get(complement);
                output[1]= i;
                break;
            }
        }
        return output;
    }
}