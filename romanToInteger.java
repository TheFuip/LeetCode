import java.util.HashMap;
import java.util.Map;

public class romanToInteger {
    public static void main(String[] args) {
        /*
        Return an int value based on a string roman numeral. i.e, III  -> 3
        Roman numerals are represented by 7 different symbols -> I, V, X, L, C, D and M
        . I = 1
        . V = 5
        . X = 10
        . L = 50
        . C = 100
        . D = 500
        . M = 1000
        */
        String str = "MCMXCIV"; //->  MCMXCIV = 1994

        //romantointeger(str.toUpperCase());
        System.out.println(romantointeger(str.toUpperCase()));      
    }
    public static int romantointeger(String str){
        Map<Character, Integer> map = new HashMap<>();

        //map with a char as the key and integer as the value, used to match roman numerals with numbers from the string parameter passed in the function
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        //num holds the furthest right value of the roman numerals contained in str
        int num = map.get(str.charAt(str.length()-1));

        //have the loop start at the second furthest right roman numeral as num already holds the furthest right value, end at the furthest left val in string or index 0
        for(int i = str.length()-2; i>=0; i--){
            //if the current roman char value is greater than the next roman value, increment the value to num, otherwise decrease/subtract the value based on the current index
            if(map.get(str.charAt(i)) >= map.get(str.charAt(i+1))){
                num+= map.get(str.charAt(i));
            }else{
                num -= map.get(str.charAt(i));
            }
        }
        
        return num;
    }
}
