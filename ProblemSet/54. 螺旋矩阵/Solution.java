class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new LinkedList<Integer>();
        if (matrix == null || matrix.length == 0) return ans;
        int top = 0, down = matrix.length - 1, left = 0, right = matrix[0].length - 1;
        int nums = matrix.length * matrix[0].length;
        while (nums >= 1) {
            for (int i = left; i <= right && nums >= 1; ++i){
                ans.add(matrix[top][i]);
                --nums;
            }
            ++top;
            for (int i = top; i <= down && nums >= 1; ++i) {
                ans.add(matrix[i][right]);
                --nums;
            }
            --right;
            for (int i = right; i >= left && nums >= 1; --i) {
                ans.add(matrix[down][i]);
                --nums;
            }
            --down;
            for (int i = down; i >= top && nums >= 1; --i) {
                ans.add(matrix[i][left]);
                --nums;
            }
            ++left;
        }
        return ans;
    }
}