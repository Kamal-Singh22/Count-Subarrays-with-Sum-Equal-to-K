import java.util.HashMap;

public class SubarraySumEqualsK {
    public static int subarraySum(int[] nums, int k) {
        // This map keeps track of the count of prefix sums
        HashMap<Integer, Integer> prefixSumCount = new HashMap<>();
        prefixSumCount.put(0, 1);  // For subarrays starting from index 0

        int count = 0;
        int sum = 0;

        for (int num : nums) {
            sum += num;

            // If (sum - k) exists in map, we found a subarray ending at current index with sum k
            if (prefixSumCount.containsKey(sum - k)) {
                count += prefixSumCount.get(sum - k);
            }

            // Update the count of current prefix sum
            prefixSumCount.put(sum, prefixSumCount.getOrDefault(sum, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, -2, 5, -1, 1, 1};
        int k = 4;

        int result = subarraySum(nums, k);
        System.out.println("Number of subarrays with sum " + k + " = " + result);
    }
}
