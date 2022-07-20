import java.util.*;

public class excelSheetColumnTitle {
  public static void main(String[] args) {
    /*
     * Given an integer columnNumber, return its corresponding column title as it
     * appears in an Excel sheet.
     * 
     * For example:
     * A -> 1
     * B -> 2
     * C -> 3
     * ...
     * Z -> 26
     * AA -> 27
     * AB -> 28
     * ...
     */

    System.out.println(convertToTitle(52));
  }

  public static String convertToTitle(int columnNumber) {
    // load a-z inside of hashmap
    Map<Integer, String> map = new HashMap<Integer, String>() {
      int i = 1;
      {
        for (char ch = 'A'; ch <= 'Z'; ++ch) {
          put(i, String.valueOf(ch));
          i++;
        }

      }
    };

    if (columnNumber > map.size()) {
      //create these 2 new variables we declare inside the loop for optimal space
      // k for key, v for value
      String k = "";
      String v = "";

      // until n is less or equal to 26...
      while (columnNumber > map.size()) {

        // check if the current value of n % 26 == 0 if it is set v to map.get(26)
        if (columnNumber % map.size() == 0) {
         
          v = map.get(map.size());

          // deduct n
          columnNumber--;

        } else // otherwise set v to whatever mapped of n % 26 -> set k to v + k
          v = map.get(columnNumber % map.size());

          // basically checks if n is so large the output would result in 3 letters or more
          k = v + k;
          columnNumber /= map.size();
      }
      return map.get(columnNumber) + k;
    } 

    return map.get(columnNumber);
  }
}
/*
 * //load a-z inside of hashmap
 * Map<Integer, String> map = new HashMap<Integer, String>() {
 * int i = 1;
 * {
 * for (char ch = 'A'; ch <= 'Z'; ++ch){
 * put(i, String.valueOf(ch));
 * i++;
 * }
 * 
 * }
 * };
 * 
 * String title = "";
 * 
 * if(columnNumber > map.size()){
 * while(columnNumber > 0){
 * title += map.get(columnNumber % 10);
 * 
 * columnNumber /= 10;
 * }
 * }else{
 * title = map.get(columnNumber);
 * }
 * 
 * return title;
 * }
 * 
 * if (columnNumber > map.size()) {
 * 
 * //create these 2 new variables we declare inside the loop for optimal space
 * // k for key, v for value
 * String k = "";
 * String v = "";
 * 
 * // until n is less or equal to 26...
 * while (columnNumber > map.size()) {
 * // check if the current value of n % 26 == 0 if it is set v to map.get(26)
 * and
 * // deduct n
 * if (columnNumber % map.size() == 0) {
 * v = map.get(map.size());
 * columnNumber--;
 * } else { // otherwise set v to whatever mapped of n % 26 -> set k to v + k
 * (this
 * // basically checks if n is so large the output would result in 3 letters or
 * // more)
 * v = map.get(columnNumber % map.size());
 * k = v + k;
 * // divide n by 26
 * columnNumber /= map.size();
 * }
 * }
 * // finally return the columnNumber plus the key
 * return map.get(columnNumber) + k;
 * } else {
 * // if n is never greater than 26 just return the hash value of n
 * return map.get(columnNumber);
 * }
 */