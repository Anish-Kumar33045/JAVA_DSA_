/*
 *   Quick Sort -> divide and conquer algorithm
 * steps :-
 * 1) Pivot selection - we pick an element and mark it as pivot
 *     the pivot element can br first,last or random element.
 * 
 * 2) Partitioning - we reorder the array such that all the elements greater 
 *     than pivot comes after the pivot and smaller elements comes before pivot
 *      after this partitioning the pivot is at correct position.
 * 
 * 3) Recursion - recursively apply the above steps on the subarray formed to left
 *     side of pivot and on the subarray formed on the right side of pivot.
 * 
 * low to j-1 -> smaller & equal to pivot
 * j to i-1   -> greater element to pivot
 * i to high  -> yet to be traversed 
 * 
 *  
 */
public class QuickSort {
    // partititon step
    int partition(int[] arr,int low, int high){
        int pivot = arr[high]; // pivot selection step
       int i= low;
       int j= low;
       while(i<=high){
        if(arr[i]<=pivot){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            j++;
        }
        i++;
       } 
       return j-1; // index of partition
    }

    // Recursive step
    public void sort(int[] arr,int low, int high){
        if(low <high){ //base case 
          int p = partition(arr,low,high);
          sort(arr,low,p-1); // left subarray sort
          sort(arr,p+1,high); // right subarray sort
        }
    }

    public void PrintArray(int[] arr){
        for(int i=0; i<arr.length; i++){
           System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
         QuickSort obj = new QuickSort();
           int[] arr = new int[] {5,-2,3,1,6,3};
           obj.sort(arr, 0, 5);
           obj.PrintArray(arr);
    }
}
