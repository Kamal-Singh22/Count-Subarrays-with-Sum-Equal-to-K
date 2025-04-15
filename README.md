# Count-Subarrays-with-Sum-Equal-to-K
Given an integer array nums and an integer k, return the total number of continuous subarrays whose sum equals to k.
 Explanation:
Prefix Sum Idea:

While traversing the array, we maintain the sum of elements from index 0 to i, called prefix sum.

If at any point, the difference (currentSum - k) has occurred before, it means there exists a subarray that sums to k.

HashMap Use:

The map stores how many times a particular prefix sum has occurred.

This allows constant-time checking if sum - k exists.

Why Initialize prefixSumCount.put(0, 1)?

This handles the case where a subarray starting from index 0 itself sums to k.

🔢 Example Trace (nums = [1,1,1], k = 2):
sum = 0 → add 1 → sum = 1 → not found sum-k= -1 → map: {0=1, 1=1}

sum = 1 → add 1 → sum = 2 → sum-k=0 → found! count = 1 → map: {0=1, 1=1, 2=1}

sum = 2 → add 1 → sum = 3 → sum-k=1 → found! count = 2 → map: {0=1, 1=1, 2=1, 3=1}
