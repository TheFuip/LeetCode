import java.util.ArrayList;
import java.util.List;

public class fizzBuzz {
    public static void main(String[] args) {
        /*
         * Given an integer, return a string array
         *  . "FizzBuzz" if i is divisible by 3 and 5
         *  . "Fizz" if i is divisible by 3
         *  . "Buzz" if i is divisible by 5
         *  . answer[i] == i (as a string) if none of the above conditions are true
         * EX: n = 3 -> ["1", "2", "Buzz"]
         * Ex: Input: n = 5 | Output: ["1","2","Fizz","4","Buzz"]
         * EX: Input: n = 15 | Output: ["1","2","Fizz","4","Buzz","Fizz","7","8","Fizz","Buzz","11","Fizz","13","14","FizzBuzz"]
         */
        System.out.println(fizzBuzz(15));
    }   

    public static List<String> fizzBuzz(int n){ 
        List<String> list = new ArrayList<>();

        //begin the loop at val 1, and stop until i is less than or equal to the value of n
        //from here just check if the current value of i is disible by these conditions
        for(int i = 1; i <= n; i++){
            //check for fizzbuzz characteristics
            //adds FizzBuzz
            if(i % 3 == 0 && i % 5 == 0){
                list.add("FizzBuzz");
            }else if(i % 3 == 0){
                list.add("Fizz");
            }else if(i % 5 == 0){
                list.add("Buzz");
            }else{
                list.add(Integer.toString(i));
            }
        }

        return list;
    }
}
