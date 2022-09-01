import java.util.*;

public class queueReconstructionByHeight {
    public static void main(String[] args) {
        /*
         * You are given an array of people, people, which are the attributes of some
         * people in a queue (not necessarily in order). Each people[i] = [hi, ki]
         * represents the ith person of height hi with exactly ki other people in front
         * who have a height greater than or equal to hi.
         * 
         * Reconstruct and return the queue that is represented by the input array
         * people. The returned queue should be formatted as an array queue, where
         * queue[j] = [hj, kj] is the attributes of the jth person in the queue
         * (queue[0] is the person at the front of the queue
         */
        int[][] people = {{7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}};
        
        people = reconstructQueue(people);

        for(int row = 0; row < people.length; row++){
            for(int col = 0; col < people[row].length; col++){
                System.out.print(people[row][col] + ", ");
            }
            System.out.println();
        }
    }

    public static int[][] reconstructQueue(int[][] people){
        //sort the people based on heights in descending order.
        //if the have the same heights them sort them based on their index in ascending order.
        //the reason why is because we want smaller index people to come before others that have the same height
        Arrays.sort(people, (a, b) -> a[0] != b[0] ? b[0] - a[0] : a[1] - b[1]);

        List<int[]> ans = new ArrayList<>();

        //here we will populate the list by adding the current iteration of people to its correct position based on k or people[i][1]
        for(int i = 0; i < people.length; i++){
            ans.add(people[i][1], people[i]);
        }

        return ans.toArray(new int[people.length][2]);
    }
}
