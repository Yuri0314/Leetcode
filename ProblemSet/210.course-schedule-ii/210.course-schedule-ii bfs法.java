import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * @lc app=leetcode id=210 lang=java
 *
 * [210] Course Schedule II
 */

// @lc code=start
class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<List<Integer>>(numCourses);
        for (int i = 0; i < numCourses; ++i) graph.add(new LinkedList<Integer>());
        int[] inEdgeNum = new int[numCourses];
        int[] ans = new int[numCourses];
        int pos = 0;
        for (int[] prerequisit : prerequisites) {
            graph.get(prerequisit[1]).add(0, prerequisit[0]);
            ++inEdgeNum[prerequisit[0]];
        }
        Queue<Integer> queue = new LinkedList<Integer>();
        for (int i = 0; i < numCourses; ++i) {
            if (inEdgeNum[i] == 0)
                queue.offer(i);
        }
        while (!queue.isEmpty()) {
            int courseLabel = queue.poll();
            ans[pos++] = courseLabel;
            for (int nextCourse : graph.get(courseLabel)) {
                --inEdgeNum[nextCourse];
                if (inEdgeNum[nextCourse] == 0) queue.offer(nextCourse);
            }

        }
        return (pos == numCourses) ? ans : new int[0];
    }
}
// @lc code=end

