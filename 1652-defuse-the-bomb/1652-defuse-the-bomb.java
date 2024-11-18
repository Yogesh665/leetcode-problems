class Solution {
    public int[] decrypt(int[] code, int k) {
        int s = code.length;
        int[] ans = new int[s];
        if (k == 0) {
            return ans;
        }
        for (int i = 0; i < s; ++i) {
            if (k > 0) {
                for (int j = i + 1; j < i + k + 1; ++j) {
                    ans[i] += code[j % s];
                }
            } else {
                for (int j = i + k; j < i; ++j) {
                    ans[i] += code[(j + s) % s];
                }
            }
        }
        return ans;
    }
}