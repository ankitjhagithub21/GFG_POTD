/*
Question
Given an unsorted array of integers arr[], and a target tar, determine the number of subarrays whose elements sum up to the target value. Input: arr[] = [10, 2, -2, -20, 10] , tar = -10
Output: 3
Explanation: Subarrays with sum -10 are: [10, 2, -2, -20], [2, -2, -20, 10] and [-20, 10]. 

*/


import java.util.HashMap;

public class SubarraySum {
    public static int subarraySum(int[] arr, int tar) {
        // HashMap to store the cumulative sum frequencies
        HashMap<Integer, Integer> sumMap = new HashMap<>();
        int currentSum = 0;
        int count = 0;
        
        // Initialize sumMap with sum 0 seen once (base case)
        sumMap.put(0, 1);
        
        for (int num : arr) {
            // Update the cumulative sum
            currentSum += num;
            
            // Check if there's a subarray (ending here) whose sum is target
            if (sumMap.containsKey(currentSum - tar)) {
                count += sumMap.get(currentSum - tar);
            }
            
            // Add the current cumulative sum to the map
            sumMap.put(currentSum, sumMap.getOrDefault(currentSum, 0) + 1);
        }
        
        return count;
    }

    public static void main(String[] args) {
        int[] arr = {10, 2, -2, -20, 10};
        int tar = -10;

        int result = subarraySum(arr, tar);
        System.out.println("Number of subarrays with sum " + tar + ": " + result);  // Output: 3
    }
}
