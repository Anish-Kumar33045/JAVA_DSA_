//Merge Sort 
// divide and Conquer algorithm.
 
/*
 * divide -> algorithm divides the array into two halves .
 *           the algorithm is carried out recursively for half arrays until there are no more half arrays to divide
 * 
 * conquer -> this step staring from bottom , we sort and merge the divided arrays and get the  sorted array.
 * 
 * in merge sort single array is soretd
 * use concept of merge two arrays in conquer step
 */


public class MergeSort {
    public void merge (int[] arr , int[]  temp, int low,int mid,int high){

        for(int i=low ; i<=high;i++){
           temp[i] = arr[i];
        }
        int i = low, j = mid+1 , k = low;

        while(i<=mid && j<= high){
            if(temp [i] <= temp[j]){
                arr[k] = temp[i];
                i++;
            }
            else{
                arr[k] = temp[j];
                j++;
            }
            k++;
        }

        while(i<=mid){
            arr[k] = temp[i];
            i++;
            k++;
        }
      
        }

        public void sort(int[] arr, int[] temp ,int low , int high){
         if(low<high){ //base case
             int mid = low+(high-low)/2;
             sort(arr,temp,low,mid); // low to mid ->left sub array
             sort(arr,temp,mid+1,high); // mid+1 to high -> right sub arrray
             merge(arr,temp,low,mid,high); //sort by merging
     
         }
     } 

    public void printArray(int[] arr){
        for(int i = 0 ; i<arr.length ; i++){
            System.out.print(arr[i]+" ");
        }
    }

   public static void main(String[] args) {
     int[] arr = new int[]{9,5,2,4,3};
     MergeSort obj = new MergeSort();
     obj.sort(arr, new int[arr.length] , 0, 4); // temp array -> new int[arr.length]
     obj.printArray(arr);
   } 
  
}
