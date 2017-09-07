package com.javarush.task.task06.task0622;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Числа по возрастанию
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] nums = new int[5];
        for(int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(reader.readLine());
        }

        for(int i = 0; i < nums.length; i++) {
            for(int j = 1; j < nums.length; j++) {
                if(nums[j-1] > nums[j]) {
                    int temp = nums[j-1];
                    nums[j-1] = nums[j];
                    nums[j] = temp;
                }
            }
        }

        for(int i : nums) {
            System.out.println(i);
        }
    }
}
