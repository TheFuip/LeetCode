import java.util.*;

public class assignCookies {
    public static void main(String[] args) {
        /*
         * Assume you are an awesome parent and want to give your children some cookies.
         * But, you should give each child at most one cookie.
         * 
         * Each child i has a greed factor g[i], which is the minimum size of a cookie
         * that the child will be content with; and each cookie j has a size s[j]. If
         * s[j] >= g[i], we can assign the cookie j to the child i, and the child i will
         * be content. Your goal is to maximize the number of your content children and
         * output the maximum number.
         */
        int[] g = {1,2};
        int[] s = {1,2,3};

        System.out.println(findContentChildren(g, s));
    }
    //greedy
    public static int findContentChildren(int[] g, int[] s){
        if(s.length == 0 || g.length == 0){
            return 0;
        }

        //first sort both arrays (least to greatest)
        Arrays.sort(g);
        Arrays.sort(s);

        int count = 0;

        //here we start a loop that says -> loop until count == g.length-1 and i == s.length-1
        for(int i = 0; count < g.length && i < s.length; i++){
            //if the g[count] is less than or equal to s[i] we know we can share a cookie based on greed value, so increment count
            if(g[count] <= s[i]){
                count++;
            }
        }

        return count;
    }
}
