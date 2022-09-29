public class removeKDigits {
    public static void main(String[] args) {
        /*
         * Given string num representing a non-negative integer num, and an integer k,
         * return the smallest possible integer after removing k digits from num.
         * 
         * Input: num = "1432219", k = 3
         * Output: "1219"
         * Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219
         * which is the smallest.
         * 
         * Input: num = "10200", k = 1
         * Output: "200"
         * Explanation: Remove the leading 1 and the number is 200. Note that the output
         * must not contain leading zeroes.
         */
        System.out.println(removeDigits("1432219", 3));
    }
    public static String removeDigits(String num, int k){
        if(k == num.length()){
            return "0";
        }else if(num.length() == 2){
            return Character.getNumericValue(num.charAt(1)) > Character.getNumericValue(num.charAt(0)) ? String.valueOf(num.charAt(0)) : String.valueOf(num.charAt(1));
        }

        char[] tempNum = num.toCharArray();
        String ans = "";

        for(int i = 0; i < k + 1; i++){
            if(Character.getNumericValue(tempNum[i]) > Character.getNumericValue(tempNum[i + 1])){
                tempNum[i] = '-';
            }
            if(tempNum[i] != '-'){
                ans += tempNum[i];
            }
        }
        
        if(num.length() > 3){
            ans += num.substring(num.length() - k + 1);
            //ans += num.substring(k + 1);
        }
        
        return ans.charAt(0) == '0' && ans.length() > 1 ? ans.substring(1) : ans;
    }
}

/*
 * actual solution: greedy w/stack
 * 
 *   Stack<Integer>stack=new Stack<>();
        for(int i=0;i<num.length();i++){
            int n=num.charAt(i)-48;
            while(k>0&&!stack.isEmpty()&&n<stack.peek()){
                stack.pop();
                k--;
            }
            stack.push(n);
        }
        //if there is any extra element than k elements in stack remove
        while(k>0&&!stack.isEmpty()){
            k--;
            stack.pop();
        }
        //for reversing the stack we use another stack
        Stack<Integer>st=new Stack<>();
        while(!stack.isEmpty())
            st.push(stack.pop());
        while(!st.isEmpty()&&st.peek()==0)
            st.pop();
        //for fast addition of character
        StringBuilder sb=new StringBuilder();
        while(!st.isEmpty())
            sb.append(st.pop());
        String res=sb.toString();
        
        return res.length()==0?"0":res;
 */