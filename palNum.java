import java.util.LinkedList;
import java.util.List;

public class palNum {
    public static void main(String[] args) {
        //palindrome number | no toString() method
        

        //solution(0);
        System.out.println(solution(12));
    }

    //no string solution
    public static boolean solution(int x){
        if(x<0) return false; //if x is negative automatically return false, if x is exactly 0 return true ... per requirements
        else if(x==0) return true;

        //instantiate a new linked list to hold each individual digit of x
        List<Integer> digits = new LinkedList<>();

         //while x is greater than 0, start at the end/right side of x and assign every value into the list
        while(x>0){
            //System.out.print(x % 10 + ", ");
            digits.add(x%10);
            x/=10; //divide 10 from x each time, so redundant values are not added into the list
       }
       
        //start at the first index of the list and constantly check the last index, subtracted by i to see if the value add up, if they do return true, otherwise return false
       for(int i = 0; i<digits.size(); i++){
        if(digits.get(i)!=digits.get(digits.size()-i-1)) return false;
       }

       return true;
       //return (((LinkedList<Integer>) digits).peek()!=digits.get(digits.size()-1)) ? (false) : (true);
    }

    //tostring solution
    public static boolean isPalindrome(int num){
        //convert the int value to a string, to use charAt method in order to avoid modulo division. charAt selects and integer from indexes
        String sNum = Integer.toString(num);
        //basically just have length-1, since indexes begin at 0 instead 1.
        int length = sNum.length()-1;
        //keeps track of how many integer idnexes are equal to each other, if they are the same increment count.
        int count = 0;

        for(int i = 0; i<sNum.length();i++){
            if(sNum.charAt(i)==sNum.charAt(length-i)) count++;
        }

        //return true if count is equal to the length of the number return true, otherwise return false.
        return (count==sNum.length()) ? (true) : (false);
    }
}
