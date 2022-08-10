import java.util.*;
public class twoOutOfThree {
    public static void main(String[] args) {
        /*
         * Given 3 integer arrays, return a distinct array containing all the values that are present in at least two of the
         * three arrays. You may return the values in any order.
         */
        int[]nums1 = {1,2,2};
        int[]nums2 = {5,4,3,3};
        int[]nums3 = {5,5,2};

        System.out.println(solution(nums1, nums2, nums3));
    }
    public static List<Integer> solution(int[]nums1, int[]nums2, int[]nums3){
        ArrayList<Integer> list = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();

        //only sort nums2 and nums3, since the set will add everything inside of nums1
        Arrays.sort(nums2);
        Arrays.sort(nums3);

        //populate the set with the values contained in the first array
        for(int n : nums1){
            set.add(n);
        }

        //set a temp pointer variable that is used to determine whether the next value is a duplicate of the previous
        int temp = 0;

        //check if the set already contains the value n and that temp is not equal to n and the value n is not contained in the list, if all this criteria is met add that value to the list
        for(int n : nums2){
            if(set.contains(n) && temp != n && !list.contains(n)){
                list.add(n);
            }
            //set temp to the current value inside of nums2
            temp = n;

            //add the value of temp to the set
            set.add(temp);
        }

        //reset temp to 0, incase the first value inside of nums3 was the last value inside of nums2
        temp = 0;

        //loop throgh nums3 check if the set already contains the n'th value and that temp is not set to n and that the value is not added to the list, if all this criteria is met add the n'th value contained in nums3 to the list
        for(int n : nums3){
            if(set.contains(n) && temp != n && !list.contains(n)){
                list.add(n);
            }

            //once again temp is used to prevent duplicitous values from getting added to the list inside of nums3
            temp = n;
        }

        return list;
    }
}

/*
 * alternative approach probably better and less complicated than this one tbh
 * 
 * Set<Integer> set1 = new HashSet<>(), set2 = new HashSet<>(), set3 = new HashSet<>(), set = new HashSet<>();
	for(int i: nums1) { set1.add(i); set.add(i); }
	for(int i: nums2) { set2.add(i); set.add(i); }
	for(int i: nums3) { set3.add(i); set.add(i); }
	List<Integer> result = new ArrayList<>();
	for(int i: set) 
		if(set1.contains(i) && set2.contains(i) || set2.contains(i) && set3.contains(i) || set1.contains(i) && set3.contains(i)) result.add(i);
	return result;
 */
