public class twoSum{
  public static void main(String[] args){
    int[] arr = {1,2,1,2};
    
    arr = solution(arr, 4);
    
    for(int i=0; i<arr.length; i++){
     System.out.print(arr[i] + ", "); 
    }
    
  }
  public static int[] solution(int[]array, int target){
        for(int i = 0; i<array.length; i++){
            for(int j = i + 1; j<array.length; j++){
                if(array[i] + array[j] == target){
                    return new int[] {i,j};
                }
            }
        }
        return new int[] {};
    }
}
