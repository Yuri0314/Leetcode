class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int ans = 0;
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[0].length; ++j)
                ans = Math.max(ans, bfs(grid, i, j));
        }
        return ans;
    }

    private int bfs(int[][] grid, int i, int j) {
        int area = 0;
        Queue<Integer> queuei = new LinkedList<Integer>();
        Queue<Integer> queuej = new LinkedList<Integer>();
        queuei.offer(i);
        queuej.offer(j);
        while (!queuei.isEmpty()) {
            int cur_i = queuei.poll(), cur_j = queuej.poll();
            if (cur_i < 0 || cur_j < 0 || cur_i == grid.length || cur_j == grid[0].length || grid[cur_i][cur_j] == 0)
                continue;
            grid[cur_i][cur_j] = 0;
            ++area;
            int[] di = {0, 0, 1, -1};
            int[] dj = {1, -1, 0, 0};
            for (int k = 0; k < 4; ++k) {
                queuei.offer(cur_i + di[k]);
                queuej.offer(cur_j + dj[k]);
            }
        }
        return area;
    }
}