public class longCommonPrefix {
    public static void main(String[] args) {
         /*
        Write a function to find the longest common prefix string amongst an array of strings. If there is no common prefix
        return "", maybe null? i.e, flower, float, fly -> 'fl' is the common prefix race, boat airplane -> "" or null
        */
        String[] str = {"flower", "flow", "flight"}; //expected: fl
       
        System.out.println(solution(str));
    }    

    public static String solution(String[] str){
        //have this be the first string value in the array
        String temp = str[0];

        //start at the second string value of the array, end at the last
        for(int i = 1; i<str.length; i++){
            
            //until the current index of str reaches 0 (indicating the begginning/furthest left value of the string, continue to build temp beginning at index 0 and ending at the eventual ending length of temp)
            while(str[i].indexOf(temp)!=0){
                temp = temp.substring(0, temp.length()-1);
            }
        }

        //return null if the string is empty otherwise return temp
        return (temp == null) ? ("") : (temp);
    }
}

