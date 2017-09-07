package com.javarush.task.task05.task0532;

import java.io.*;

/* 
Задача по алгоритмам
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(reader.readLine());

        int maximum = 0;

        if(num > 0) {
            int[] nums = new int[num];
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
            maximum = nums[nums.length-1];
        }

        System.out.println(maximum);
    }
}
