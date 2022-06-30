import java.util.Stack;

public class validParentheses {
    public static void main(String[] args) {
        /*
         * Given a string s containing just the characters '(', ')', '{', '}', '[' and
         * ']', determine if the input string is valid.
         * 
         * An input string is valid if:
         * 
         * Open brackets must be closed by the same type of brackets.
         * Open brackets must be closed in the correct order.
         * 
         * () is valid, [] is valid, {} is valid
         */
        // String s = "(){}}"; //expected false
        System.out.println(isValid(")"));
        // isValid("{}()");

    }

    // Solution: traverse the string from left to right and see if left and right
    // character match with each other | we also know the right side of parentheses
    // will be on the right side, and left side of parentheses will be on left side
    //the logic is that the stack will be empty if the answer is valid
    public static boolean isValid(String s) {

        Stack<Character> symbol = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                symbol.push(c);
            } else if (c == ')' && !symbol.isEmpty() && symbol.peek() == '(' || c == ']' && !symbol.isEmpty() && symbol.peek() == '[' || c == '}' && !symbol.isEmpty() && symbol.peek() == '{') {
                symbol.pop();
            } else {
                return false;
            }
        }

        return symbol.isEmpty();
    }
}
