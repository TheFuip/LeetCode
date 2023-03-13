public class findDigits {
    /*
     * Given an integer num, repeatedly add all its digits until the result has only one digit, and return it.
     * EX: 381 = 3 + 8 + 1 -> 12 -> 1 + 2 = 3
     * EX: 38 = 3 + 8 -> 11 -> 1 + 1 = 2
     */
    public static void main(String[] args) {
        System.out.println(solution(38));
    }

     /*
     * While number is greater than 9 (since we return the num if there is only 1 digit)
     * update the value of num such that it's new value becomes the first digit and the last digit in the number sequence
     * i.e: '38' -> 3 + 8 = 12 -> 1 + 2 = 3
     * --------------------------------------
     * num/10 = first digit in the sequence
     * num%10 = last digit in the sequence
     */
    public static int solution(int num){
        while(num > 9){
            num = (num / 10) + (num % 10);
        }
        return num;
    }
}
