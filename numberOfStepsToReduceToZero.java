public class numberOfStepsToReduceToZero {
    public static void main(String[] args) {
        /*
         * Given an integer num, return the number of steps to reduce it to zero.
         * In one step, if the current number is even you have to divide by 2.
         * Otherwise you have to subtract 1 from it
         */
        
        System.out.println(numberOfSteps(123));
    }    
    public static int numberOfSteps(int num){
        int count = 0;

        //until the number is less than 0 run this block of code
        while(num>0){
            //check if number is even -> divide by 2 the current value and increment the value of count
            if(num % 2 == 0){
                num /= 2;
                count++;
            }else{ //if not even, then it must be odd. Subtract 1 from the value of num, and increment count
                num -=1;
                count++;
            }
        }

        return count;
    }
}
