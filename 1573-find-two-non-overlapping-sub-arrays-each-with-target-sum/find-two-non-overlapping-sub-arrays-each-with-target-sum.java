class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int n = arr.length;
        int INF = n + 1;
        int[] minLen = new int[n];

        Arrays.fill(minLen, INF);

        int left = 0;
        int sum = 0;
        int ans = INF;
        int best = INF;

        for (int right = 0; right < n; right++) {
            sum += arr[right];

            while (sum > target) {
                sum -= arr[left++];
            }

            if (sum == target) {
                int len = right - left + 1;

                // Combine with the best valid subarray before 'left'
                if (left > 0 && minLen[left - 1] != INF) {
                    ans = Math.min(ans, len + minLen[left - 1]);
                }

                best = Math.min(best, len);
            }

            // Best valid subarray ending at or before 'right'
            minLen[right] = best;
        }

        return ans == INF ? -1 : ans;
    }
}