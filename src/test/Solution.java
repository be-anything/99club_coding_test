package test;

import java.util.Stack;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        s.isValid("([]){");
    }
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == '(' || c == '{' || c == '[')
                stack.push(c);
            else {
                // 시작이 ), }, ]이면 안됨 -> 시작인지 어떻게 아나? empty로 체크하기
                if(stack.isEmpty())
                    return false;
                else {
                    char _c = stack.pop();
                    StringBuilder sb = new StringBuilder();
                    sb.append(_c).append(c);
                    if(!"()".contentEquals(sb) && !"{}".contentEquals(sb) && !"[]".contentEquals(sb))
                        return false;
                }
            }
        }
        return stack.isEmpty();
    }
}