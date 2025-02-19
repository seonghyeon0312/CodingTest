import java.util.Stack;

class Solution {
    boolean solution(String s) {
         boolean answer = false;
            String[] split = s.split("");
            final boolean result= s.contains(")");
            Stack<String> stack = new Stack<>();
            if(result){
                for (String ch : split) {
                    if (ch.equals(")")) {
                        if (!stack.isEmpty()) {
                            stack.pop();
                        }else{
                            stack.add(ch);
                            break;
                        }
                    }else{
                        stack.add(ch);
                    }
                }
                answer = stack.isEmpty();
            }
            return answer;
    }
}