package test;

import java.util.Arrays;
import java.util.Stack;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        s.isValid("([]){");
        s.numberGame(new int[]{2,5});
    }

    public int[] numberGame(int[] nums) {
        int[] result = new int[nums.length];
        // 1. 작은 값 순으로 정렬하기
        for(int i = 0; i < nums.length; i++){
            int min = nums[i];
            for(int j = i + 1; j < nums.length; j++){
                if(nums[j] < min){
                    min = nums[j];
                    nums[j] = nums[i];
                    nums[i] = min;
                }
            }
        }
        // 2. 2칸씩 자리바꿔서 저장하기
        for(int i = 0; i < nums.length; i += 2){
            int tmp = nums[i + 1];
            nums[i + 1] = nums[i];
            nums[i] = tmp;
        }
        return result;
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