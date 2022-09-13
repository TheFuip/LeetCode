import java.util.*;

public class bagOfTokens {
    public static void main(String[] args) {
        /*
         * You have an initial power of power, an initial score of 0, and a bag of
         * tokens where tokens[i] is the value of the ith token (0-indexed).
         * 
         * Your goal is to maximize your total score by potentially playing each token
         * in one of two ways:
         * 
         * If your current power is at least tokens[i], you may play the ith token face
         * up, losing tokens[i] power and gaining 1 score.
         * If your current score is at least 1, you may play the ith token face down,
         * gaining tokens[i] power and losing 1 score.
         * Each token may be played at most once and in any order. You do not have to
         * play all the tokens.
         * 
         * Return the largest possible score you can achieve after playing any number of
         * tokens.
         */
        int[] tokens = { 100, 200, 300, 400 };
        System.out.println(solution(tokens, 200));
    }

    // binary search approach x divide and conquer approach
    public static int solution(int[] tokens, int power) {
        Arrays.sort(tokens);

        if (power < tokens[0]) {
            return 0;
        }

        if (power >= tokens[tokens.length - 1]) {
            return tokens.length;
        }

        int start = 0;
        int end = tokens.length - 1;
        int max = 0;

        while (start <= end) {
            if (power >= tokens[start]) {
                max++;
                power -= tokens[start];
                start++;
            }
            if (end - start > 1) {
                power += tokens[end];
                end--;
                max--;
            }

        }
        return max;
    }
}
