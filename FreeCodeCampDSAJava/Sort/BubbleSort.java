
// also sinking sort
//   largest element sink at end of array on applying this sort on unsorted arr
// repeatedly compares and swaps if in wrong order
 
public class BubbleSort {
    public void bubbleSort(int[] arr){
        boolean isSwapped = false;
    for(int i = 0 ; i<arr.length-1 ; i++) { 
       for(int j = 0 ; j<arr.length - i - 1 ; j++){ 
        if(arr[j] > arr[j+1]){
           int temp = arr[j];
           arr[j] = arr[j+1];
           arr[j+1] = temp;
           isSwapped = true ;
        }
       }
       if(isSwapped == false) break; // if it's true then all elements are in order
     }
    } 
    public static void main(String[] args) {
        
    }
}
