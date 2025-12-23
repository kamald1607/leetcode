package com.k2.ex1;


import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        
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