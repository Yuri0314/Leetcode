class Solution {
    private char[] commandStr;
    private int commandX = 0;   // 一次命令走到的最远x
    private int commandY = 0;   // 一次命令走到的最远Y
    public boolean robot(String command, int[][] obstacles, int x, int y) {
        this.commandStr = command.toCharArray();
        for (char c : commandStr) {
            if (c == 'R') ++commandX;
            else ++commandY;
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
        x -= k * commandX;
        y -= k * commandY;
        for (char c : commandStr) {
            if (x == 0 && y == 0) return true;
            if (c == 'R') --x;
            else --y;
        }
        return false;
    }
}