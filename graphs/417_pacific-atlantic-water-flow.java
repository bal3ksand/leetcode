/* https://leetcode.com/problems/pacific-atlantic-water-flow/ */

class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        boolean[][][] reaches = new boolean[heights.length][heights[0].length][2];
        for (int i = 0; i < heights.length; i++) {
            flow(heights, reaches, i, 0, 0);
            flow(heights, reaches, i, heights[i].length - 1, 1);
        }
        for (int j = 0; j < heights[0].length; j++) {
            flow(heights, reaches, 0, j, 0);
            flow(heights, reaches, heights.length - 1, j, 1);
        }
        List<List<Integer>> result = new ArrayList<>(heights.length);
        for (int i = 0; i < reaches.length; i++) {
            for (int j = 0; j < reaches[i].length; j++) {
                if (reaches[i][j][0] && reaches[i][j][1])
                    result.add(Arrays.asList(i, j));
            }
        }
        return result;
    }
    public void flow(int[][] heights, boolean[][][] reaches, int i, int j, int ocean) {
        if (reaches[i][j][ocean] == true)
            return;
        reaches[i][j][ocean] = true;
        if (i - 1 >= 0 && heights[i - 1][j] >= heights[i][j])
            flow(heights, reaches, i - 1, j, ocean);
        if (i + 1 < heights.length && heights[i + 1][j] >= heights[i][j])
            flow(heights, reaches, i + 1, j, ocean);
        if (j - 1 >= 0 && heights[i][j - 1] >= heights[i][j])
            flow(heights, reaches, i, j - 1, ocean);
        if (j + 1 < heights[i].length && heights[i][j + 1] >= heights[i][j])
            flow(heights, reaches, i, j + 1, ocean);
    }
}