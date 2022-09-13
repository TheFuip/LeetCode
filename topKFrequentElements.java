import java.util.*;
public class topKFrequentElements {
    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3};

        for(int n : topKFrequent(nums, 2)){
            System.out.print(n + ", ");
        }
    }
    public static int[] topKFrequent(int[] nums, int k){
        if(nums.length == 1){
            return nums;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        

        for(int n : nums){
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        List<Integer> list = new ArrayList<>(map.keySet());
        Collections.sort(list, (a,b) -> map.get(b) - map.get(a));

        int[] ans = new int[k];
        
        for(int i = 0; i < k; i++){
            ans[i] = list.get(i);
        }
        
        return ans;
        //return list.stream().mapToInt(Integer::intValue).toArray();
        //return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
