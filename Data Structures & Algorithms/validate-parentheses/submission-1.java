class Solution {
    public boolean isValid(String s) {
         Deque<Character> stack = new ArrayDeque<>();
         for(char c : s.toCharArray()) {
            if(c == '[' || c == '{' || c == '('){
                stack.addLast(c);
                continue;
            }

            if(stack.isEmpty()) return false;

            if(c == ']' && stack.pollLast() != '[') return false;
            if(c == '}' && stack.pollLast() != '{') return false;
            if(c == ')' && stack.pollLast() != '(') return false;
         }

         return stack.isEmpty();
    }
}
