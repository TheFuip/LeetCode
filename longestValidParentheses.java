import java.util.Stack;

public class longestValidParentheses {
    public static void main(String[] args) {
        /*
         * Given a string containing just the characters '(' and ')', 
         * find the length of the longest valid (well formed () ) parenthesis substring
         */
        System.out.println(validParentheses("(()"));
    }

    //use dynamic programming recursion - to recurse throught a string
    public static int validParentheses(String s){
        int count = 0;

        Stack<Integer> stack = new Stack<>();

        stack.push(-1);

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                //if s.char(i) = '(' push that value to the top of the stack
                stack.push(i);
            } else {
                //otherwise remove the top of the stack
                stack.pop();

                //if the stack is empty push the value of i to the top of it
                if (stack.empty()) {
                    stack.push(i);
                } else { //otherwise get the max value of count, and the value of i - the current val on the stack
                    count = Math.max(count, i - stack.peek());
                }
            }
        }

        //return count
        return count;
    }
}
/*
 * basic recursion | prints out the string from right to left
 * 
 *   if(s.length() < 2){
            return 0;
        }
        
        System.out.println(s.charAt(s.length() - 1));

        return validParentheses(s.substring(0, s.length() - 1));
 */