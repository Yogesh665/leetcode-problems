class Solution {
    public int minimumSubarrayLength(int[] nums, int k) {
        int m = nums.length;
        int[] cnt = new int[32];
        int ans = m + 1;
        for (int i = 0, j = 0, s = 0; j < m; ++j) {
            s |= nums[j];
            for (int h = 0; h < 32; ++h) {
                if ((nums[j] >> h & 1) == 1) {
                    ++cnt[h];
                }
            }
            for (; s >= k && i <= j; ++i) {
                ans = Math.min(ans, j - i + 1);
                for (int h = 0; h < 32; ++h) {
                    if ((nums[i] >> h & 1) == 1) {
                        if (--cnt[h] == 0) {
                            s ^= 1 << h;
                        }
                    }
                }
            }
        }
        return ans > m ? -1 : ans;
    }
}