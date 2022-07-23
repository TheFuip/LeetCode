import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class minimumIndexSumOfTwoLists {
    public static void main(String[] args) {
        /*
         * Suppose Andy and Doris want to choose a restaurant for dinner, and they both
         * have a list of favorite restaurants represented by strings.
         * 
         * You need to help them find out their common interest with the least list
         * index sum.
         * If there is a choice tie between answers, output all of them with no order
         * requirement. You could assume there always exists an answer.
         */
        String[] list1 = { "Shogun", "Tapioca Express", "Burger King", "KFC" };
        String[] list2 = { "Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun" };

        String[] ans = findRestraunt(list1, list2);

        System.out.println(ans[0]);
    }

    public static String[] findRestraunt(String[] list1, String[] list2) {
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            map.put(list1[i], i);
        }

        List<String> res = new ArrayList<>();

        int min = Integer.MAX_VALUE;

        for (int i = 0; i < list2.length; i++) {

            if (map.containsKey(list2[i])) {

                int index1 = map.get(list2[i]);

                if (index1 + i < min) {

                    min = index1 + i;

                    res = new ArrayList<>();
                    
                    res.add(list2[i]);

                } else if (index1 + i == min) {
                    res.add(list2[i]);
                }
            }
        }
        String[] result = new String[res.size()];

        return res.toArray(result);
    }
}
