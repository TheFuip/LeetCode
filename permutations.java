import java.util.*;

public class permutations {
    public static void main(String[] args) {
        /*
         * Given an array of ditinct integers, return all the possible permutations.
         * You can return the answer in any order.
         */
        int[] nums = { 1, 2, 3 };
        System.out.println(permute(nums));
    }

    public static List<List<Integer>> permute(int[] nums) {
        return permutation(new ArrayList<>(),nums);
    }

    public static List<List<Integer>> permutation(List<Integer> p, int[] up){
        
        //if there is only 1 number inside of up return that number since it is the only permutation that can be made
        if(up.length==0){
            List<List<Integer>> sublist=new ArrayList<>();
            sublist.add(p);
            return sublist;
        }

        //set num to the first index value inside of up array
        int num=up[0];

        List<List<Integer>> ans = new ArrayList<>();

        //
        for(int i=0;i<=p.size();i++){

            List<Integer> new1=new ArrayList<>();

            new1.addAll(p.subList(0,i));
            new1.add(num);
            new1.addAll(p.subList(i,p.size()));
            ans.addAll(permutation(new1,Arrays.copyOfRange(up, 1, up.length)));
        }
        return ans;
    }
}
/*
 List<List<Integer>> list = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            List<Integer> numList = new ArrayList<>();

            numList.add(nums[i]);

            for (int j = 0; j < nums.length; j++) {
                if(!numList.contains(nums[j])){
                    numList.add(nums[j]);
                }
            }


            list.add(numList);
        }

        return list;
 */