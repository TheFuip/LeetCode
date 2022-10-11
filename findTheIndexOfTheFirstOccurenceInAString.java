public class findTheIndexOfTheFirstOccurenceInAString {
    public static void main(String[] args) {
        /*
         * Given two strings needle and haystack, return the index of the first
         * occurrence of needle in haystack, or -1 if needle is not part of haystack.
         */
        String haystack = "sadbutsad";
        String needle = "sad";

        System.out.println(strStr(haystack, needle));
    }

    //go awful solution, but O(n)^2 time complexity w/ constant space (yay) but but time complexity my god
    public static int strStr(String haystack, String needle) {
        if(needle.length() > haystack.length()){
            return -1;
        }

        for(int i = 0; i < haystack.length(); i++){
            //this is to avoid stringIndexOutOfBoundsException, s we check if i + the length of needle string is greater than the haystack (the main string) if it is there is no need to search anymore since the haystack has been searched completely
            if(i + needle.length() > haystack.length()){
                break;
            }
            for(int j = 0; j < needle.length(); j++){
                //if the haystack char of i + j does not equal the char value of j in the needle string, just end the loop, and increment the next i'th iteration
                if(haystack.charAt(i + j) != needle.charAt(j)){
                    break;
                }
                //if j has reached the end of the needle length, return the current value of i
                if(j == needle.length() - 1){
                    return i;
                }
            }
        }

        return -1;
    }
}
