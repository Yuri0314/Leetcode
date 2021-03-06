import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode id=207 lang=java
 *
 * [207] Course Schedule
 */

// @lc code=start
class Solution {
    private List<List<Integer>> graph;
    private int[] visited;
    private boolean isVaild = true;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        graph = new ArrayList<List<Integer>>(numCourses);
        for (int i = 0; i < numCourses; ++i) graph.add(new LinkedList<Integer>());
        visited = new int[numCourses];
        for (int[] prerequisit : prerequisites) graph.get(prerequisit[1]).add(0, prerequisit[0]);
        for (int i = 0; i < numCourses && isVaild; ++i) {
            if (visited[i] == 0)
                dfs(i);
        }
        return isVaild;
    }

    private void dfs(int courseLabel) {
        visited[courseLabel] = 1;
        for (int nextCourse : graph.get(courseLabel)) {
            if (visited[nextCourse] == 0) {
                dfs(nextCourse);
            }
            else if (visited[nextCourse] == 1) {
                isVaild = false;
                return;
            }
            if (!isVaild) return;
        }
        visited[courseLabel] = 2;
    }
}
// @lc code=end

