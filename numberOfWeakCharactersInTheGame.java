
/**
 * numberOfWeakCharactersInTheGame
 */
import java.util.*;

public class numberOfWeakCharactersInTheGame {

    public static void main(String[] args) {
        /*
         * You are playing a game that contains multiple characters, and each of the
         * characters has two main properties: attack and defense. You are given a 2D
         * integer array properties where properties[i] = [attacki, defensei] represents
         * the properties of the ith character in the game.
         * 
         * A character is said to be weak if any other character has both attack and
         * defense levels strictly greater than this character's attack and defense
         * levels. More formally, a character i is said to be weak if there exists
         * another character j where attackj > attacki and defensej > defensei.
         * 
         * Return the number of weak characters.
         * 
         * Input: properties = [[5,5],[6,3],[3,6]]
         * Output: 0
         * Explanation: No character has strictly greater attack and defense than the
         * other.
         * 
         * Input: properties = [[1,5],[10,4],[4,3]]
         * Output: 1
         * Explanation: The third character is weak because the second character has a
         * strictly greater attack and defense.
         * 
         * 
         * [[1,1],[2,1],[2,2],[1,2]] -> 0
         */
        int[][] properties = { { 1, 1 }, { 2, 1 }, { 2, 2 }, {1,2} };

        System.out.println(numberOfWeakCharacters(properties));
    }

    //2 pointer + sorting solution
    public static int numberOfWeakCharacters(int[][] properties) {
        //sort the array to descending order of attack (greatest to smallest), to ascending order of defense (lowest to highest)
        Arrays.sort(properties, (a, b) -> (b[0] == a[0]) ? (a[1] - b[1]) : b[0] - a[0]);
        
        int count = 0;
        int max = Integer.MIN_VALUE;

        for(int i = 0; i < properties.length; i++){
           if(properties[i][1] < max){
            count++;
           }
           max = Math.max(max, properties[i][1]);
        }

        return count;
    }
}