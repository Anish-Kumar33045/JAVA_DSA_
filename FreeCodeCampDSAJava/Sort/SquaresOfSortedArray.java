/*
 *  given int arr sorted in ascending order, return array of sqaures of each number in ascending order
 */

public class SquaresOfSortedArray {
    public int[] sortedSquares(int[] arr){
        int n=arr.length;
        int[] result = new int[n];
        int i=0 , j=n-1;
        for(int k=n-1; k>=0 ; k--){
            if(Math.abs(arr[i]) > Math.abs(arr[j])){
                result[k] = arr[i] * arr[i];
                i++;
            }
            else{
                result[k] = arr[j]*arr[j];
                j--;
            }
        }
        return result;
    }
    public void printArray(int[] arr){
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
     }

    public static void main(String[] args) {
        SquaresOfSortedArray obj = new SquaresOfSortedArray();
       int[] arr = new int[]{-4,-1,2,3,4};
        int[] result = obj.sortedSquares(arr);
        obj.printArray(result);
    }
}
 