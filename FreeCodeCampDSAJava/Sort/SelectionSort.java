// we divide array into sorted and unsorted array
// the alogoritm sorts an array by repeadely finding  the minimum in an unsorted array and making it part of the sorted array.
// from unsorted wepick mini element and swap with leftmost element of unsorted part. after swap ,that element becomes part of sorted array 
// repeated until unsorted is empty

public class SelectionSort {
     public void selectionSort(int[] arr){
        int n = arr.length;
        for(int i=0; i<n-1; i++){ //num of passes
              int min = i;
              for(int j=i+1; j<n ; j++){ 
                if(arr[j] < arr[min]){
                    min =j;
                }
              }
              int temp = arr[min];
              arr[min] = arr[i];
              arr[i] = temp;
        }
     }
    public static void main(String[] args) {
        
    }
}
 