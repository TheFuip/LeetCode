public class findFirstAndLastPositionOfElementInSortedArray {
    public static void main(String[] args) {
        /*
         * Given an array of numbers, sorted in non-decreasing order.
         * Find the starting and ending position of a given target value.
         * If target is not found in the array return [-1, -1]
         * 
         * Write an algorithm in O(log n) runtime complexity
         * Dynamic Programming problem
         * 
         * EX: Input: nums = [5,7,7,8,8,10], target = 8
            Output: [3,4]

        EX: Input: nums = [], target = 0
            Output: [-1,-1]

        EX: nums = [1,2,3,4], target = 1
            Output: [0,0] -> since 1 is found at index 0
         */
        int[] nums = {5,7,7,8,8,10};

        for(int n : searchRange(nums, 8)){
            System.out.print(n + ", ");
        }
    }

    //maybe try an iterative approach as opposed to recursive; could maybe use a two pointer approach
    public static int[] searchRange(int[] nums, int target){
        if(nums.length < 1){
            return new int[]{-1,-1};
        }

        int[] ans = new int[2];

        ans[0] = traverseLeft(nums, target);
        ans[1] = traverseRight(nums, target);

        //ans[0] = otherfunction that traverses and assigns the index from the left(front) to assign the first val
        //ans[1] = otherfunction that traverses the index from the right(back) to assign the second val

        return ans;
    }

    //just do it iteratively instead of recursive. iterative is easier, and takes up less space than recursion + but will include recursive function
    //find the first value by traversing the array from the left
    public static int traverseLeft(int[] nums, int target){
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == target){
                return i;
            }
        }
        return -1;
    }

    public static int traverseRight(int[]nums, int target){
        for(int i = nums.length-1; i > -1; i--){
            if(nums[i] == target){
                return i;
            }
        }
        return -1;
    }

}

//optimize later...

/*
 * Working code: attempt 1
 * 
 *  //maybe try an iterative approach as opposed to recursive; could maybe use a two pointer approach
    public static int[] searchRange(int[] nums, int target){
        if(nums.length < 1){
            return new int[]{-1,-1};
        }

        int[] ans = new int[2];

        ans[0] = traverseLeft(nums, target);
        ans[1] = traverseRight(nums, target);

        //ans[0] = otherfunction that traverses and assigns the index from the left(front) to assign the first val
        //ans[1] = otherfunction that traverses the index from the right(back) to assign the second val

        return new int[]{ans[0], ans[1]};
    }

    //just do it iteratively instead of recursive. iterative is easier, and takes up less space than recursion + but will include recursive function
    //find the first value by traversing the array from the left
    public static int traverseLeft(int[] nums, int target){
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == target){
                return i;
            }
        }
        return -1;
    }

    public static int traverseRight(int[]nums, int target){
        for(int i = nums.length-1; i > -1; i--){
            if(nums[i] == target){
                return i;
            }
        }
        return -1;
    }
 */
