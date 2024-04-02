package com.example.StationDetails.controller;

import java.util.ArrayList;
import java.util.List;

class test {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>(); // Result list to store duplicate numbers
        for (int i = 0; i < nums.length; ++i) {
            int index = Math.abs(nums[i]) - 1; // Get the index corresponding to the number
            if (nums[index] < 0) { // If the number at index is negative, it means it's seen before
                result.add(index + 1); // Add the duplicate number to the result
            } else {
                nums[index] = -nums[index]; // Mark the number as seen by negating it
            }
        }
        return result; // Return the list containing duplicate numbers
    }
}
