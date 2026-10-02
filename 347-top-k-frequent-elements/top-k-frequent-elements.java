class Solution {

    public int[] topKFrequent(int[] nums, int k) {

        int n = nums.length;

        // Step 1: Count frequency of each number
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // bucket[i] stores numbers having frequency i
        List<Integer>[] bucket = new ArrayList[n + 1];

        // Step 2: Place numbers into their frequency bucket
        for (int key : map.keySet()) {

            int freq = map.get(key);

            // Create list if bucket is empty
            if (bucket[freq] == null) {
                bucket[freq] = new ArrayList<>();
            }

            // Add number into its frequency bucket
            bucket[freq].add(key);
        }

        int[] ans = new int[k];
        int index = 0;

        // Step 3: Traverse from highest frequency bucket
        for (int i = bucket.length - 1; i >= 0 && index < k; i--) {

            // Skip empty buckets
            if (bucket[i] != null) {

                // Take all numbers from current bucket
                for (int num : bucket[i]) {

                    ans[index++] = num;

                    // Stop once k elements are collected
                    if (index == k)
                        break;
                }
            }
        }

        return ans;
    }
}