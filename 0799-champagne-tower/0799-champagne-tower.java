class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
        double[] pre = new double[query_row + 2];
        pre[0] = poured;
        for (int i = 0; i < query_row; i++) {
            double[] next = new double[query_row + 2];
            for (int j = 0; j <= i; j++) {
                if (pre[j] > 1) {
                    double over = (pre[j] - 1) / 2.0;
                    next[j] += over;
                    next[j + 1] += over;
                }
            }
            pre = next;
        }
        return Math.min(1.0, pre[query_glass]);
    }
}
