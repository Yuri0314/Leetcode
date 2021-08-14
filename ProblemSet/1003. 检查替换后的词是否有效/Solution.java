class Solution {
    public boolean isValid(String S) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == 'c') {
                if (stack.empty() || stack.pop() != 'b')
                    return false;
                if (stack.empty() || stack.pop() != 'a')
                    return false;
            } else {
                stack.push(S.charAt(i));
            }
        }
        return stack.isEmpty();
    }
}