import java.util.HashSet;
import java.util.Set;

class Solution {
    private Set<Long> route = new HashSet<Long>();  // 存储第一次命令的所有路径点
    private int commandX = 0;   // 一次命令走到的最远x
    private int commandY = 0;   // 一次命令走到的最远Y
    public boolean robot(String command, int[][] obstacles, int x, int y) {
        route.add((long)0);
        for (char c : command.toCharArray()) {
            if (c == 'R') ++commandX;
            else ++commandY;
            route.add((long) commandX << 30 | commandY);
        }
        if (!checkPoint(x, y)) return false;    // 判断终点是否可达
        for (int[] obstacle: obstacles) {   // 判断是否经过每个障碍
            if (obstacle[0] <= x && obstacle[1] <= y && checkPoint(obstacle[0], obstacle[1]))
                return false;
        }
        return true;
    }

    private boolean checkPoint(int x, int y) {
        int k = Math.min(x / commandX, y / commandY);
        return route.contains((long) (x - commandX * k) << 30 | (y - commandY * k));
    }
}