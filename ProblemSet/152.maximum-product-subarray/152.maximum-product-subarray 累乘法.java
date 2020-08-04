/*
 * @lc app=leetcode id=152 lang=java
 *
 * [152] Maximum Product Subarray
 */

// @lc code=start
class Solution {
    public int maxProduct(int[] nums) {
        int product1, product2;
        int max_product = Integer.MIN_VALUE;
        boolean minusFlag = false;
        product1 = product2 = 1;
        for (int i = 0; i < nums.length; ++i) {
            int tmp;
            product1 *= nums[i];
            if (minusFlag) {
                product2 *= nums[i]; 
                tmp = Math.max(product1, product2);
            } 
            else tmp = product1;
            if (tmp > max_product) max_product = tmp;
            if (nums[i] == 0) { // 一旦碰到0，就重新计算所有值
                product1 = product2 = 1;
                minusFlag = false;
                continue;
            }
            else if (nums[i] < 0) minusFlag = true;
        }
        return max_product;
    }
}
// @lc code=end

