class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        double[][] pairs = new double[n][2];
        for (int i = 0; i < n; i++)
            pairs[i] = new double[] {position[i], (double)(target - position[i]) / speed[i]};
        Arrays.sort(pairs, (a, b) -> Double.compare(a[0], b[0]));
        int result = 0;
        double currLongest = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (pairs[i][1] > currLongest) {
                result++;
                currLongest = pairs[i][1];
            }
        }
        return result;
    }
}